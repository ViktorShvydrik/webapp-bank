package com.belhard.webappbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.security.authentication.BankAuthentication;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;
import com.belhard.webappbank.service.impl.ClientValidator;

@Controller
public class LoginControllers {
	
	@Autowired
	private ClientsService clientsService;
	
	@Autowired
	private ClientInfService clientInfService;
	
	@Autowired
	private BankAuthentication bankAuthentication;
	
	@Autowired
	private ClientValidator validator;
	
	private static final int NOT_SAVED = -1;

	private static final int ADMIN_ACCESS = 1;
	private static final int OPERATOR_ACCESS = 2;
	private static final int USER_ACCESS = 3;
	private static final int NO_ENTRY = 9;

	@RequestMapping("/index.html")
	public ModelAndView indexController(ClientBean client, 
										@RequestParam (value = "access-denided", required = false ) String error,
										@RequestParam (value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView("index.page", "clients", client);
		if(error != null){
			model.addObject("error", "The username or password is incorrect");
		}
		if(logout != null){
			model.addObject("logout", "Work is completed");
		}
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/index.html?logout=true";
	}
	
	@RequestMapping(value = "/access_denided.html", method = RequestMethod.GET)
	public String accessDenided(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/index.html?access-denided=true";
	}
	

	@RequestMapping(value = "/login")
	public ModelAndView loginController(HttpSession httpSession, ClientBean clientBean, ClientInfBean clientInfBean) {
		SecurityLoginBean bean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = bean.getUsername();
		clientBean = clientsService.getClient(login);
		ModelAndView model = new ModelAndView();
		// return model;

		switch (clientBean.getAccess()) {

		case ADMIN_ACCESS:
		case OPERATOR_ACCESS:
			model.setViewName("redirect:admin/index.html");
			return model;	
		case USER_ACCESS:
			if (clientBean.getInf() == null) {
				int id = clientBean.getIdClient();
				clientInfBean.setIdClient(id);
				model = new ModelAndView("reg.page", "clientsInf", clientInfBean);

				return model;
			}
			ClientAllInfBean allInfBean = clientInfService.getAllInfByClient(clientBean);
			httpSession.setAttribute("user", allInfBean);
			model = new ModelAndView("redirect:client/home.html");
			return model;

		case NO_ENTRY:
			model.setViewName("redirect:/index.html?access-denided=true");
			return model;
		}

		return new ModelAndView("index.page");
	}

	@RequestMapping(value = "/reg.html", method = RequestMethod.POST)
	public ModelAndView regController(@ModelAttribute ("clients") ClientBean client, ClientInfBean clientsInf, HttpServletRequest req, BindingResult result) {
		
		int id = clientsService.add(client);
		if (id == NOT_SAVED) {
			ModelAndView model = new ModelAndView("index.page");
			model.addObject("errorReg", "Incorrect data for registration");
			return model;
		}

		clientsInf.setIdClient(id);

		ModelAndView model = new ModelAndView("reg.page", "clientsInf", clientsInf);

		return model;
	}

	@RequestMapping(value = "/reginf.html", method = RequestMethod.POST)
	public String regIngController(ClientInfBean clientInf, HttpSession httpSession) {
		clientInfService.add(clientInf);
		int id = clientInf.getIdClient();
		ClientAllInfBean allInfBean = clientInfService.getAllInfById(id);
		httpSession.setAttribute("user", allInfBean);
		bankAuthentication.login(id);
		return "redirect:client/home.html";

	}
}

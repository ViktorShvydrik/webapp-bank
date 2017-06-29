package com.belhard.webappbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;

@Controller
public class Controllers {

	@Autowired
	ClientsService clientsService;

	@Autowired
	ClientInfService clientInfService;

	@Autowired
	CardsService cardsService;

	@Autowired
	AccountsService accountsService;

	private static final int NOT_SAVED = -1;

	private static final int ADMIN_ACCESS = 1;
	private static final int OPERATOR_ACCESS = 2;
	private static final int USER_ACCESS = 3;
	private static final int NO_ENTRY = 9;

	@RequestMapping("/index.html")
	public ModelAndView indexController(ClientBean client) {
		ModelAndView model = new ModelAndView("index.page", "clients", client);
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/index.html?logout";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView loginController(HttpSession httpSession, ClientBean clientBean, ClientInfBean clientInfBean,
			HttpServletRequest request, HttpServletResponse res) {

		clientBean = clientsService.login(clientBean);
		ClientAllInfBean allInfBean = clientInfService.getAllInfByClient(clientBean);
		httpSession.setAttribute("user", allInfBean);
		ModelAndView model = new ModelAndView("redirect:userPage.html");
		return model;

		/*
		 * switch (clientBean.getAccess()) {
		 * 
		 * case ADMIN_ACCESS: // break; case OPERATOR_ACCESS: // break; case
		 * USER_ACCESS: if (clientBean.getInf() == null) { int id =
		 * clientBean.getIdClient(); clientInfBean.setIdClient(id); model = new
		 * ModelAndView("reg.page", "clientsInf", clientInfBean);
		 * 
		 * return model; } ClientAllInfBean allInfBean =
		 * clientInfService.getAllInfByClient(clientBean);
		 * httpSession.setAttribute("user", allInfBean); model = new
		 * ModelAndView("redirect:userPage.html"); return model; case NO_ENTRY:
		 * // пользователя нет в базе, ошибки, отправка на индекс break; }
		 */

		// return new ModelAndView("index.page");
	}

	@RequestMapping(value = "/reg.html", method = RequestMethod.POST)
	public ModelAndView regController(ClientBean client, ClientInfBean clientsInf) {

		int id = clientsService.add(client);
		if (id == NOT_SAVED) {
			return new ModelAndView("index.page");
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
		return "user.page";

	}

	@RequestMapping("/userPage")
	public String userController(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			reloadInf(httpSession);
			return "user.page";
		}
		return "index.page";

	}

	@RequestMapping("/accounts")
	public String userAccountsController(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			allInfBean = reloadInf(httpSession);
			ClientBean client = allInfBean.getClient();

			List<AccountBean> list = accountsService.getAllByClient(client);
			httpSession.setAttribute("user_accounts", list);

			return "accounts.page";
		}

		return "index.page";
	}

	@RequestMapping("/newAccountUser.html")
	public String newAccountUser(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			allInfBean = accountsService.createByClient(allInfBean);
			httpSession.setAttribute("user", allInfBean);
			return "redirect:accounts.html";
		}
		return "index.page";

	}

	@RequestMapping("/cards")
	public String userCards(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			allInfBean = reloadInf(httpSession);
			List<CardBean> list = cardsService.getAllByClientId(allInfBean.getClient().getIdClient());
			httpSession.setAttribute("user_cards", list);

			return "cards.page";
		}
		return "index.page";
	}

	@RequestMapping("/refill.html")
	public String refill(HttpSession httpSession, RefillBean refill) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			allInfBean = reloadInf(httpSession);
			ClientBean client = allInfBean.getClient();

			List<AccountBean> list = accountsService.getAllByClient(client);
			httpSession.setAttribute("user_accounts", list);
			return "refill.page";
		}

		return "index.page";

	}

	@Deprecated
	@RequestMapping("/refillmoney.html")
	public String refillMoney(HttpSession httpSession, RefillBean refill) {
		accountsService.refill(refill);
		reloadInf(httpSession);

		return "redirect:refill.html";

	}

	private ClientAllInfBean reloadInf(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		ClientBean clientBean = allInfBean.getClient();
		allInfBean = clientInfService.getAllInfByClient(clientBean);
		httpSession.setAttribute("user", allInfBean);
		return allInfBean;

	}

	@ModelAttribute(name = "clientsInf")
	private ClientInfBean addinf() {
		return new ClientInfBean();
	}

	@ModelAttribute(name = "clients")
	private ClientBean addCl() {
		return new ClientBean();
	}

	@ModelAttribute(name = "refill")
	private RefillBean addRefill() {
		return new RefillBean();

	}

}

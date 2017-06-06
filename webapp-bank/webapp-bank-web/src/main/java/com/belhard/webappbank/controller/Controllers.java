package com.belhard.webappbank.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.entity.Refill;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;

@Controller
public class Controllers{
	
	
	private static final int ADMIN_ACCESS = 0;
	private static final int OPERATOR_ACCESS = 1;
	private static final int USER_ACCESS = 2;
	private static final int NO_ENTRY = 9;
	
	
	@RequestMapping ("/index.html")
	public ModelAndView indexController (){
		ModelAndView model = new ModelAndView("index", "clients", new Clients());
		return model;
	}

	@RequestMapping (value="/login.html",  method= RequestMethod.POST)
	public String loginController (ModelAndView model, HttpSession httpSession, Clients clients){
		
		ClientsService clientsService = (ClientsService) getBean("clientsService");
		clients = clientsService.login(clients);
		ClientInfService clientInfService = (ClientInfService) getBean("clientInfService");
		ClientInfTabl clientInfTabl = clientInfService.getAllInfById(clients.getId_client());
		if(clients.getId_client() != clientInfTabl.getIdClient()){
			return "reg";
		}
		switch (clients.getAccess()) {
		
		case ADMIN_ACCESS:
			//break;
		case OPERATOR_ACCESS:
			//break;	
		case USER_ACCESS: 
			httpSession.setAttribute("user",  clientInfTabl);
			model.setViewName("redirect:userPage");
			return "redirect:userPage";
		case NO_ENTRY: //пользователя нет в базе, ошибки, отправка на индекс
			break;
		} 
			
		return "index";
	}
	@RequestMapping (value="/reg.html",  method=RequestMethod.POST)
	public ModelAndView regController (Clients clients,ClientInf clientsInf){
		ClientsService clientsService = (ClientsService) getBean("clientsService");
			
		Integer id = clientsService.add(clients);
		clientsInf.setIdСlient(id); 		
		
		ModelAndView model = new ModelAndView("reg", "clientsInf", clientsInf);
		
		return model;
	}
	
	
	@RequestMapping(value="/reginf.html", method=RequestMethod.POST)
	public String regIngController(ClientInf clientInf){
		ClientInfService clientInfService = (ClientInfService) getBean("clientInfService");
		clientInfService.add(clientInf);
		
		return  "index";
		
	}
	
	
	@RequestMapping ("/userPage")
	public String userController (HttpSession httpSession){
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		if (clientInfTabl != null){
			return "userPage";
		}
		return "index";
		
	}
	
	@RequestMapping ("/accounts")
	public String userAccountsController(HttpSession httpSession){
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		if (clientInfTabl != null){
			int id = clientInfTabl.getIdClient();
			AccountsService accountsService  = (AccountsService) getBean("accountsService");
			
			List<Accounts> list = accountsService.getAllByIdClient(id);
			httpSession.setAttribute("user_accounts", list);
			
			return "accounts";
		}
		
		return "index";
	}
	
	@RequestMapping ("/newAccountUser.html")
	public String newAccountUser(HttpSession httpSession){
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		if (clientInfTabl != null){
		AccountsService accountsService  = (AccountsService) getBean("accountsService");
		clientInfTabl = accountsService.createByClient(clientInfTabl);
		httpSession.setAttribute("user",  clientInfTabl);
		return "redirect:accounts";
		}
		return "index";
		
	}
	
	@RequestMapping ("/cards")
	public String userCards(HttpSession httpSession){
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		if (clientInfTabl != null){
			CardsService cardsService  = (CardsService) getBean("cardsService");
			List<Cards> list = cardsService.getAllByClientId(clientInfTabl.getIdClient());
			httpSession.setAttribute("user_cards", list);
			
			return "cards";
		}
		return "index";
	}
	
	@RequestMapping("/cardsblock.html")
	public String blockCard(HttpServletRequest request){
		Integer id = Integer.valueOf(request.getParameter("id"));
		CardsService cardsService  = (CardsService) getBean("cardsService");
		cardsService.block(id);
		return "redirect:cards";
		
	}
	
	@RequestMapping ("/refill.html")
	public String refill(HttpSession httpSession, Refill refill){
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		if (clientInfTabl != null){
			int id = clientInfTabl.getIdClient();
			
			AccountsService accountsService  = (AccountsService) getBean("accountsService");
			
			List<Accounts> list = accountsService.getAllByIdClient(id);
			httpSession.setAttribute("user_accounts", list);
			return "refill";
		}
		
		return "index";
		
	}
	
	@RequestMapping  ("/refillmoney.html")
	public String refillMoney(HttpSession httpSession,  Refill refill ){
		AccountsService accountsService  = (AccountsService) getBean("accountsService");
		accountsService.refill(refill);
		reloadInf(httpSession);
		
		return "redirect:refill.html";
		
	}
	
	private void reloadInf (HttpSession httpSession){
		ClientInfService clientInfService = (ClientInfService) getBean("clientInfService");
		ClientInfTabl clientInfTabl = (ClientInfTabl) httpSession.getAttribute("user");
		int id = clientInfTabl.getIdClient();
		clientInfTabl= clientInfService.getAllInfById(id);
		httpSession.setAttribute("user",  clientInfTabl);
		
	}
	
	@ModelAttribute
	private ClientInf addinf(){
		return new ClientInf();
	}
	@ModelAttribute
	private Clients addCl(){
		return new Clients();
	}
	@ModelAttribute
	private Refill addRefill(){
		return new Refill();
		
	}
	
	
	private Object getBean(String beanName) {
		Object bean = null;

		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-web.xml"))  {
			bean = context.getBean(beanName);
		}

		return bean;
	}
}

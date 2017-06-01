package com.belhard.webappbank.controller;


import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;
import com.belhard.webappbank.entity.Clients;
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
	public ModelAndView loginController (ModelAndView model, HttpSession httpSession, Clients clients){
		
		ClientsService clientsService = (ClientsService) getBean("clientsService");
		clients = clientsService.login(clients);
		ClientInfService clientInfService = (ClientInfService) getBean("clientInfService");
		ClientInfTabl clientInfTabl = clientInfService.getAllInfById(clients.getId_client());
		if(clients.getId_client() != clientInfTabl.getIdClient()){
			model.setViewName("reg");
			model.addObject("clients", clients);
			return model;
		}
		switch (clients.getAccess()) {
		
		case ADMIN_ACCESS:
			//break;
		case OPERATOR_ACCESS:
			//break;	
		case USER_ACCESS: 
			httpSession.setAttribute("user", clientInfTabl);
			model.setViewName("redirect:userPage");
			return model;
		case NO_ENTRY: //пользователя нет в базе, ошибки, отправка на индекс
			break;
		} 
		model.setViewName("index");		
		return model;
	}
	@RequestMapping (value="/reg.html",  method=RequestMethod.POST)
	public ModelAndView regController (Clients clients,ClientInf clientsInf){
		ClientsService clientsService = (ClientsService) getBean("clientsService");
			
		Integer id = clientsService.add(clients);
		clientsInf.setId_client(id); 		
		
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
		Clients clients = (Clients) httpSession.getAttribute("user");
		if (clients != null){
			return "userPage";
		}
		return "index";
		
	}
	
	
	
	private Object getBean(String beanName) {
		Object bean = null;

		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-web.xml"))  {
			bean = context.getBean(beanName);
		}

		return bean;
	}
}

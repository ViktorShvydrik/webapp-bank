package com.belhard.webappbank.controller;


import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientsService;

@Controller
public class Controllers{
	
	
	private static final int ADMIN_ACCESS = 0;
	private static final int OPERATOR_ACCESS = 1;
	private static final int USER_ACCESS = 2;
	private static final int NO_ACCESS = 9;
	
	
	@RequestMapping ("/index.html")
	public ModelAndView indexController (){
		ModelAndView model = new ModelAndView("index", "clients", new Clients());
		return model;
	}

	@RequestMapping (value="/login.html",  method= RequestMethod.POST)
	public String loginController (Clients clients, HttpSession httpSession){
		ClientsService clientsService = (ClientsService) getBean("clientsService");
		clients = clientsService.login(clients);
		
		switch (clients.getAccess()) {
		
		case ADMIN_ACCESS:
			//break;
		case OPERATOR_ACCESS:
			//break;	
		case USER_ACCESS: 
			httpSession.setAttribute("user", clients);
			return "redirect:userPage";
		case NO_ACCESS: //пользователя нет в базе, ошибки, отправка на индекс
			break;
		} 
			
		
		return "index";
	}
	@RequestMapping (value="/reg.html",  method={RequestMethod.POST})
	public String regController (Clients clients){
		
		return "reg";
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

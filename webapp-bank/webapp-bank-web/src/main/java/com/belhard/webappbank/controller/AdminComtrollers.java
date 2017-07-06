package com.belhard.webappbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;

@Controller
@RequestMapping ("/admin")
public class AdminComtrollers {

	private static final int STATUS_OK = 0;
	private static final int STATUS_BLOCK = 1;
	private static final int STATUS_DELETE = 2;
	
	@Autowired
	private ClientsService clientsService;
	@Autowired
	private ClientInfService clientsInfService;
	@Autowired
	AccountsService accountService;
	
	@RequestMapping ("/index.html")
	public String index (HttpSession httpSession){
		List<ClientAllInfBean> allInf = clientsInfService.getAllInf();
		httpSession.setAttribute("users", allInf);
		return "adminIndex.page";
	}
	
	@RequestMapping ("/blockUser.html")
	public String blockClient(@RequestParam (name = "id") int id){
		clientsService.setStatus(id, STATUS_BLOCK);
		return "redirect:index.html";
	
	}	
	
	@RequestMapping ("/delUser.html")
	public String deleteClient(@RequestParam (name = "id") int id){
		clientsService.setStatus(id, STATUS_DELETE);
		return "redirect:index.html";
	
	}	
	
	@RequestMapping ("/unblock.html")
	public String unblockClient(@RequestParam (name = "id") int id){
		clientsService.setStatus(id, STATUS_OK);
		return "redirect:index.html";
	}
	
	
	@RequestMapping ("/accounts.html")
	public String accounts (HttpSession httpSession){
		List<AccountBean> list = accountService.getAll();
		httpSession.setAttribute("list_accounts", list);
		return "adminAcc.page";
	}
	
	@RequestMapping ("/blockAcc.html")
	public String blockAcc (@RequestParam (name = "id") int id){
		accountService.setStatus(id, STATUS_BLOCK);
		return "redirect:accounts.html";
	}
	
	@RequestMapping ("/delAcc.html")
	public String deletekAcc (@RequestParam (name = "id") int id){
		accountService.setStatus(id, STATUS_DELETE);
		return "redirect:accounts.html";
	}
	
	@RequestMapping ("/unblockAcc.html")
	public String unblockAcc (@RequestParam (name = "id") int id){
		accountService.setStatus(id, STATUS_OK);
		return "redirect:accounts.html";
	}
}

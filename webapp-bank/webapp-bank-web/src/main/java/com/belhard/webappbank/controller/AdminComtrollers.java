package com.belhard.webappbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;
import com.belhard.webappbank.service.TransfersService;

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
	private AccountsService accountService;
	@Autowired
	private TransfersService transfersService;
	@Autowired
	private CardsService cardsService;
	
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
	public ModelAndView accounts (HttpSession httpSession){
		List<AccountBean> list = accountService.getAll();
		httpSession.setAttribute("list_accounts", list);
		TransferBean transferBean = new TransferBean();
		return new ModelAndView("adminAcc.page","transfer", transferBean);
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
	
	@RequestMapping ("/accounts2step.html")
	public ModelAndView accountsTwoStep (@RequestParam (name = "acc1") int acc,TransferBean bean){
		AccountBean accountBean = new AccountBean();
		accountBean.setAccount(acc);
		bean.setFromAcc(accountBean);
		
		return new ModelAndView("adminAcc2.page", "transfer", bean);
		
	}
	@RequestMapping ("/accounts3step.html")
	public ModelAndView accountsThreeStep (@RequestParam (name = "acc1") int acc, @RequestParam (name = "acc2") int acc2, TransferBean bean){
		AccountBean accountBean = new AccountBean();
		accountBean.setAccount(acc2);
		bean.setToAcc(accountBean);
		accountBean = new AccountBean();
		accountBean.setAccount(acc);
		bean.setFromAcc(accountBean);
		
		return new ModelAndView("adminAcc.page", "transfer", bean);
		
	}
	
	@RequestMapping ("/refill.html")
	public ModelAndView refill (RefillBean refill, HttpSession httpSession){
		List<AccountBean> list = accountService.getAll();
		httpSession.setAttribute("list_accounts", list);
		return new ModelAndView("adminRefill.page", "refill", refill);
	}
	
	@RequestMapping ("/addRefillAcc.html")
	public ModelAndView addRefillAcc (@RequestParam (name = "acc") int acc, RefillBean refill){
		refill.setAccount(acc);
		return new ModelAndView("adminRefill.page", "refill", refill);
	}
	
	@RequestMapping ("/addMoney.html")
	public String addMoney (RefillBean refill){
		SecurityLoginBean bean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = bean.getUsername();
		accountService.refillByAccount(refill, username);
		return "redirect:refill.html";
	}
	
	@RequestMapping ("/transfers.html")
	public String transfers (HttpSession httpSession){
		
		List<TransferBean> list = transfersService.getAll();
		httpSession.setAttribute("transfers_list", list);
		return "adminTransfers.page";
	}
	
	
	@RequestMapping ("/addTransfer.html")
	public String addTransfer (TransferBean transferBean){
		SecurityLoginBean bean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = bean.getUsername();
		transferBean.setLogin(login);
		accountService.transfer(transferBean);
		return "redirect:accounts.html";
	}
	@RequestMapping ("/cards.html")
	public String cards (HttpSession httpSession){
		List<CardBean> all = cardsService.getAll();
		httpSession.setAttribute("user_cards", all);
		return "adminCards.page";
	}
	
/*	@ModelAttribute(name = "transfer")
	private TransferBean addTransB() {
		return new TransferBean();
	}*/
}

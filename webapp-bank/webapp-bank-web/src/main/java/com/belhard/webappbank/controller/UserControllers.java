package com.belhard.webappbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;
import com.belhard.webappbank.service.TransfersService;

@Controller
@RequestMapping("/client")
public class UserControllers {

	@Autowired
	private ClientsService clientsService;

	@Autowired
	private ClientInfService clientInfService;

	@Autowired
	private CardsService cardsService;

	@Autowired
	private AccountsService accountsService;

	@Autowired
	private TransfersService transfersService;

	

	
	
	private static final int LAST_FEW = 5;

	

	@RequestMapping("/home.html")
	public String userController(HttpSession httpSession) {
		reloadInf(httpSession);
		return "user.page";
		

	}

	@RequestMapping("/accounts")
	public String userAccountsController(HttpSession httpSession) {
			ClientAllInfBean allInfBean = reloadInf(httpSession);
			ClientBean client = allInfBean.getClient();

			List<AccountBean> list = accountsService.getAllByClient(client);
			httpSession.setAttribute("user_accounts", list);

			return "accounts.page";
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
			ClientAllInfBean allInfBean = reloadInf(httpSession);
			List<CardBean> list = cardsService.getAllByClientId(allInfBean.getClient().getIdClient());
			httpSession.setAttribute("user_cards", list);

			return "cards.page";
		}

	@RequestMapping("/refill.html")
	public String refill(HttpSession httpSession, RefillBean refill) {
			ClientAllInfBean allInfBean = reloadInf(httpSession);
			ClientBean client = allInfBean.getClient();

			List<AccountBean> list = accountsService.getAllByClient(client);
			httpSession.setAttribute("user_accounts", list);
			return "refill.page";
		}


	@RequestMapping("transfers/transfers.html")
	public String allTransfers(HttpSession httpSession) {
		ClientBean clientBean = getClientBean();
		List<TransferBean> list = transfersService.getAllByClient(clientBean);
		httpSession.setAttribute("transfers_list", list);
		return "transfers.page";
	}

	@RequestMapping("transfers/betweenOwnAcc.html")
	public String betweenOwnAcc(HttpSession httpSession) {
		ClientBean clientBean = getClientBean();
		List<TransferBean> list = transfersService.getLastFewByClient(clientBean, LAST_FEW);
		httpSession.setAttribute("transfers_list", list);
		List<AccountBean> listAcc = accountsService.getAllByClient(clientBean);
		httpSession.setAttribute("user_accounts", listAcc);
		return "betweenOwnAcc.page";
	}
	
	@RequestMapping("transfers/transfersToAll.html")
	public String transfersToAll(HttpSession httpSession) {
		ClientBean clientBean = getClientBean();
		List<TransferBean> list = transfersService.getLastFewByClient(clientBean, LAST_FEW);
		httpSession.setAttribute("transfers_list", list);
		List<AccountBean> listAcc = accountsService.getAllByClient(clientBean);
		httpSession.setAttribute("user_accounts", listAcc);
		return "transfersToAll.page";
	}
	
	
	//PROFIL
	
	@RequestMapping ("/my_profil.html")
	public ModelAndView myProfil (ClientAllInfBean allInfBean, HttpSession httpSession){
		ClientBean clientBean = getClientBean();
		allInfBean = clientInfService.getAllInfByClient(clientBean);
		ModelAndView model = new ModelAndView("profil.page", "user", allInfBean);
		return model;
	}
	
	@RequestMapping ("/profiledit.html")
	public ModelAndView profiledit (ClientAllInfBean allInfBean, HttpSession httpSession){
		ClientBean clientAuth = getClientBean();
		ClientBean clientBean = allInfBean.getClient();
		if (clientBean.getPass().equals("") ){
		}else{
			String newPass = clientBean.getPass();
			clientAuth.setPass(newPass);
		}
		String newLogin = clientBean.getLogin();
		ClientInfBean inf = clientAuth.getInf();
		String newEmail = clientBean.getInf().getEmail();
		String newName = clientBean.getInf().getName();
		String newSecondName = clientBean.getInf().getSecondName();
		inf.setEmail(newEmail);
		inf.setName(newName);
		inf.setSecondName(newSecondName);
		clientAuth.setInf(inf);
		clientAuth.setLogin(newLogin);
		allInfBean.setClient(clientAuth);
		clientInfService.editInf(allInfBean);
		ModelAndView model = new ModelAndView("adminProfil.page", "user", allInfBean);
		return model;
	}
	
	//END PROFIL

	private ClientAllInfBean reloadInf(HttpSession httpSession) {
		SecurityLoginBean loginBean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = loginBean.getUsername();
		ClientAllInfBean allInfBean = clientInfService.getAllInfByLogin(login);
		httpSession.setAttribute("user", allInfBean);
		return allInfBean;

	}

	private ClientBean getClientBean() {
		SecurityLoginBean loginBean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = loginBean.getUsername();
		ClientBean clientBean = clientsService.getClient(login);
		return clientBean;
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

	@ModelAttribute(name = "transfer")
	private TransferBean addTransB() {
		return new TransferBean();
	}

}

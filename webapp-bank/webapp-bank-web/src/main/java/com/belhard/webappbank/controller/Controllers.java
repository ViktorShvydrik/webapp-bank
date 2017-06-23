package com.belhard.webappbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	private static final int ADMIN_ACCESS = 0;
	private static final int OPERATOR_ACCESS = 1;
	private static final int USER_ACCESS = 2;
	private static final int NO_ENTRY = 9;

	@RequestMapping("/index.html")
	public ModelAndView indexController(ClientBean client) {
		ModelAndView model = new ModelAndView("index", "clients", client);
		return model;
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String loginController(HttpSession httpSession, ClientBean clientBean) {

		clientBean = clientsService.login(clientBean);
		ClientAllInfBean allInfBean = clientInfService.getAllInfById(clientBean);
		if (clientBean.getIdClient() != allInfBean.getClient().getIdClient()) {
			return "reg";
		}
		switch (clientBean.getAccess()) {

		case ADMIN_ACCESS:
			// break;
		case OPERATOR_ACCESS:
			// break;
		case USER_ACCESS:
			httpSession.setAttribute("user", allInfBean);
			return "redirect:userPage";
		case NO_ENTRY: // пользователя нет в базе, ошибки, отправка на индекс
			break;
		}

		return "index";
	}

	@RequestMapping(value = "/reg.html", method = RequestMethod.POST)
	public ModelAndView regController(ClientBean client, ClientInfBean clientsInf) {

		int id = clientsService.add(client);
		clientsInf.setIdClient(id);

		ModelAndView model = new ModelAndView("reg", "clientsInf", clientsInf);

		return model;
	}

	@RequestMapping(value = "/reginf.html", method = RequestMethod.POST)
	public String regIngController(ClientInfBean clientInf) {
		clientInfService.add(clientInf);

		return "index";

	}

	@RequestMapping("/userPage")
	public String userController(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			return "userPage";
		}
		return "index";

	}

	@RequestMapping("/accounts")
	public String userAccountsController(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			ClientBean client = allInfBean.getClient();

			List<AccountBean> list = accountsService.getAllByClient(client);
			httpSession.setAttribute("user_accounts", list);

			return "accounts";
		}

		return "index";
	}

	@RequestMapping("/newAccountUser.html")
	public String newAccountUser(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			allInfBean = accountsService.createByClient(allInfBean);
			httpSession.setAttribute("user", allInfBean);
			return "redirect:accounts";
		}
		return "index";

	}

	@RequestMapping("/cards")
	public String userCards(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			List<CardBean> list = cardsService.getAllByClientId(allInfBean.getClient().getIdClient());
			httpSession.setAttribute("user_cards", list);

			return "cards";
		}
		return "index";
	}

	@RequestMapping("/cardsblock.html")
	public String blockCard(@RequestParam("id") int id) {

		cardsService.block(id);
		return "redirect:cards";
	}

	@RequestMapping("/cardsunblock.html")
	public String unBlockCard(@RequestParam("id") int id) {
		cardsService.unBlock(id);
		return "redirect:cards";
	}

	@RequestMapping("/refill.html")
	public String refill(HttpSession httpSession, RefillBean refill) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		if (allInfBean != null) {
			ClientBean client = allInfBean.getClient();

			// List<Accounts> list = accountsService.getAllByIdClient(id);
			// httpSession.setAttribute("user_accounts", list);
			return "refill";
		}

		return "index";

	}

	@RequestMapping("/refillmoney.html")
	public String refillMoney(HttpSession httpSession, RefillBean refill) {
		// accountsService.refill(refill);
		// reloadInf(httpSession);

		return "redirect:refill.html";

	}

	private void reloadInf(HttpSession httpSession) {
		ClientAllInfBean allInfBean = (ClientAllInfBean) httpSession.getAttribute("user");
		ClientBean clientBean = allInfBean.getClient();
		allInfBean = clientInfService.getAllInfById(clientBean);
		httpSession.setAttribute("user", allInfBean);

	}

	@ModelAttribute
	private ClientInfBean addinf() {
		return new ClientInfBean();
	}

	@ModelAttribute(name = "clients")
	private ClientBean addCl() {
		return new ClientBean();
	}

	@ModelAttribute
	private RefillBean addRefill() {
		return new RefillBean();

	}

}

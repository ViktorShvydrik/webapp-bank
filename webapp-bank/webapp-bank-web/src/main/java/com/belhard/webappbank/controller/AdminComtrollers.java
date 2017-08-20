package com.belhard.webappbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.ResponseCodeBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.ClientsService;
import com.belhard.webappbank.service.TransfersService;
import com.belhard.webappbank.service.Exception.AccountsServiceException;
import com.belhard.webappbank.service.Exception.RefillExeption;

@Controller
@RequestMapping ("/admin")
public class AdminComtrollers {

	private static final int STATUS_OK = 0;
	private static final int STATUS_BLOCK = 1;
	private static final int STATUS_DELETE = 2;
	private static final int NUMBER_OF_CARACTERS = 8;
	
	private static final int ERROR_REFILL = 1;
	
	private static final int SUCCESSFULLY_PROFIL_EDIT = 11;
	
	@Autowired
	private ClientsService clientsService;
	@Autowired
	private ClientInfService clientInfService;
	@Autowired
	private AccountsService accountService;
	@Autowired
	private TransfersService transfersService;
	@Autowired
	private CardsService cardsService;
	
	//INDEX
	
	@RequestMapping ("/index.html")
	public String index (HttpSession httpSession, HttpServletRequest httpServletRequest){
		List<ClientAllInfBean> allInf = clientInfService.getAllInf();
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
	
	@RequestMapping ("/acessUp.html")
	public String accessUp (@RequestParam ("id") int id){
		clientsService.accessUp(id);
		return "redirect:index.html";
	}
	
	//END INDEX
	
	//ACCOUNT
	
	@RequestMapping ("/accounts.html")
	public ModelAndView accounts (HttpSession httpSession){
		List<AccountBean> list = accountService.getAll();
		httpSession.setAttribute("list_accounts", list);
		TransferBean transferBean = new TransferBean();
		return new ModelAndView("adminAcc.page","transfer", transferBean);
	}
	
	@RequestMapping ("/accounts_client.html")
	public ModelAndView accClient (@RequestParam (name = "login") String login, HttpServletRequest req){
		ClientBean bean = new ClientBean();
		if(!StringUtils.isEmpty(login)){
			bean = clientsService.getClient(login);
			List<AccountBean> list = accountService.getAllByClient(bean);
			req.setAttribute("accounts_client", list);
			req.setAttribute("visit", 2);
		}
		ModelAndView model = new ModelAndView("adminAccClient.page");
		model.addObject("client", bean);
		return model;
	}
	
	@RequestMapping ("/accounts_cl.html")
	public String accClient (HttpServletRequest req){
		List<AccountBean> list =  new ArrayList<>();
		req.setAttribute("accounts_client", list);
		req.setAttribute("visit", 1);
		return "adminAccClient.page";
	}
	
	
	@RequestMapping ("/blockAcc.html")
	public String blockAcc (@RequestParam (name = "id") int id, HttpServletRequest req){
		try {
		AccountBean accountBean = accountService.setStatus(id, STATUS_BLOCK);
		req.setAttribute("ok", accountBean);
		}catch (AccountsServiceException e) {			
			req.setAttribute("error", 1);
			return "adminAcc.page";
		}
		return "redirect:accounts.html";
	}
	
	@RequestMapping ("/delAcc.html")
	public String deletekAcc (@RequestParam (name = "id") int id, HttpServletRequest req){
		try {
			AccountBean accountBean = accountService.setStatus(id, STATUS_DELETE);
			req.setAttribute("ok", accountBean);
	}catch (AccountsServiceException e) {
		req.setAttribute("error", 1);
		return "adminAcc.page";
	}
		return "redirect:accounts.html";
	}
	
	@RequestMapping ("/unblockAcc.html")
	public String unblockAcc (@RequestParam (name = "id") int id, HttpServletRequest req){
		try {
			AccountBean accountBean = accountService.setStatus(id, STATUS_OK);
			req.setAttribute("ok", accountBean);
	}catch (AccountsServiceException e) {
		req.setAttribute("error", 1);
		return "adminAcc.page";
	}
		return "redirect:accounts.html";
	}
	
	@RequestMapping ("/reloadacc.html")
	public String relodAccInf (){
		accountService.reloadInf();
		return "redirect:accounts.html";
	}
	
	//END ACCOUNT
	
	//TRANSFERS
	
	@RequestMapping ("/refill.html")
	public ModelAndView refillview (RefillBean refill, HttpServletRequest req){
		List<AccountBean> list = accountService.getAll();
		req.setAttribute("list_accounts", list);
		return new ModelAndView("adminRefill.page", "refill", refill);
	}
	
	
	@RequestMapping ("/addRefillAcc.html")
	public ModelAndView addRefillAcc (@RequestParam (name = "acc") int acc, RefillBean refill){
		refill.setAccount(acc);
		return new ModelAndView("adminRefill.page", "refill", refill);
	}
	
	@RequestMapping ("/addrefill.html")
	public String refill (RefillBean refill, HttpServletRequest req){
		SecurityLoginBean bean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = bean.getUsername();
		try{
			accountService.refillByAccount(refill, username);
		}catch (RefillExeption e) {
			String msg = e.getMessage();
			int code = ERROR_REFILL;
			ResponseCodeBean codeBean = new ResponseCodeBean(code, msg, refill);
			req.setAttribute("error", codeBean);
			return "error.page";
		}
		
		return "redirect:refill.html";
	}
	
	@RequestMapping ("/transfers.html")
	public String transfers (HttpServletRequest req){
		
		List<TransferBean> list = transfersService.getAll();
		req.setAttribute("transfers_list", list);
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
	
	//END TRANSFERS
	
	// CARD
	
	@RequestMapping ("/cards.html")
	public String cards (HttpServletRequest req){
		List<CardBean> all = cardsService.getAll();
		req.setAttribute("users_cards", all);
		return "adminCards.page";
	}
	
	@RequestMapping ("/cardscl.html")
	public ModelAndView cardsCl (@RequestParam ("login") String login, HttpSession  httpSession ){
		ClientBean bean = new ClientBean();
		bean.setLogin(login);
		if(!StringUtils.isEmpty(login)){
			bean = clientsService.getClient(login);
			List<CardBean> list = cardsService.getAllByClientId(bean.getIdClient());
			httpSession.setAttribute("user_cards", list);
		}
		CardBean cardBean = new CardBean();
		cardBean.setLogin(login);
		ModelAndView model = new ModelAndView("adminCardsClient.page");
		model.addObject("client", bean);
		model.addObject("card", cardBean);
		List<AccountBean> list = accountService.getAllByClient(bean);
		httpSession.setAttribute("user_accounts", list);
		return model;
		
	}
	
	@RequestMapping ("/cardsclient.html")
	public ModelAndView cardsClient (HttpSession httpSession){
		ClientBean bean = new ClientBean();
		return new ModelAndView("adminCardsClient.page", "client", bean);
	}

	@RequestMapping ("/newcard.html")
	public String newCard (CardBean cardBean){
		cardsService.createCard(cardBean);
		String login = cardBean.getLogin();
		return "redirect:cardscl.html?login=" + login ;
		
	}
	
	//END CARD
	
	@RequestMapping ("/profil.html")
	public ModelAndView profil (ClientAllInfBean allInfBean){
		
		return new ModelAndView("adminProfil.page", "user", allInfBean) ;
		
	}
	
	@RequestMapping ("/profilcl.html")
	public ModelAndView profilCl (@RequestParam ("client.login") String login, ClientAllInfBean allInfBean){

			ClientBean client = clientsService.getClient(login);
			allInfBean = clientInfService.getAllInfByClient(client);
		if(allInfBean.getClient().getInf() == null){
			ClientBean clientBean =  allInfBean.getClient();
			int id = client.getIdClient();
			ClientInfBean infBean = new ClientInfBean();
			infBean.setIdClient(id);
			clientBean.setInf(infBean);
			allInfBean.setClient(clientBean);
		}
		ModelAndView model = new ModelAndView("adminProfil.page", "user", allInfBean);
		return model;
		
	}
	
	@RequestMapping ("/profiledit.html")
	public String profiledit (ClientAllInfBean allInfBean, HttpSession httpSession){
		ClientBean clientBean = allInfBean.getClient();
		if (clientBean.getPass().equals("") ){
			int id = clientBean.getIdClient();
			ClientBean client = clientsService.getClient(id);
			String pass = client.getPass();
			clientBean.setPass(pass);
			allInfBean.setClient(clientBean);
		}
		clientInfService.editInf(allInfBean);
		ResponseCodeBean codeBean =  new ResponseCodeBean(SUCCESSFULLY_PROFIL_EDIT, clientBean);
		
		httpSession.setAttribute("successfully", codeBean);
		return "redirect:successfully.html";
	}
	
	
	
	@RequestMapping ("/my_profil.html")
	public ModelAndView myProfil (ClientAllInfBean allInfBean){
		ClientBean clientBean = getClientBean();
		allInfBean = clientInfService.getAllInfByClient(clientBean);
		ModelAndView model = new ModelAndView("adminProfil.page", "user", allInfBean);
		return model;
	}
	
	
	
	@RequestMapping ("/newclient.html")
	public ModelAndView newClient (ClientAllInfBean allInfBean){
		
		ModelAndView model = new ModelAndView("adminCreateClient.page", "user", allInfBean);
		return model;
	}
	
	@RequestMapping ("/createclient.html")
	public ModelAndView creteClient(ClientAllInfBean allInfBean, HttpSession httpSession){
		String pass = generatePass(NUMBER_OF_CARACTERS);
		int count = clientsService.countClient();
		String clientLogin = "user"+count;
		ClientBean clientBean = new ClientBean();
		clientBean.setLogin(clientLogin);
		clientBean.setPass(pass);
		clientsService.add(clientBean);
		allInfBean.setClient(clientBean);
		ModelAndView model = new ModelAndView("adminCreateClient.page", "user", allInfBean);
		return model;
	}
	
	@RequestMapping ("/successfully.html")
	public String successfully (HttpServletRequest req, HttpSession httpSession){
		ResponseCodeBean codeBean = (ResponseCodeBean)httpSession.getAttribute("successfully");
		httpSession.removeAttribute("successfully");
		req.setAttribute("successfully", codeBean);
		return "successfully.page";
	}
	
	
	
	@ModelAttribute (name = "card")
	private CardBean card (){
		return new CardBean();
	}
	
	@ModelAttribute (name = "client")
	private ClientBean client(){
		return new ClientBean();
	}
	
	private ClientBean getClientBean() {
		SecurityLoginBean loginBean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = loginBean.getUsername();
		ClientBean clientBean = clientsService.getClient(login);
		return clientBean;
	}
	
	private String generatePass(int quantity) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int cntchars  = quantity;
        String pass = "";

        for (int i = 0; i < cntchars; ++i) {
            char next = 0;
            int range = 10;

            switch(r.nextInt(3)) {
                case 0: {next = '0'; range = 10;} break;
                case 1: {next = 'a'; range = 26;} break;
                case 2: {next = 'A'; range = 26;} break;
            }

            sb.append((char)((r.nextInt(range)) + next));
        }
        pass = sb.toString();
        return pass;
    }

	@ModelAttribute ("transfer")
	private TransferBean transfer (){
		return new TransferBean();
	}
}

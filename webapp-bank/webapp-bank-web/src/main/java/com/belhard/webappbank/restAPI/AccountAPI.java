package com.belhard.webappbank.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.security.bean.SecurityLoginBean;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.ClientsService;

@RestController
@RequestMapping(value = "/rest/users", produces = "application/json")
public class AccountAPI {

	@Autowired
	private AccountsService accountsService;

	@Autowired
	private ClientsService clientsService;

	@ResponseBody
	@RequestMapping(value = "/{id}/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<AccountBean>> getAllAccountsByClientId(@PathVariable Integer id) {
		ClientBean clientBean = clientsService.getClient(id);
		List<AccountBean> list = accountsService.getAllByClient(clientBean);
		return new ResponseEntity<List<AccountBean>>(list, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccountBean> getAccount(@PathVariable Integer id) {
		AccountBean accountBean = accountsService.getById(id);
		return new ResponseEntity<AccountBean>(accountBean, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/{id}/accounts", method = RequestMethod.PUT)
	public ResponseEntity<AccountBean> putAccount(@PathVariable Integer id) {
		AccountBean accountBean = accountsService.createByIdClient(id);
		return new ResponseEntity<AccountBean>(accountBean, HttpStatus.CREATED);

	}

	@ResponseBody
	@RequestMapping(value = "/accounts/{id}/{money}", method = RequestMethod.POST)
	public ResponseEntity<AccountBean> putRefill(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "money") Integer money) {
		RefillBean refillBean = new RefillBean(id, money);
		SecurityLoginBean loginBean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = loginBean.getUsername();
		AccountBean accountBean = accountsService.refillById(refillBean, login);
		return new ResponseEntity<AccountBean>(accountBean, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping (value = "/accounts/{accA}/Transfer/{accB}/{money}", method = RequestMethod.POST)
	public ResponseEntity<TransferBean> transfer (@PathVariable (name = "accA") int accA,
												  @PathVariable (name = "accB") int accB,
												  @PathVariable (name = "money") int money){
		SecurityLoginBean loginBean = (SecurityLoginBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String login = loginBean.getUsername();
		TransferBean transferBean = new TransferBean(accA, money, accB, login);
		transferBean = accountsService.transfer(transferBean);
		
		return new ResponseEntity<TransferBean>(transferBean, HttpStatus.OK);
	}

}


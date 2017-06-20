package com.belhard.webappbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
public class AccountsServiceImpl implements AccountsService{

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private ClientInfDao clientInfDao;
	
	private ClientInfService clientInfService;
	@Autowired
	private EntityBeanConverter converter;

	/*@Override
	public Accounts getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public ClientAllInfBean createByClient(ClientAllInfBean allInfBean) {
		int id = 0;
		id = allInfBean.getClient().getIdClient();
		accountsDao.create(id);
		int count = accountsDao.countAllByClient(id);
		ClientInf clientInf = clientInfDao.findOne(id);
		clientInf.setAccounts(count);
		clientInfDao.save(clientInf);
		allInfBean = clientInfService.getAllInfById(allInfBean.getClient());
		
		return allInfBean;
	}

	@Override
	public void refill(RefillBean refill) {
		int id = refill.getIdAccount();
		//Accounts accounts = accountsDao.getByID(id);
		//int money = accounts.getMoney() + refill.getMoney();
		//accounts.setMoney(money);
		//accountsDao.update(accounts);
		
		
	}

	@Override
	public Iterable<Accounts> getAllByClient(ClientBean client) {
		int id = client.getIdClient();
		
		return accountsDao.accbyIdClient(id);
	}








}

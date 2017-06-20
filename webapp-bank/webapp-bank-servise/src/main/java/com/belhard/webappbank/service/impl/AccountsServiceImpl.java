package com.belhard.webappbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
public class AccountsServiceImpl implements AccountsService{

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private ClientInfDao clientInfDao;
	@Autowired
	private EntityBeanConverter converter;

	@Override
	public Accounts getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public ClientInfTabl createByClient(ClientInfTabl clientInfTabl) {
		int id = 0;
		id = clientInfTabl.getIdClient();
		accountsDao.create(id);
		int count = accountsDao.countAccounts(id);
		ClientInf clientInf = clientInfDao.getByID(id);
		clientInf.setAccounts(count);
		clientInfDao.update(clientInf);
		clientInfTabl = clientInfDao.getAllInfByID(id);
		
		return clientInfTabl;
	}*/

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

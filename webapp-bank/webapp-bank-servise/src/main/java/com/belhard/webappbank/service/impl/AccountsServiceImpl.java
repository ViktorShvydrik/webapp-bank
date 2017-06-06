package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;
import com.belhard.webappbank.entity.Refill;
import com.belhard.webappbank.service.AccountsService;

public class AccountsServiceImpl implements AccountsService{

	private AccountsDao accountsDao;
	private ClientInfDao clientInfDao;
	
		
	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	public void setClientInfDao(ClientInfDao clientInfDao) {
		this.clientInfDao = clientInfDao;
	}

	@Override
	public List<Accounts> getAllByIdClient(int id) {
		
		return accountsDao.getAllByIdClient(id);
	}

	@Override
	public Accounts getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
	}

	@Override
	public void refill(Refill refill) {
		int id = refill.getIdAccount();
		Accounts accounts = accountsDao.getByID(id);
		int money = accounts.getMoney() + refill.getMoney();
		accounts.setMoney(money);
		accountsDao.update(accounts);
		
		
	}



}

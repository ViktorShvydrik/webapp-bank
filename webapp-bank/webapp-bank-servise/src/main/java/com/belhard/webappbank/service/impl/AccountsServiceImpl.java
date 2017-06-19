package com.belhard.webappbank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService{

	private AccountsDao accountsDao;
	private ClientInfDao clientInfDao;
	
		
	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	public void setClientInfDao(ClientInfDao clientInfDao) {
		this.clientInfDao = clientInfDao;
	}

	/*@Override
	public List<Accounts> getAllByIdClient(int id) {
		
		return accountsDao.getAllByIdClient(id);
	}*/

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
	public List<Accounts> getAllByIdClient(ClientBean client) {
		// TODO Auto-generated method stub
		return null;
	}








}

package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.service.AccountsService;

public class AccountsServiceImpl implements AccountsService{

	private AccountsDao accountsDao;
	
		
	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
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
	public Integer createByIdClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.belhard.webappbank.service.impl.dozer;

import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.entity.Accounts;

public class TransfersAccountConverter extends DozerConverter<Accounts, Integer> {

	@Autowired
	private AccountsDao accountsDao;

	public TransfersAccountConverter() {
		super(Accounts.class, Integer.class);
	}

	@Override
	public Accounts convertFrom(Integer arg0, Accounts arg1) {

		return accountsDao.findByAccount(arg0);
	}

	@Override
	public Integer convertTo(Accounts arg0, Integer arg1) {

		return arg0.getAccount();
	}

}

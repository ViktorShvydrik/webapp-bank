package com.belhard.webappbank.service.impl.dozer;

import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.entity.Accounts;

public class CardsAccountConverter extends DozerConverter<Accounts, Integer> {

	@Autowired
	AccountsDao accountsDao;

	public CardsAccountConverter() {
		super(Accounts.class, Integer.class);
	}

	@Override
	public Integer convertTo(Accounts source, Integer destination) {

		return source.getAccount();
	}

	@Override
	public Accounts convertFrom(Integer source, Accounts destination) {

		return accountsDao.findByAccount(source);
	}

}

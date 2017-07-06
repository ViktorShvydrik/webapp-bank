package com.belhard.webappbank.service.impl.dozer;

import org.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.Clients;

public class TransfersClientConverter extends DozerConverter<Clients, String> {

	@Autowired
	ClientsDao clientsDao;

	public TransfersClientConverter() {
		super(Clients.class, String.class);
	}

	@Override
	public String convertTo(Clients source, String destination) {
		return source.getLogin();
	}

	@Override
	public Clients convertFrom(String source, Clients destination) {
		return clientsDao.findByLogin(source);
	}

}

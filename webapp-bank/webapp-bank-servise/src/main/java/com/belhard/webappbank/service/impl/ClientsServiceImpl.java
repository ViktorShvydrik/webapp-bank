package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientsService;

public class ClientsServiceImpl implements ClientsService{

	private ClientsDao clientsDao;
	
	
	public void setClientsDao(ClientsDao clientsDao) {
		this.clientsDao = clientsDao;
	}

	@Override
	public List<Clients> getAllClients() {
		return clientsDao.getAll();
	}

	@Override
	public Clients login(Clients clients) {
		return clientsDao.login(clients);
	}

}

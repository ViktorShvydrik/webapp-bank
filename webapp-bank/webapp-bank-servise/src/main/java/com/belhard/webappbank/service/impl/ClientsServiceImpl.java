package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientsService;

public class ClientsServiceImpl implements ClientsService{

	
	private static final int NO_ENTRY = 9;
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

	@Override
	public Integer add(Clients clients) {
		clients = login(clients);
		if (clients.getAccess() == NO_ENTRY ) {
			clients.setAccess(0);
			return clientsDao.add(clients);
		}
		return null;
	}
	
	

}

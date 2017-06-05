package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;
import com.belhard.webappbank.service.ClientInfService;

public class ClientInfServiceImpl implements ClientInfService{

	private ClientInfDao clientInfDao;
	
	public void setClientInfDao(ClientInfDao clientInfDao) {
		this.clientInfDao = clientInfDao;
	}

	@Override
	public void add(ClientInf clientsInf) {
		clientInfDao.add(clientsInf);
		
	}

	@Override
	public List<ClientInf> getAll() {
		//NOOP
		return null;
	}

	@Override
	public List<ClientInfTabl> getAllInfToTable() {
		
		return clientInfDao.getAllInf();
	}

	@Override
	public ClientInfTabl getAllInfById(int id) {
		
		return clientInfDao.getAllInfByID(id);
	}

}

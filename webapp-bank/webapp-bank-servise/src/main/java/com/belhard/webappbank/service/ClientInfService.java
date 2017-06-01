package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;

public interface ClientInfService {

	Integer add(ClientInf clientsInf);
	
	
	
	List<ClientInf> getAll();
	
	List<ClientInfTabl> getAllInfToTable();
	
	ClientInfTabl getAllInfById(int id);
	
}

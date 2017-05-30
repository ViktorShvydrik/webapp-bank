package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.entity.Clients;

public interface ClientsService {
	
	List<Clients> getAllClients();
	
	Clients login(Clients clients);
	
	
	
	
}

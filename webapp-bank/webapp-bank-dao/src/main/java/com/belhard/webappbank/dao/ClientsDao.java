package com.belhard.webappbank.dao;

import org.springframework.data.repository.CrudRepository;

import com.belhard.webappbank.entity.Clients;

public interface ClientsDao extends CrudRepository<Clients, Integer> {
	
	
	//@Query ("SELECT c FROM clients c WHERE c.login = :login")
	Clients findByLogin(String login);
		
	
}

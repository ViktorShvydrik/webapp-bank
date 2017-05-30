package com.belhard.webappbank.dao;

import com.belhard.webappbank.entity.Clients;

public interface ClientsDao extends DaoGlobal<Clients> {
	
	Clients login(Clients clients);
		
	
}

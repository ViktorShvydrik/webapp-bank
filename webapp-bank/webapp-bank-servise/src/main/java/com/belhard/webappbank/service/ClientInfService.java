package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;

public interface ClientInfService {

	void add(ClientInfBean clientsInfBean);
		
	List<ClientInfBean> getAll();
	
	List<ClientAllInfBean> getAllInfToTable();
	
	ClientAllInfBean getAllInfById(ClientBean clientBean);
	
}

package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.entity.Accounts;

public interface AccountsService {

	List<Accounts> getAllByIdClient(ClientBean client);
	
	Accounts getById (int id);

	//ClientInfTabl createByClient(ClientInfTabl clientInfTabl);
	
	void refill (RefillBean refill);
	
	
}

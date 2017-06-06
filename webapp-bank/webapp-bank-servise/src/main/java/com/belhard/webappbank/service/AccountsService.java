package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.ClientInfTabl;
import com.belhard.webappbank.entity.Refill;

public interface AccountsService {

	List<Accounts> getAllByIdClient(int id);
	
	Accounts getById (int id);

	ClientInfTabl createByClient(ClientInfTabl clientInfTabl);
	
	void refill (Refill refill);
	
	
}

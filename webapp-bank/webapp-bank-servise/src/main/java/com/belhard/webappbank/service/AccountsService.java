package com.belhard.webappbank.service;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.entity.Accounts;

public interface AccountsService {

	Iterable<Accounts> getAllByClient(ClientBean client);
	
	//Accounts getById (int id);

	ClientAllInfBean createByClient(ClientAllInfBean allInfBean);
	
	void refill (RefillBean refill);
	
	
}

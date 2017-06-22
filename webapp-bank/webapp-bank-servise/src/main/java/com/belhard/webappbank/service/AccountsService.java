package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;

public interface AccountsService {

	List<AccountBean> getAllByClient(ClientBean client);

	// Accounts getById (int id);

	ClientAllInfBean createByClient(ClientAllInfBean allInfBean);

	void refill(RefillBean refill);

}

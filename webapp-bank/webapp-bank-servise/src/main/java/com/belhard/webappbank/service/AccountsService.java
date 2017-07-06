package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;

public interface AccountsService {

	List<AccountBean> getAllByClient(ClientBean client);

	AccountBean getById(int id);

	ClientAllInfBean createByClient(ClientAllInfBean allInfBean);

	AccountBean createByIdClient(int id);

	AccountBean refill(RefillBean refill);
	
	TransferBean transfer (TransferBean transferBean);

	List<AccountBean> getAll();

	void setStatus(int id, int status);

}

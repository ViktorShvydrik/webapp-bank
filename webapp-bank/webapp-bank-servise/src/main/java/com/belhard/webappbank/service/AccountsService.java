package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.service.Exception.AccountsServiceException;
import com.belhard.webappbank.service.Exception.RefillExeption;

public interface AccountsService {

	List<AccountBean> getAllByClient(ClientBean client);
	
	List<AccountBean> getAllByClient(int id);

	AccountBean getById(int id);

	ClientAllInfBean createByClient(ClientAllInfBean allInfBean);

	AccountBean createByIdClient(int id);

	AccountBean refillById(RefillBean refill, String login);
	
	void refillByAccount(RefillBean refill, String login) throws RefillExeption;
	
	TransferBean transfer (TransferBean transferBean);

	List<AccountBean> getAll();

	AccountBean setStatus(int id, int status) throws AccountsServiceException;

	void reloadInf();

}

package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;

public interface ClientInfService {

	void add(ClientInfBean clientsInfBean);

	List<ClientAllInfBean> getAllInf();

	ClientAllInfBean getAllInfByClient(ClientBean clientBean);

	ClientAllInfBean getAllInfById(int id);

	void editInf(ClientAllInfBean allInfBean);

	ClientAllInfBean getAllInfByLogin(String login);

}

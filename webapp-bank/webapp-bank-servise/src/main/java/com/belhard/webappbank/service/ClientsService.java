package com.belhard.webappbank.service;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.entity.Clients;

public interface ClientsService {

	Iterable<Clients> getAllClients();

	ClientBean login(ClientBean clientBean);

	int add(ClientBean clientBean);

	ClientBean getClient(int id);

	ClientBean getClient(String login);

}

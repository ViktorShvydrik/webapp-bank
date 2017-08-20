package com.belhard.webappbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.dao.RolesDao;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientsService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
@Transactional
public class ClientsServiceImpl implements ClientsService {

	private static final int NOT_SAVED = -1;
	
	
	private static final int ADMIN_ACCESS = 1;
	private static final int USER_ACCESS = 3;
	private static final int NO_ENTRY = 9;

	@Autowired
	private ClientsDao clientsDao;

	@Autowired
	private RolesDao rolesdDao;

	@Autowired
	private EntityBeanConverter converter;

	@Override
	public Iterable<Clients> getAllClients() {

		return clientsDao.findAll();
	}

	@Override
	public ClientBean login(ClientBean clientBean) {
		String login = clientBean.getLogin();
		Clients clientDB = clientsDao.findByLogin(login);
		if (clientDB != null) {
			ClientBean clientBeanOut = converter.convertToBean(clientDB, ClientBean.class);
			if (clientBean.getPass().equals(clientBeanOut.getPass())) {
				return clientBeanOut;
			} else {
				clientBeanOut.setAccess(NO_ENTRY);
				return clientBeanOut;
			}
		} else {
			ClientBean clientBeanOut = new ClientBean();
			clientBeanOut.setAccess(NO_ENTRY);
			return clientBeanOut;
		}

	}

	@Override
	public int add(ClientBean clientBean) {
		ClientBean clientBeanDB = login(clientBean);
		Clients clientDB = null;
		if (clientBeanDB.getAccess() == NO_ENTRY) {
			Clients client = converter.convertToEntity(clientBean, Clients.class);
			client.setAccess(USER_ACCESS);
			clientDB = clientsDao.save(client);
		} else {
			return NOT_SAVED;
		}

		return clientDB.getIdClient();

	}

	@Override
	public ClientBean getClient(int id) {
		Clients findOne = clientsDao.findOne(id);
		ClientBean clientBean = converter.convertToBean(findOne, ClientBean.class);

		return clientBean;
	}

	@Override
	public ClientBean getClient(String login) {
		Clients clientDB = clientsDao.findByLogin(login);
		ClientBean clientBeanOut = converter.convertToBean(clientDB, ClientBean.class);
		return clientBeanOut;
	}

	@Override
	public String getRole(int access) {

		return rolesdDao.findOne(access).getRoleName();
	}

	@Override
	public void setStatus(int id, int status) {
		Clients clients = clientsDao.findOne(id);
		clients.setStatus(status);
		clientsDao.save(clients);
		
		
	}

	@Override
	public void accessUp(int id) {
		Clients findOne = clientsDao.findOne(id);
		int access = findOne.getAccess();
		if (access> ADMIN_ACCESS){
			access--;
			findOne.setAccess(access);
			clientsDao.save(findOne);
		}else{
			access = USER_ACCESS;
			findOne.setAccess(access);
			clientsDao.save(findOne);
		}
		
	}

	@Override
	public int countClient() {
		return (int)clientsDao.count();
	}


}

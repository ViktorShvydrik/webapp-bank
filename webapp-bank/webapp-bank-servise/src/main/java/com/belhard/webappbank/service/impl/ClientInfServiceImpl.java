package com.belhard.webappbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
@Transactional
public class ClientInfServiceImpl implements ClientInfService{

	@Autowired
	private ClientInfDao clientInfDao;
	
	@Autowired
	private AccountsDao accountsDao;
	
	@Autowired
	private CardsDao cardsDao;
	
	
	@Autowired
	private ClientsDao clientsDao;
	
	@Autowired
	private EntityBeanConverter converter;
	

	@Override
	public void add(ClientInfBean clientInfBean) {
		ClientInf clientInf = converter.convertToEntity(clientInfBean, ClientInf.class);
		clientInfDao.save(clientInf);
		
	}

	@Override
	public List<ClientInfBean> getAll() {
		//NOOP
		return null;
	}

	@Override
	public List<ClientAllInfBean> getAllInfToTable() {
		List<ClientAllInfBean> list = new ArrayList<>();
		Iterable<Clients> findAll = clientsDao.findAll();
		for (Clients client:findAll ){
			ClientBean clientBean = converter.convertToBean(client, ClientBean.class);
			ClientAllInfBean allInfById = getAllInfById(clientBean);
			list.add(allInfById);
		}
		
		return list;
	}


	@Override
	public ClientAllInfBean getAllInfById(ClientBean clientBean) {
		int id = clientBean.getIdClient();
		ClientAllInfBean allInfBean = new ClientAllInfBean();
		allInfBean.setClient(clientBean);
		ClientInf clientInf = clientInfDao.findOne(id);
		ClientInfBean clientInfBean = converter.convertToBean(clientInf, ClientInfBean.class);
		Clients clients = converter.convertToEntity(clientBean, Clients.class);
		allInfBean.setClientInf(clientInfBean);
		//int money = accountsDao.moneyByClient(clients);
		//allInfBean.setTotalMoney(money);
		//int count = accountsDao.countByClient(clients);
		//allInfBean.setCountAcc(count);
		
		return allInfBean;
	}

}

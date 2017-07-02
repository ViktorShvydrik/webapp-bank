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
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
@Transactional
public class ClientInfServiceImpl implements ClientInfService {

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

	private static final int DELETE = 1;

	@Override
	public void add(ClientInfBean clientInfBean) {
		ClientInf clientInf = converter.convertToEntity(clientInfBean, ClientInf.class);
		clientInfDao.save(clientInf);

	}

	@Override
	public List<ClientAllInfBean> getAllInf() {
		List<ClientAllInfBean> list = new ArrayList<>();
		Iterable<Clients> findAll = clientsDao.findAll();
		for (Clients client : findAll) {
			ClientBean clientBean = converter.convertToBean(client, ClientBean.class);
			ClientAllInfBean allInfById = getAllInfByClient(clientBean);
			list.add(allInfById);
		}

		return list;
	}

	@Override
	public ClientAllInfBean getAllInfById(int id) {
		Clients clients = clientsDao.findOne(id);
		ClientBean clientBean = converter.convertToBean(clients, ClientBean.class);
		ClientAllInfBean allInfByClient = getAllInfByClient(clientBean);
		return allInfByClient;
	}

	@Override
	public ClientAllInfBean getAllInfByClient(ClientBean clientBean) {
		ClientAllInfBean allInfBean = new ClientAllInfBean();
		allInfBean.setClient(clientBean);
		allInfBean = getTotalMoneyAndCountAcc(allInfBean);
		allInfBean = getCountCards(allInfBean);
		return allInfBean;
	}

	private ClientAllInfBean getTotalMoneyAndCountAcc(ClientAllInfBean allInfBean) {

		// доработать до отбора только не удаленных данных

		int id = allInfBean.getClient().getIdClient();
		List<Accounts> list = accountsDao.accByIdClient(id);
		int totalMoney = 0;
		int countAcc = 0;
		if (list.size() > 0) {
			totalMoney = accountsDao.moneyByClient(id);
			countAcc = accountsDao.countAllByClient(id);
		}

		allInfBean.setTotalMoney(totalMoney);
		allInfBean.setCountAcc(countAcc);
		return allInfBean;

	}

	private ClientAllInfBean getCountCards(ClientAllInfBean allInfBean) {
		ClientBean clientBean = allInfBean.getClient();
		Clients client = converter.convertToEntity(clientBean, Clients.class);
		List<Cards> list = cardsDao.findAllByClient(client);
		int count = 0;
		if (list.size() > 0) {
			count = cardsDao.countByIdClient(client.getIdClient());
		}

		allInfBean.setCountCards(count);
		return allInfBean;

	}

}

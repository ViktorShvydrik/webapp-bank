package com.belhard.webappbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private ClientInfDao clientInfDao;
	@Autowired
	private ClientsDao clientsDao;
	@Autowired
	private ClientInfService clientInfService;
	@Autowired
	private EntityBeanConverter converter;

	@Override
	@Transactional
	public ClientAllInfBean createByClient(ClientAllInfBean allInfBean) {
		int id = 0;
		id = allInfBean.getClient().getIdClient();
		ClientBean clientBean = allInfBean.getClient();
		Clients client = converter.convertToEntity(clientBean, Clients.class);
		Accounts account = new Accounts();
		account.setClient(client);
		int acc = randomAcc();
		account.setAccount(acc);
		account = accountsDao.save(account);
		int count = accountsDao.countAllByClient(id);
		ClientInfBean clientInfBean = allInfBean.getClient().getInf();
		clientInfBean.setCountAccounts(count);
		ClientInf clientInf = converter.convertToEntity(clientInfBean, ClientInf.class);
		clientInf = clientInfDao.save(clientInf);
		allInfBean = clientInfService.getAllInfByClient(allInfBean.getClient());

		return allInfBean;
	}

	@Override
	public AccountBean refill(RefillBean refill) {
		int id = refill.getIdAccount();
		Accounts accounts = accountsDao.findOne(id);
		int money = accounts.getMoney() + refill.getMoney();
		accounts.setMoney(money);
		accounts = accountsDao.save(accounts);
		AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
		return accountBean;

	}

	@Override
	public List<AccountBean> getAllByClient(ClientBean client) {
		int id = client.getIdClient();
		List<AccountBean> list = new ArrayList<>();
		Iterable<Accounts> listBD = accountsDao.accByIdClient(id);
		for (Accounts accounts : listBD) {
			AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
			list.add(accountBean);
		}
		return list;
	}

	private int randomAcc() {
		int acc = 0;
		Accounts accounts = null;
		do {
			acc = (int) (Math.random() * 900000001 + 100000000);
			accounts = accountsDao.findByAccount(acc);

		} while (accounts != null);
		return acc;

	}

	@Override
	public AccountBean getById(int id) {
		Accounts accounts = accountsDao.findOne(id);
		AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
		return accountBean;
	}

	@Override
	@Transactional
	public AccountBean createByIdClient(int id) {
		Accounts account = new Accounts();
		Clients client = clientsDao.findOne(id);
		int acc = randomAcc();
		account.setClient(client);
		account.setAccount(acc);
		account = accountsDao.save(account);
		int count = accountsDao.countAllByClient(id);
		ClientInf clientInf = clientInfDao.findOne(id);
		clientInf.setAccounts(count);
		clientInfDao.save(clientInf);
		AccountBean accountBean = converter.convertToBean(account, AccountBean.class);
		return accountBean;
	}
}

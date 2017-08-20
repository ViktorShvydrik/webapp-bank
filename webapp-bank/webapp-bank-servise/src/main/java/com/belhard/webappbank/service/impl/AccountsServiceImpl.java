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
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.service.AccountsService;
import com.belhard.webappbank.service.ClientInfService;
import com.belhard.webappbank.service.EntityBeanConverter;
import com.belhard.webappbank.service.TransfersService;
import com.belhard.webappbank.service.Exception.AccountsServiceException;
import com.belhard.webappbank.service.Exception.RefillExeption;
import com.belhard.webappbank.service.Exception.TransferException;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private ClientInfDao clientInfDao;
	@Autowired
	private ClientsDao clientsDao;
	@Autowired
	private CardsDao cardsDao;
	@Autowired
	private ClientInfService clientInfService;
	@Autowired
	private TransfersService transfersService;
	@Autowired
	private EntityBeanConverter converter;
	
	private static final int STATUS_OK = 0;
	private static final int STATUS_BLOCK = 1;
	private static final int STATUS_DELETE = 2;
	
	private static final int ADMIN_ACCESS = 1;
	private static final int OPERATOR_ACCESS = 2;
	
	private static final int REFILL = 1;
	private static final int WITHDRAW = 2;
	
	

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
	public AccountBean refillById(RefillBean refill, String login) {
		int id = refill.getIdAccount();
		Accounts accounts = accountsDao.findOne(id);
		int money = accounts.getMoney() + refill.getMoney();
		accounts.setMoney(money);
		accounts = accountsDao.save(accounts);
		AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
		transfersService.addTransfer(refill, login);
		return accountBean;
	}
	

	
	@Transactional
	@Override
	public TransferBean transfer(TransferBean transferBean) {
		Clients clients = clientsDao.findByLogin(transferBean.getLogin());
		Accounts accounts = accountsDao.findByAccount(transferBean.getFromAcc().getAccount());
		int access = clients.getAccess();
		if( access == ADMIN_ACCESS || access == OPERATOR_ACCESS || accounts.getClient().equals(clients) ){
		int money = accounts.getMoney() - transferBean.getMoney();
		accounts.setMoney(money);
		accounts = accountsDao.save(accounts);
		AccountBean acc = converter.convertToBean(accounts, AccountBean.class);
		transferBean.setFromAcc(acc);
		accounts = accountsDao.findByAccount(transferBean.getToAcc().getAccount());
		money = accounts.getMoney() + transferBean.getMoney();
		accounts.setMoney(money);
		accounts = accountsDao.save(accounts);
		acc = converter.convertToBean(accounts, AccountBean.class);
		transferBean.setToAcc(acc);
		transferBean = transfersService.addTransfer(transferBean);
		return transferBean;
		}else {
			throw new TransferException("Access is denied");
		}
	}

	@Override
	public List<AccountBean> getAllByClient(ClientBean client) {
		int id = client.getIdClient();
		return getAllByClient(id);
	}
	
	@Override
	public List<AccountBean> getAllByClient(int id) {
		List<AccountBean> list = new ArrayList<>();
		Iterable<Accounts> listBD = accountsDao.accByIdClient(id);
		for (Accounts accounts : listBD) {
			if(accounts.getStatus() == STATUS_DELETE){
				continue;
			}
			AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
			list.add(accountBean);
		}
		return list;
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
	public List<AccountBean> getAll() {
		Iterable<Accounts> iterable = accountsDao.findAll();
		List<AccountBean> list = converter.convertToBeanList(iterable, AccountBean.class);
		return list;
	}

	@Override
	public AccountBean setStatus(int id, int status) throws AccountsServiceException {
		Accounts accounts = accountsDao.findOne(id);
		if(accounts.getMoney() > 0){
			throw new AccountsServiceException();
		}else{
		accounts.setStatus(status);
		accounts = accountsDao.save(accounts);
		}
		AccountBean accountBean = converter.convertToBean(accounts, AccountBean.class);
		return accountBean;
	}
	
	@Transactional
	@Override
	public void refillByAccount(RefillBean refill, String login) throws RefillExeption {
		int acc = refill.getAccount();
		Accounts accounts = accountsDao.findByAccount(acc);
		int money = 0;
		int moneyAcc = accounts.getMoney();
		int moneyRef = refill.getMoney(); 
		if (refill.getDirection() == REFILL ) {
			money = moneyAcc  + moneyRef;
		}
		if (refill.getDirection() == WITHDRAW){
			
			if(moneyAcc>=moneyRef){
			money = moneyAcc - moneyRef;
			}else{
				throw new RefillExeption("Insufficient funds");
			}
		}
		accounts.setMoney(money);
		accounts = accountsDao.save(accounts);
		refill.setIdAccount(accounts.getIdAccount());
		transfersService.addTransfer(refill, login);
		
	}

	@Override
	public void reloadInf() {
		Iterable<Accounts> findAll = accountsDao.findAll();
		for (Accounts account : findAll) {
			int count = cardsDao.countByIdAccount(account.getIdAccount());
			account.setCards(count);
			accountsDao.save(account);
		}
		
	}



	


}

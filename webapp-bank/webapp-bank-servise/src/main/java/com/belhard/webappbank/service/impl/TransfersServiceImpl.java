package com.belhard.webappbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;
import com.belhard.webappbank.dao.TransfersDao;
import com.belhard.webappbank.entity.Accounts;
import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.entity.Transfers;
import com.belhard.webappbank.service.EntityBeanConverter;
import com.belhard.webappbank.service.TransfersService;

@Service
public class TransfersServiceImpl implements TransfersService {

	private static final int DEFAULT_ID_ACCOUNT = 1;

	@Autowired
	private TransfersDao transfersDao;

	@Autowired
	private EntityBeanConverter converter;

	@Override
	public List<TransferBean> getAll() {
		Iterable<Transfers> iterable = transfersDao.findAll();
		List<TransferBean> list = new ArrayList<>();
		for (Transfers transfers : iterable) {
			TransferBean transferBean = converter.convertToBean(transfers, TransferBean.class);
			list.add(transferBean);
		}
		return list;
	}

	@Override
	@Transactional
	public List<TransferBean> getAllByClient(ClientBean clientBean) {
		Clients client = converter.convertToEntity(clientBean, Clients.class);
		Iterable<Transfers> iterable = transfersDao.findByClient(client);
		List<TransferBean> list = new ArrayList<>();
		for (Transfers transfers : iterable) {
			TransferBean transferBean = converter.convertToBean(transfers, TransferBean.class);
			list.add(transferBean);
		}
		return list;
	}

	@Override
	public List<TransferBean> getLastFewByClient(ClientBean clientBean, int few) {
		Clients client = converter.convertToEntity(clientBean, Clients.class);
		Iterable<Transfers> iterable = transfersDao.getLastByClients(client);
		List<TransferBean> list = new ArrayList<>();
		int iter = 0;
		for (Transfers transfers : iterable) {
			if (iter == few) {
				return list;
			}
			TransferBean transferBean = converter.convertToBean(transfers, TransferBean.class);
			list.add(transferBean);
			iter++;

		}

		return list;
	}

	@Override
	public void addTransfer(RefillBean refill) {
		Transfers transfer = new Transfers();
		Accounts accounts = new Accounts();
		accounts.setIdAccount(refill.getIdAccount());
		transfer.setAccountCB(accounts);
		transfer.setMoney(refill.getMoney());
		accounts = new Accounts();
		accounts.setIdAccount(DEFAULT_ID_ACCOUNT);
		transfer.setAccountCA(accounts);
		transfersDao.save(transfer);
	}

	@Override
	public TransferBean addTransfer(TransferBean transferBean) {
		Transfers transfer = converter.convertToEntity(transferBean, Transfers.class);
		transfer = transfersDao.save(transfer);
		transferBean = converter.convertToBean(transfer, TransferBean.class);
		return transferBean;
		
	}

}

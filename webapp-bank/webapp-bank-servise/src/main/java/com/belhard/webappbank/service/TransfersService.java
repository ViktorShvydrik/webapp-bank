package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.beans.TransferBean;

public interface TransfersService {

	List<TransferBean> getAll();

	List<TransferBean> getAllByClient(ClientBean clientBean);

	List<TransferBean> getLastFewByClient(ClientBean clientBean, int few);

	void addTransfer(RefillBean refill);
	
	TransferBean addTransfer(TransferBean transferBean);

}

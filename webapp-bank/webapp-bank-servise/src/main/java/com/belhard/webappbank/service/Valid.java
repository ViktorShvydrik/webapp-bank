package com.belhard.webappbank.service;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.service.Exception.ValidException;

public interface Valid {

	boolean account(AccountBean accountBean);

	boolean card(CardBean cardBean);

	boolean clientAll(ClientAllInfBean allInfBean);

	boolean client(ClientBean clientBean);

	boolean reg(ClientBean client);

	boolean clientInf(ClientInfBean clientInfBean);

	boolean refill(RefillBean refillBean) throws ValidException;

	boolean refillByAccount(RefillBean refillBean) throws ValidException;

	boolean refillMoney(int money) throws ValidException;

}

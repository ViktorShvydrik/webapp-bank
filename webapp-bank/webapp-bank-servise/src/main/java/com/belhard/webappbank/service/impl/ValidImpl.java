package com.belhard.webappbank.service.impl;

import org.springframework.stereotype.Service;

import com.belhard.webappbank.beans.AccountBean;
import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.beans.ClientBean;
import com.belhard.webappbank.beans.ClientInfBean;
import com.belhard.webappbank.beans.RefillBean;
import com.belhard.webappbank.service.Valid;
import com.belhard.webappbank.service.Exception.ValidException;

@Service
public class ValidImpl implements Valid
{
	private static final int DIRECTION_REFILL = 1;
	private static final int DIRECTION_WITHDRAW = 2;

	@Override
	public boolean account(AccountBean accountBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean card(CardBean cardBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clientAll(ClientAllInfBean allInfBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean client(ClientBean clientBean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean reg(ClientBean client) {
		String login = client.getLogin();
		String pass = client.getPass();
		return false;
	}

	@Override
	public boolean clientInf(ClientInfBean clientInfBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean refill(RefillBean refillBean) throws ValidException {
		int money = refillBean.getMoney();
		int direction = refillBean.getDirection();
		boolean valid = false;
		valid = refillMoney(money);
		switch (direction) {
		case DIRECTION_REFILL:
			valid = true;
			break;
		case DIRECTION_WITHDRAW:
			valid = true;
			break;
		default:
			throw new ValidException();
		}
		return valid;
	} 
	
	@Override
	public boolean refillByAccount(RefillBean refillBean) throws ValidException {
		int account = refillBean.getAccount();
		boolean valid = false;
		valid = refill(refillBean);
		if(account >= 0){
			valid = true;
		}else{
			throw new ValidException();
		}
		return valid;
	}

	@Override
	public boolean refillMoney(int money) throws ValidException {
		boolean valid = false;
		if (money >= 0){
			valid = true;
		}else{
			throw new ValidException();
		}
		return valid;
	}

	

	

	

}

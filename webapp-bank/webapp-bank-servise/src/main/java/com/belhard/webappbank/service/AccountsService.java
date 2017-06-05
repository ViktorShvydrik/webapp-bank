package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.entity.Accounts;

public interface AccountsService {

	List<Accounts> getAllByIdClient(int id);
	
	Accounts getById (int id);
	
	Integer createByIdClient(int id);
	
	
}

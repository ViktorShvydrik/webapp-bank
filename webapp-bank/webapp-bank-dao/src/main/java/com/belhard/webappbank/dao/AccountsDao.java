package com.belhard.webappbank.dao;

import org.springframework.data.repository.CrudRepository;

import com.belhard.webappbank.entity.Accounts;

public interface AccountsDao extends CrudRepository<Accounts, Integer>{

	//List<Accounts> getAllByIdClient(int id);

	//Integer create(int id);
	
	//@Query ("SELECT COUNT(a) FROM accounts a WHERE a.id_client=:idClient")
	//Integer countByClient(Clients client);
	
	//@Query ("SELECT SUM(a.money) FROM accounts a WHERE a.id_client=:idClient")
	//Integer moneyByClient (Clients client);

}

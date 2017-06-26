package com.belhard.webappbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.belhard.webappbank.entity.Accounts;

public interface AccountsDao extends CrudRepository<Accounts, Integer> {

	@SuppressWarnings("unchecked")
	Accounts save(Accounts account);

	@Query("SELECT COUNT(a) FROM Accounts a WHERE a.client.idClient =:id")
	int countAllByClient(@Param("id") int idClient);

	@Query("SELECT SUM(a.money) FROM Accounts a WHERE a.client.idClient =:id")
	int moneyByClient(@Param("id") int idClient);

	@Query("Select a FROM Accounts a WHERE a.client.idClient= :id")
	List<Accounts> accByIdClient(@Param("id") int idClient);

	Accounts findByAccount(int account);

}

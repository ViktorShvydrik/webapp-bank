package com.belhard.webappbank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.entity.Clients;

public interface CardsDao extends CrudRepository<Cards, Integer>{
	
	Iterable<Cards> findAllByClient (Clients clients);
	
	@Query ("Select COUNT(c) FROM Cards c WHERE c.client.idClient= :id")
	int countByIdClient (@Param ("id") int idClient);
	
	//void block (int id);
	
	

}

package com.belhard.webappbank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.belhard.webappbank.entity.Cards;

public interface CardsDao extends CrudRepository<Cards, Integer> {

	@Query("Select c FROM Cards c WHERE c.client.idClient= :id")
	Iterable<Cards> getAllByIdClient(@Param("id") int id);

	@Query("Select COUNT(c) FROM Cards c WHERE c.client.idClient= :id")
	int countByIdClient(@Param("id") int idClient);

	Cards findOne(Integer idCard);

}

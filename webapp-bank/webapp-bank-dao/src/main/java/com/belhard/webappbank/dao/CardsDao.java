package com.belhard.webappbank.dao;

import org.springframework.data.repository.CrudRepository;

import com.belhard.webappbank.entity.Cards;

public interface CardsDao extends CrudRepository<Cards, Integer>{
	
	//List<Cards> getAllByIdClient(int id);
	
	//void block (int id);
	
	

}

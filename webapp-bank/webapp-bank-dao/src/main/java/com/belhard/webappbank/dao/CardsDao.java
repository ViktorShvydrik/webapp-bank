package com.belhard.webappbank.dao;

import java.util.List;

import com.belhard.webappbank.entity.Cards;

public interface CardsDao extends DaoGlobal<Cards>{
	
	List<Cards> getAllByIdClient(int id);
	
	void block (int id);
	
	

}

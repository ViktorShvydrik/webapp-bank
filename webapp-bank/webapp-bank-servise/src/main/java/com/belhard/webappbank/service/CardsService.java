package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.entity.Cards;

public interface CardsService {
	
	List<Cards> getAllByClientId (int id);
	
	void block (int id);

	void unBlock(int id);
	
	

}

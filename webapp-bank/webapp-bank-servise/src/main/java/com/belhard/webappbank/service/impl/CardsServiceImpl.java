package com.belhard.webappbank.service.impl;

import java.util.List;

import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.service.CardsService;

public class CardsServiceImpl implements CardsService {
	
	private CardsDao cardsDao;

	public void setCardsDao(CardsDao cardsDao) {
		this.cardsDao = cardsDao;
	}

	@Override
	public List<Cards> getAllByClientId(int id) {
		
		return cardsDao.getAllByIdClient(id);
	}

	@Override
	public void block(int id) {
		cardsDao.block(id); 
		
	}

	
	
}

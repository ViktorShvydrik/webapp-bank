package com.belhard.webappbank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.service.CardsService;


@Service
public class CardsServiceImpl implements CardsService {
	
	private static final int BLOCK = 1;
	private static final int UNBLOCK = 0;
	
	private CardsDao cardsDao;

	public void setCardsDao(CardsDao cardsDao) {
		this.cardsDao = cardsDao;
	}

	@Override
	public List<Cards> getAllByClientId(int id) {
		//cardsDao.getAllByIdClient(id);
		return null;
	}

	@Override
	public void block(int id) {
			//Cards cards = cardsDao.getByID(id); 
			//cards.setStatus(BLOCK);
			//cardsDao.update(cards);
		
	}

	@Override
	public void unBlock(int id) {
		//Cards cards = cardsDao.getByID(id); 
		//cards.setStatus(UNBLOCK);
		//cardsDao.update(cards);
		
		
	}
	
}

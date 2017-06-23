package com.belhard.webappbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.entity.Cards;
import com.belhard.webappbank.service.CardsService;
import com.belhard.webappbank.service.EntityBeanConverter;

@Service
public class CardsServiceImpl implements CardsService {

	@Autowired
	private EntityBeanConverter converter;

	private static final int BLOCK = 1;
	private static final int UNBLOCK = 0;

	@Autowired
	private CardsDao cardsDao;

	public void setCardsDao(CardsDao cardsDao) {
		this.cardsDao = cardsDao;
	}

	@Override
	public List<CardBean> getAllByClientId(int id) {
		Iterable<Cards> lisBD = cardsDao.getAllByIdClient(id);
		List<CardBean> list = new ArrayList<>();
		for (Cards cards : lisBD) {
			CardBean cardBean = converter.convertToBean(cards, CardBean.class);
			list.add(cardBean);
		}
		return list;
	}

	@Override
	public void block(int idCard) {
		Cards cards = cardsDao.findOne(idCard);
		cards.setStatus(BLOCK);
		cardsDao.save(cards);

	}

	@Override
	public void unBlock(int idCard) {
		Cards cards = cardsDao.findOne(idCard);
		cards.setStatus(UNBLOCK);
		cardsDao.save(cards);

	}

}

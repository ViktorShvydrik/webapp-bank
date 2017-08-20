package com.belhard.webappbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.entity.Accounts;
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
	@Autowired
	private AccountsDao accountsDao;

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
	public CardBean blockOrUnblok(int idCard) {
		Cards card = cardsDao.findOne(idCard);
		if (card.getStatus() == UNBLOCK) {
			card.setStatus(BLOCK);
		} else {
			card.setStatus(UNBLOCK);
		}
		card = cardsDao.save(card);
		CardBean cardBean = converter.convertToBean(card, CardBean.class);
		return cardBean;

	}

	@Override
	public List<CardBean> getAll() {
		Iterable<Cards> findAll = cardsDao.findAll();
		List<CardBean> list = new ArrayList<>();
		for (Cards card : findAll) {
			CardBean cardBean = converter.convertToBean(card, CardBean.class);
			list.add(cardBean);
		}
		return list;
	}
	@Transactional
	@Override
	public void createCard(CardBean cardBean) {
		int numberCard = randomCardNumber();
		cardBean.setNumberCard(numberCard);
		Cards card = converter.convertToEntity(cardBean, Cards.class);
		if (card.getClient() == null) {
			throw new RuntimeException("Client == null");
		}
		card = cardsDao.save(card);
		Accounts account = card.getAccount();
		int countCards = account.getCards(); 
		countCards++;
		account.setCards(countCards);
		accountsDao.save(account);
	}
	
	
	
	private int randomCardNumber(){
		int numberCard = 0;
		Cards card = null;
		do {
			numberCard =  (int) (Math.random() * 90000001 + 10000000);
			card = cardsDao.findByNumberCard(numberCard);
		} while (card != null);
		return numberCard;
		
	}
	
	
}


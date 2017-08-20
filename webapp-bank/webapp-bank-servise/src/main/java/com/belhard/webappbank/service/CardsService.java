package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.CardBean;

public interface CardsService {

	List<CardBean> getAllByClientId(int id);

	CardBean blockOrUnblok(int idCard);

	List<CardBean> getAll();

	void createCard(CardBean cardBean);

}

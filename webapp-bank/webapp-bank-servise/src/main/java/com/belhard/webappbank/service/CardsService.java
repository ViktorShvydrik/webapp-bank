package com.belhard.webappbank.service;

import java.util.List;

import com.belhard.webappbank.beans.CardBean;

public interface CardsService {

	List<CardBean> getAllByClientId(int id);

	void block(int idCard);

	void unBlock(int idCardz);

}

package com.belhard.webappbank.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.belhard.webappbank.beans.CardBean;
import com.belhard.webappbank.service.CardsService;

@RestController
@RequestMapping(value = "/rest/users", produces = "application/json")
public class CardsAPI {

	@Autowired
	private CardsService cardsService;

	@RequestMapping(value = "/accounts/cards/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CardBean> setStatusCard(@PathVariable Integer id) {
		CardBean cardBean = cardsService.blockOrUnblok(id);
		return new ResponseEntity<CardBean>(cardBean, HttpStatus.OK);

	}

}

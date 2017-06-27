package com.belhard.webappbank.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.belhard.webappbank.beans.ClientAllInfBean;
import com.belhard.webappbank.service.ClientInfService;

@RestController
@RequestMapping(value = "/rest/users", produces = "application/json")
public class UserAPI {

	@Autowired
	ClientInfService clientInfService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientAllInfBean>> getAllUserAllInf() {
		List<ClientAllInfBean> list = clientInfService.getAllInf();

		return new ResponseEntity<List<ClientAllInfBean>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClientAllInfBean> getUserAllInf(@PathVariable Integer id) {
		ClientAllInfBean allInfById = clientInfService.getAllInfById(id);
		return new ResponseEntity<ClientAllInfBean>(allInfById, HttpStatus.OK);

	}
}

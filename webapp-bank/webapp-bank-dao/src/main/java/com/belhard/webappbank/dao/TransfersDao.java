package com.belhard.webappbank.dao;

import org.springframework.data.repository.CrudRepository;

import com.belhard.webappbank.entity.Transfers;

public interface TransfersDao extends CrudRepository<Transfers, Integer>{
	
}

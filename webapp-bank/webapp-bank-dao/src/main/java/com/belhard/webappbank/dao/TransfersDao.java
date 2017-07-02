package com.belhard.webappbank.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.belhard.webappbank.entity.Clients;
import com.belhard.webappbank.entity.Transfers;

public interface TransfersDao extends CrudRepository<Transfers, Integer> {

	@Query("SELECT t FROM Transfers t WHERE t.accountCA.client = :client OR t.accountCB.client = :client")
	Iterable<Transfers> findByClient(@Param("client") Clients client);

	@Query("SELECT t FROM Transfers t WHERE t.accountCA.client = :client OR t.accountCB.client = :client  ORDER BY t.idTransfers DESC ")
	Iterable<Transfers> getLastByClients(@Param("client") Clients client);

}

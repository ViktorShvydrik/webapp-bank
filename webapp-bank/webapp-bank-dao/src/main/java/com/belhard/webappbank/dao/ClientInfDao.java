package com.belhard.webappbank.dao;

import java.util.List;

import com.belhard.webappbank.entity.ClientInf;
import com.belhard.webappbank.entity.ClientInfTabl;

public interface ClientInfDao extends DaoGlobal<ClientInf>{

	List<ClientInfTabl> getAllInf();

	ClientInfTabl getAllInfByID(int id);
	
	
}

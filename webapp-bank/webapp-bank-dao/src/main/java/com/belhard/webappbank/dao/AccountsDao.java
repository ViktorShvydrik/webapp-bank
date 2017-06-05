package com.belhard.webappbank.dao;

import java.util.List;

import com.belhard.webappbank.entity.Accounts;

public interface AccountsDao extends DaoGlobal<Accounts>{

	List<Accounts> getAllByIdClient(int id);

}

package com.belhard.webappbank.dao;

import java.util.List;

import com.belhard.webappbank.entity.Transfers;

public interface DaoGlobal  <T> {
	
	public abstract void add(T ob) ;
	public abstract void update(T ob);
	public abstract void delete(T ob);
	public abstract List<T> getAll();

}

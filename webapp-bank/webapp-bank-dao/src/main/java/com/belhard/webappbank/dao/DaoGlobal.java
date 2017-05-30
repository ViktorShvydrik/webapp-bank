package com.belhard.webappbank.dao;

import java.util.List;

public interface DaoGlobal  <T> {
	
	public abstract Integer add(T ob) ;
	public abstract void update(T ob);
	public abstract void delete(T ob);
	public abstract List<T> getAll();
	public abstract T getByID(int id);

}

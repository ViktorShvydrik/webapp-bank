package com.belhard.webappbank.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.belhard.webappbank.dao.DaoGlobal;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Cards;



public class CardsDao implements DaoGlobal<Cards>{

	
	@Override
	public void add(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("INSERT INTO " + ob.getClass().getSimpleName()+ " VALUES(?,?,?,?)");
			statement.setInt(1, ob.getId_card());
			statement.setInt(2, ob.getId_account());
			statement.setInt(3, ob.getNumber_card());
			statement.setInt(4, ob.getStatus());
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	}

	@Override
	public void update(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  id_account=?, number_card=?, status=? WHERE id_card=" + ob.getId_card());
			statement.setInt(1, ob.getId_account());
			statement.setInt(2, ob.getNumber_card());
			statement.setInt(3, ob.getStatus());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);
		}
	}

	@Override
	public void delete(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
	
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " + ob.getClass().getSimpleName()+ " SET status=? WHERE Id_account=" + ob.getId_account());
			statement.setInt(1, ob.getStatus());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);
		}
		
	}

	@Override
	public List<Cards> getAll() {
		
		
		// TODO Auto-generated method stub
		return null;
	}

}

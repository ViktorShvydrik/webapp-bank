package com.belhard.webappbank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.DaoGlobal;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Clients;


public class ClientsDao implements DaoGlobal<Clients>{
	
	
	@Override
	public void add(Clients ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("INSERT INTO " + ob.getClass().getSimpleName()+ " VALUES(?,?,?,?,?)");
			statement.setInt(1, ob.getId_client());
			statement.setString(2, ob.getLogin());
			statement.setString(3, ob.getPass());
			statement.setInt(4, ob.getStatus());
			statement.setInt(5, ob.getAccess());
			statement.execute();
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
	}

	@Override
	public void update(Clients ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  login=?, pass=?, status=?, access=?  WHERE id_client=" + ob.getId_client());
			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPass());
			statement.setInt(3, ob.getStatus());
			statement.setInt(4, ob.getAccess());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	}

	@Override
	public void delete(Clients ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " + ob.getClass().getSimpleName()+ " SET status=? WHERE Id_account=" + ob.getId_client());
			statement.setInt(1, ob.getStatus());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
	}

	@Override
	public List<Clients> getAll() {
		List<Clients> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement("SELECT * FROM Clients");
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idClient = resultset.getInt("id_client");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				Integer status = resultset.getInt("status");
				Integer access = resultset.getInt("access");
				
				
				Clients clients = new Clients(idClient, login, pass, status, access);
				list.add(clients);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}

}

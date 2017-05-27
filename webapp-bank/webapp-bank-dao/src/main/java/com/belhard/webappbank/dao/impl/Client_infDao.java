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
import com.belhard.webappbank.entity.Client_inf;


public class Client_infDao implements DaoGlobal<Client_inf>{

	
	
	@Override
	public void add(Client_inf ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("INSERT INTO " + ob.getClass().getSimpleName()+ " VALUES(?,?,?,?)");
			statement.setInt(1, ob.getId_client());
			statement.setString(2, ob.getName());
			statement.setInt(3, ob.getId_account());
			statement.setInt(4, ob.getDel_status());
			
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	}

	@Override
	public void update(Client_inf ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  name=?, id_account=?, del_status=?  WHERE id_client=" + ob.getId_client());
			statement.setString(1, ob.getName());
			statement.setInt(2, ob.getId_account());
			statement.setInt(3, ob.getDel_status());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	}

	@Override
	public void delete(Client_inf ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE " + ob.getClass().getSimpleName()+ " SET del_status=? WHERE id_client=" + ob.getId_client());
			statement.setInt(1, ob.getDel_status());
			statement.execute();
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	}

	@Override
	public List<Client_inf> getAll() {
		List<Client_inf> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			
			connection = manager.getConnection();
			statement = connection.prepareStatement("SELECT * FROM transfers");
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idClient = resultset.getInt("id_client");
				String name = resultset.getString("name");
				Integer idAccount = resultset.getInt("id_account");
				Integer delStatus = resultset.getInt("del_status");
				
				Client_inf client_inf = new Client_inf(idClient, name, idAccount, delStatus);
				list.add(client_inf);
			}
			
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}

}

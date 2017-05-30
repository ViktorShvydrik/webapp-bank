package com.belhard.webappbank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.ClientInfDao;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.ClientInf;


public class ClientInfDaoImpl implements ClientInfDao{

	private static final String SQL_ADD = "INSERT INTO ClientInf VALUES(?,?,?,?,?)";
	
	@Override
	public Integer add(ClientInf ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, ob.getName());
			statement.setString(1, ob.getSecondName());
			statement.setString(2, ob.getEmail());
			statement.setInt(3, ob.getId_account());
			statement.setInt(4, ob.getDel_status());
			
			statement.execute();
			
			resultSet = statement.getGeneratedKeys();
			return resultSet.getInt(1);
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	
	}

	@Override
	public void update(ClientInf ob) {
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
	public void delete(ClientInf ob) {
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
	public List<ClientInf> getAll() {
		List<ClientInf> list = new ArrayList<>();
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
				
				ClientInf client_inf = new ClientInf(idClient, name, idAccount, delStatus);
				list.add(client_inf);
			}
			
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}

	@Override
	public ClientInf getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.belhard.webappbank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.ClientsDao;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Clients;


public class ClientsDaoImpl implements ClientsDao{
	
	private static final String SQL_ADD = "INSERT INTO Clients VALUES(?,?,?,?)";
	
	private static final String SQL_LOGIN = "SELECT * FROM clients WHERE login=? AND  pass=?";
	
	private static final Integer NO_ACCESS = 9;
	
	@Override
	public Integer add(Clients ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPass());
			statement.setInt(3, ob.getStatus());
			statement.setInt(4, ob.getAccess());
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
			connection = manager.getConnection();
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
	@Override
	public Clients getByID(int id) {
		// NOOP
		return null;
	}

	@Override
	public Clients login(Clients clients) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_LOGIN);
			statement.setString(1, clients.getLogin());
			statement.setString(2, clients.getPass());
			resultset = statement.executeQuery();
			if(resultset.next()){
				clients.setId_client(resultset.getInt("id_client"));
				clients.setAccess(resultset.getInt("access"));
				clients.setStatus(resultset.getInt("status"));
			}else{
				clients.setAccess(NO_ACCESS);
			}
			
			return clients;
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
	
		
	}

}

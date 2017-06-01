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
import com.belhard.webappbank.entity.ClientInfTabl;


public class ClientInfDaoImpl implements ClientInfDao{

	private static final String SQL_ADD = "INSERT INTO clientInf VALUES(?,?,?,?,?)";
	private static final String SQL_GET_CLIENTINF = "SELECT * FROM clientInf";
	private static final String SQL_GET_CLIENTINF_ALL= "SELECT * FROM clients c, clientInf ci WHERE c.id_client=ci.id_client_inf";
	private static final String SQL_GET_CLIENTINF_ALL_BY_ID = "SELECT * FROM clients c, clientInf ci WHERE c.id_client=ci.id_client_inf AND id_client=?";
			
			
	@Override
	public Integer add(ClientInf ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ob.getId_client());
			statement.setString(2, ob.getName());
			statement.setString(3, ob.getSecondName());
			statement.setString(4, ob.getEmail());
			statement.setInt(5, ob.getId_account());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			resultSet.next();
			
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
			statement = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  name=?, id_account=?  WHERE id_client=" + ob.getId_client());
			statement.setString(1, ob.getName());
			statement.setInt(2, ob.getId_account());
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
			statement = connection.prepareStatement(SQL_GET_CLIENTINF);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idClient = resultset.getInt("id_client_inf");
				String name = resultset.getString("name");
				Integer idAccount = resultset.getInt("id_account");
				
				ClientInf clientInf = new ClientInf(idClient, name, idAccount);
				list.add(clientInf);
			}
			
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}

	@Override
	public List<ClientInfTabl> getAllInf() {
		List<ClientInfTabl> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_GET_CLIENTINF_ALL);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				int idClient = resultset.getInt("id_client");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				String name = resultset.getString("name");
				String secondName = resultset.getString("secondName");
				String email = resultset.getString("email");
				int idAccount = resultset.getInt("id_account");
				int status = resultset.getInt("status");
				int access = resultset.getInt("access");
				
				ClientInfTabl clientsInfTabl = new ClientInfTabl(idClient, login, pass, name, secondName, email, idAccount, status, access);
				list.add(clientsInfTabl);
			}
			
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
		
	}
	
	@Override
	public ClientInfTabl getAllByID(int id) {
		ClientInfTabl clientInfTabl = new ClientInfTabl();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_GET_CLIENTINF_ALL_BY_ID);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				int idClient = resultset.getInt("id_client");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				String name = resultset.getString("name");
				String secondName = resultset.getString("secondName");
				String email = resultset.getString("email");
				int idAccount = resultset.getInt("id_account");
				int status = resultset.getInt("status");
				int access = resultset.getInt("access");
				
				clientInfTabl = new ClientInfTabl(idClient, login, pass, name, secondName, email, idAccount, status, access);
				
			}
			
		
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return clientInfTabl;
		
	}

	@Override
	public void delete(ClientInf ob) {
		// NOOP
		
	}

	@Override
	public ClientInf getByID(int id) {
		// NOOP
		return null;
	}


}

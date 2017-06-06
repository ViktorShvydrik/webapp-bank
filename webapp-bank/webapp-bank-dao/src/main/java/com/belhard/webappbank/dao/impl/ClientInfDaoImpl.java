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

public class ClientInfDaoImpl implements ClientInfDao {

	private static final String SQL_ADD = "INSERT INTO clientInf (id_client, name, secondName, email) VALUES(?,?,?,?)";
	private static final String SQL_GET_CLIENTINF = "SELECT * FROM clientInf";
	
	private static final String SQL_GET_CLIENTINF_ALL = "SELECT c.*, name, secondName, email, COUNT(*) as accounts, sum(a.money), sum(a.cards) "
														+ "FROM clients c LEFT outer JOIN clientInf ci ON c.id_client=ci.id_client "
														+ "LEFT outer JOIN   accounts a ON a.id_client= c.id_client GROUP BY id_client";
	
	private static final String SQL_GET_CLIENTINF_ALL_BY_ID = "SELECT c.*, name, secondName, email, COUNT(*) as accounts, sum(a.money), sum(a.cards) "
															+ "FROM clients c, clientInf ci, accounts a "
															+ "WHERE c.id_client=ci.id_client and a.id_client= c.id_client and c.id_client=?";
	
	private static final String SQL_GET_CLIENTINF_BY_ID = "SELECT * FROM clientInf WHERE id_client=?";
	private static final String SQL_UPDETE = "UPDATE clientInf SET  name=?, secondName=?, email=?, accounts=?  WHERE id_client=?";
	private static final Integer STUB = 0;

	
	
	
	@Override
	public Integer add(ClientInf ob) {
		Connection connection = null;
		PreparedStatement statement = null;

		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ob.getIdClient());
			statement.setString(2, ob.getName());
			statement.setString(3, ob.getSecondName());
			statement.setString(4, ob.getEmail());
			// statement.setInt(5, ob.getId_account());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			manager.closeDbResources(connection, statement);
		}
		return STUB;
	}

	@Override
	public void update(ClientInf ob) {
		Connection connection = null;
		PreparedStatement statement = null;

		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_UPDETE);
			
			statement.setString(1, ob.getName());
			statement.setString(2, ob.getSecondName());
			statement.setString(3, ob.getEmail());
			statement.setInt(4, ob.getAccounts());
			statement.setInt(5, ob.getIdClient());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
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

			while (resultset.next()) {
				Integer idClient = resultset.getInt("id_client");
				String name = resultset.getString("name");
				Integer accounts = resultset.getInt("accounts");

				ClientInf clientInf = new ClientInf(idClient, name, accounts);
				list.add(clientInf);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
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

			while (resultset.next()) {
				int idClient = resultset.getInt("id_client");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				String name = resultset.getString("name");
				String secondName = resultset.getString("secondName");
				String email = resultset.getString("email");
				int accounts = resultset.getInt("accounts");
				int money =resultset.getInt("sum(a.money)");
				int cards = resultset.getInt ("sum(a.cards)");
				int status = resultset.getInt("status");
				int access = resultset.getInt("access");

				ClientInfTabl clientInfTabl = new ClientInfTabl(idClient, login, pass, name, secondName, email, accounts, money, cards, status, access);
				list.add(clientInfTabl);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			manager.closeDbResources(connection, statement);
		}
		return list;

	}

	@Override
	public ClientInfTabl getAllInfByID(int id) {
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

			while (resultset.next()) {
				int idClient = resultset.getInt("id_client");
				String login = resultset.getString("login");
				String pass = resultset.getString("pass");
				String name = resultset.getString("name");
				String secondName = resultset.getString("secondName");
				String email = resultset.getString("email");
				int money =resultset.getInt("sum(a.money)");
				int accounts = resultset.getInt("accounts");
				int cards = resultset.getInt ("sum(a.cards)");
				int status = resultset.getInt("status");
				int access = resultset.getInt("access");

				clientInfTabl = new ClientInfTabl(idClient, login, pass, name, secondName, email, accounts, money, cards, status, access);

			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
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
		ClientInf clientInf = new ClientInf();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_GET_CLIENTINF_BY_ID);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				int idClient = resultset.getInt("id_client");
				String name = resultset.getString("name");
				String secondName = resultset.getString("secondName");
				String email = resultset.getString("email");
				int accounts = resultset.getInt("accounts");
				
				clientInf = new ClientInf(idClient, name, secondName, email,  accounts);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			manager.closeDbResources(connection, statement);
		}

		return clientInf;
	}





}

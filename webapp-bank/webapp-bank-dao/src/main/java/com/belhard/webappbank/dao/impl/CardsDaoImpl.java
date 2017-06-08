package com.belhard.webappbank.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.CardsDao;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Cards;



public class CardsDaoImpl implements CardsDao{

	private static final String SQL_ADD = "INSERT INTO Cards VALUES(?,?,?)"; //переделать
	private static final String SQL_GET_BY_ID = "SELECT * FROM Cards WHERE id_card=?";
	private static final String SQL_GETALL_BY_IDCLIENT = "SELECT * FROM Cards WHERE id_client=?";
	private static final String SQL_BLOCK = "UPDATE Cards SET status=? WHERE id_card=?";
	
	private static final int BLOCK = 1;
	
	
	@Override
	public Integer add(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ob.getIdAccount());
			statement.setInt(2, ob.getNumberCard());
			statement.setInt(3, ob.getStatus());
			
			statement.executeUpdate();
			
			
			resultSet=statement.getGeneratedKeys();
			int generatedKey = 0;
			if(resultSet.next()){
				generatedKey = resultSet.getInt(1);
			}
			return generatedKey;
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement, resultSet);			
		}
	}

	@Override
	public void update(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("UPDATE Cards SET  id_account=?, number_card=?, status=? WHERE id_card=" + ob.getIdCard());
			statement.setInt(1, ob.getIdAccount());
			statement.setInt(2, ob.getNumberCard());
			statement.setInt(3, ob.getStatus());
			statement.executeUpdate();
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
			statement = connection.prepareStatement("UPDATE " + ob.getClass().getSimpleName()+ " SET status=? WHERE Id_account=" + ob.getIdAccount());
			statement.setInt(1, ob.getStatus());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);
		}
		
	}

	@Override
	public List<Cards> getAll() {
		List<Cards> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement("SELECT * FROM Cards");
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idCard = resultset.getInt("id_card");
				Integer idAcc = resultset.getInt("id_account");
				Integer idClient = resultset.getInt("id_client");
				Integer numberCard = resultset.getInt("number_card");
				Integer status = resultset.getInt("status");
				
				
				
				Cards cards = new Cards(idCard, idAcc, idClient, numberCard, status);
				list.add(cards);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement, resultset);			
		}
		return list;
	}



	@Override
	public Cards getByID(int id) {
		Cards cards = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_GET_BY_ID);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idCard = resultset.getInt("id_card");
				Integer idAcc = resultset.getInt("id_account");
				Integer idClient = resultset.getInt("id_client");
				Integer numberCard = resultset.getInt("number_card");
				Integer status = resultset.getInt("status");  
				
				
				
				cards = new Cards(idCard, idAcc, idClient, numberCard, status);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement, resultset);			
		}
		return cards;
	}

	@Override
	public List<Cards> getAllByIdClient(int id) {
		List<Cards> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_GETALL_BY_IDCLIENT);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idCard = resultset.getInt("id_card");
				Integer idAcc = resultset.getInt("id_account");
				Integer idClient = resultset.getInt("id_client");
				Integer numberCard = resultset.getInt("number_card");
				Integer status = resultset.getInt("status");  
				
				
				
				Cards cards = new Cards(idCard, idAcc, idClient, numberCard, status);
				list.add(cards);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement, resultset);			
		}
		return list;
	}

	@Override
	public void block(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_BLOCK);
			statement.setInt(1, BLOCK);
			statement.setInt(2, id);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);	
		
		}

	}
	
}

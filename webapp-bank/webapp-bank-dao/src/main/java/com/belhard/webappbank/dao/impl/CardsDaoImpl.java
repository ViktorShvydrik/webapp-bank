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

	private static final String SQL_ADD = "INSERT INTO Cards VALUES(?,?,?)";
	
	@Override
	public Integer add(Cards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ob.getId_account());
			statement.setInt(2, ob.getNumber_card());
			statement.setInt(3, ob.getStatus());
			
			statement.execute();
			
			resultSet=statement.getGeneratedKeys();
			return resultSet.getInt(1);
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
				Integer numberCard = resultset.getInt("number_card");
				Integer status = resultset.getInt("status");
				
				
				
				Cards cards = new Cards(idCard, idAcc, numberCard, status);
				list.add(cards);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return null;
	}



	@Override
	public Cards getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
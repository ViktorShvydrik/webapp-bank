package com.belhard.webappbank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.AccountsDao;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Accounts;


public class AccountsDaoImpl implements AccountsDao {
	
	private static final String SQL_ADD = "INSERT INTO Accounts VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Accounts SET  status=?, account=?, money=?, cards=? WHERE id_account=?)";
	private static final String SQL_DELETE = "UPDATE Accounts SET status=? WHERE id_account=? ";
	private static final String SQL_SELECT = "SELECT * FROM Accounts";
	private static final String SQL_SELECT_BY_IDCLIENT = "SELECT * FROM Accounts WHERE id_client=?";
	
	private static final Integer DELETE = 1;
	

	@Override
	public Integer add(Accounts ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ob.getStatus());
			statement.setInt(2, ob.getAccount());
			statement.setInt(3, ob.getMoney());
			statement.setInt(4, ob.getCards());
						
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
	public void update(Accounts ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		ConnectionManager manager = ConnectionManager.getManager();		
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_UPDATE);
			statement.setInt(1, ob.getStatus());
			statement.setInt(2, ob.getAccount());
			statement.setInt(3, ob.getMoney());
			statement.setInt(4, ob.getCards());
			statement.setInt(5, ob.getIdAccount());
			
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
	}

	@Override
	public void delete(Accounts ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_DELETE);
			statement.setInt(1, ob.getStatus());
			statement.setInt(2, ob.getIdAccount());
			
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
	}

	@Override
	public List<Accounts> getAll() {
		List<Accounts> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_SELECT);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idAcc= resultset.getInt("id_account");
				Integer idClient= resultset.getInt("id_client");
				Integer status = resultset.getInt("status");
				Integer account = resultset.getInt("account");
				Integer money = resultset.getInt("money");
				Integer cards = resultset.getInt("cards");
				
				
				Accounts accounts = new Accounts(idAcc,idClient, status, account, money, cards);
				list.add(accounts);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}
	
	@Override
	public List<Accounts> getAllByIdClient (int id){
		List<Accounts> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = ConnectionManager.getManager().getConnection();
			statement = connection.prepareStatement(SQL_SELECT_BY_IDCLIENT);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idAcc= resultset.getInt("id_account");
				Integer status = resultset.getInt("status");
				Integer account = resultset.getInt("account");
				Integer money = resultset.getInt("money");
				Integer cards = resultset.getInt("cards");
				
				
				Accounts accounts = new Accounts(idAcc,id, status, account, money, cards);
				list.add(accounts);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	
		
	}
	
	@Override
	public Accounts getByID(int id) {
		// NOOP
		return null;
	}
	
	
}

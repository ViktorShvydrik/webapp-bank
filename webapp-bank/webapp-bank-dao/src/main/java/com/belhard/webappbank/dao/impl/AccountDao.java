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
import com.belhard.webappbank.entity.Accounts;


public class AccountDao implements DaoGlobal<Accounts> {


	@Override
	public void add(Accounts ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("INSERT INTO " + ob.getClass().getSimpleName()+ " VALUES(?,?,?,?,?)");
			statement.setInt(1, ob.getId_account());
			statement.setInt(2, ob.getStatus());
			statement.setInt(3, ob.getAccount());
			statement.setInt(4, ob.getMoney());
			statement.setInt(5, ob.getCards());
			
			
			statement.execute();
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
			statement = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  status=?, account=?, money=?, cards=? WHERE id_account=" + ob.getId_account());
			statement.setInt(1, ob.getStatus());
			statement.setInt(2, ob.getAccount());
			statement.setInt(3, ob.getMoney());
			statement.setInt(4, ob.getCards());
			
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
			statement = connection.prepareStatement("UPDATE " + ob.getClass().getSimpleName()+ " SET status=? WHERE id_account=" + ob.getId_account());
			statement.setInt(1, ob.getStatus());
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
			statement = connection.prepareStatement("SELECT * FROM Accounts");
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idAcc= resultset.getInt("id_account");
				Integer status = resultset.getInt("status");
				Integer account = resultset.getInt("account");
				Integer money = resultset.getInt("money");
				
				
				Accounts accounts = new Accounts(idAcc, status, account, money);
				list.add(accounts);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		return list;
	}
	
	
}

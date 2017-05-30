package com.belhard.webappbank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.belhard.webappbank.dao.DaoGlobal;
import com.belhard.webappbank.dao.dbUtils.ConnectionManager;
import com.belhard.webappbank.dao.exceptions.DaoException;
import com.belhard.webappbank.entity.Transfers;


public class TransfersDao implements DaoGlobal<Transfers> {

	private static final String SQL_ADD = "INSERT INTO Transfers VALUES(?,?,?)";
	
	
	@Override
	public Integer add(Transfers ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ConnectionManager manager = ConnectionManager.getManager();
		
		try {
			connection = manager.getConnection();
			PreparedStatement ps =connection.prepareStatement(SQL_ADD, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ob.getId_client());
			ps.setInt(2, ob.getMoney());
			ps.setInt(3, ob.getId_account());
			
			ps.execute();
			
			resultSet= statement.getGeneratedKeys();
			return resultSet.getInt(1);
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
		
		
	}

	@Override
	public void update(Transfers ob){
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();
		try {
			connection = manager.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE " +  ob.getClass().getSimpleName()+" SET  id_client=?,money=?,id_account=?  WHERE id_transfers=" + ob.getId_transfers());
			ps.setInt(1, ob.getId_client());
			ps.setInt(2, ob.getMoney());
			ps.setInt(3, ob.getId_account());
			ps.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement);			
		}
		
	}

	@Override
	public void delete(Transfers ob){
		//NOOP
		
	}

	@Override
	public List<Transfers> getAll() {
		List<Transfers> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		
		ConnectionManager manager = ConnectionManager.getManager();

		try {
			connection = manager.getConnection();
			statement = connection.prepareStatement("SELECT * FROM transfers");
			resultset = statement.executeQuery();
			
			while (resultset.next()){
				Integer idTransf = resultset.getInt("id_transfers");
				Integer idClient = resultset.getInt("id_client");
				Integer idAccount = resultset.getInt("id_account");
				Integer money = resultset.getInt("money");
				
				Transfers transf = new Transfers(idTransf, idClient, money, idAccount);
				list.add(transf);
			}
			
		} catch (Exception e) {
			throw new DaoException(e);
		}finally {
			manager.closeDbResources(connection, statement, resultset);
			}
		return list;
	}

	@Override
	public Transfers getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

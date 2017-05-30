package com.belhard.webappbank.dao.dbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	
	private static final String DS_NAME = "jdbc/bank";
	
	private static final ConnectionManager manager;
	
	static {
		try {
			manager = new ConnectionManager();
		} catch (NamingException e) {
			throw new RuntimeException("Some errors occurred during DB initialization! Application will not work corrctly!", e);
		}
	}

	private ConnectionManager() throws NamingException {
		Context context = new InitialContext();
		Context root = (Context) context.lookup("java:/comp/env");
		dataSource = (DataSource) root.lookup(DS_NAME);
	}

	public static ConnectionManager getManager() {
		return manager;
	}

	private DataSource dataSource;


	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Can not receive connection!", e);
		}
	}
	
	public void closeDbResources(Connection connection, Statement statement) {
		closeDbResources(connection, statement, null);
	}

	public void closeDbResources(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error: Connection has not been closed!");
			}
		}
	}

	private void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error: Statement has not been closed!");
			}
		}
	}

	private void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Error: ResultSet has not been closed!");
			}
		}
	}
}

package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConfigDB {
	
	private Connection connection;
	
	public void setConnection(String className,String typeDb, String user, String pass) {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(typeDb,user,pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	};
	public Connection getConnection() {
		return connection;
	};
		
	
}

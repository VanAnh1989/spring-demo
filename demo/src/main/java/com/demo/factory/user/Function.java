package com.demo.factory.user;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.DAO.ConfigDB;
import com.demo.DAO.CrudFunction;
import com.demo.model.User;

public class Function extends ConfigDB implements CrudFunction<User>{

	public Function() {
		setConnection("org.postgresql.Driver","jdbc:postgresql://localhost:5432/mybatis","postgres", "postgres");
	}
	
	@Override
	public void addUser(User user) {
	
	}

	@Override
	public User getUser() {

		return null;
	}

	@Override
	public void deleteUser(int id) {
	
			
	}
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		Connection connection = getConnection();
		try {
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM tbl_user");
			while(result.next()) {
				User user = new User();
				user.setId(result.getInt(1));
				user.setName(result.getString(2)); 
				user.setPass(result.getString(3));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	
}

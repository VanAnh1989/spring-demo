package com.demo.DAO;

public interface CrudFunction<T> {
	
	void addUser(T user);
	T getUser();
	void deleteUser(int id);
	
}

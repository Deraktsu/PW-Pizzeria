package it.pw.dao;

import it.pw.model.User;


public interface UserDao {
	void create(User u);
	boolean verificaLogin(String username,String password);
}

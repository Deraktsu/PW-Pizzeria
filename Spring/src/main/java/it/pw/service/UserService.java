package it.pw.service;

import it.pw.model.User;

public interface UserService {
	
	void create(User u);
	boolean verificaLogin(String username,String password);
	
}

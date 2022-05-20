package it.pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.UserDao;
import it.pw.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void create(User u) {
		userDao.create(u);
	}


	@Override
	public boolean verificaLogin(String username, String password) {
		
		return userDao.verificaLogin(username,password);
	}

	
	
}

package it.pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.AdminDao;
import it.pw.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Override
	public boolean verificaLoginAdmin(String username, String password) {
		
		return adminDao.verificaLoginAdmin(username, password);
	}

	@Override
	public boolean verficaUsernameAdmin(String username) {
		
		return adminDao.verficaUsernameAdmin(username);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		
		return adminDao.getAdmineByUsername(username);
	}

}

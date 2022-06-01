package it.pw.service;


import it.pw.model.Admin;

public interface AdminService {
	boolean verificaLoginAdmin(String username,String password);
	boolean verficaUsernameAdmin(String username);
	Admin getAdminByUsername(String username);
}

package it.pw.dao;

import it.pw.model.Admin;


public interface AdminDao {
	boolean verificaLoginAdmin(String username,String password);
	boolean verficaUsernameAdmin(String username);
	Admin getAdmineByUsername(String username);
}

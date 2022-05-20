package it.pw.dao;

import it.pw.model.Utente;


public interface UtenteDao {
	void create(Utente u);
	boolean verificaLogin(String username,String password);
}

package it.pw.service;

import it.pw.model.Utente;

public interface UtenteService {
	
	void create(Utente u);
	boolean verificaLogin(String username,String password);
	boolean verficaUsername(String username);
	
}

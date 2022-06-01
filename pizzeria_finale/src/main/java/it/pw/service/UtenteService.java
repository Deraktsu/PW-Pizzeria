package it.pw.service;

import java.util.List;

import it.pw.model.Utente;

public interface UtenteService {
	
	void create(Utente u);
	boolean verificaLogin(String username,String password);
	boolean verficaUsername(String username);
	Utente getUtenteByUsername(String username);
	void update(Utente u);
	List<Utente>leggiTutti();
}

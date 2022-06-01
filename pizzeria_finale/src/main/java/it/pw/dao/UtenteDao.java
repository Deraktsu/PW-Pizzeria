package it.pw.dao;

import java.util.List;

import it.pw.model.Utente;


public interface UtenteDao {
	void create(Utente u);
	boolean verificaLogin(String email,String password);
	boolean verficaUsername(String email);
	List<Utente>leggiTutti();
	Utente getUtenteByUsername(String email);
	void update(Utente u);
	void delete(Utente u);
	Utente getutenteById(int id);
	
}

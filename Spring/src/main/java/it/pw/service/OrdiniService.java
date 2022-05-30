package it.pw.service;

import java.util.List;

import it.pw.model.Ordine;
import it.pw.model.Utente;

public interface OrdiniService {

	List<Ordine>vediTutti();
	void create(Ordine o);
	void update(Ordine o);
	void delete(Ordine o);
	List<Ordine> getOrdineByUtente(Utente utente);
}

package it.pw.dao;

import java.util.List;

import it.pw.model.Ordine;
import it.pw.model.Prodotto;
import it.pw.model.Utente;


public interface OrdiniDao  {
	
	List<Ordine>vediTutti();
	void create(Ordine o);
	void update(Ordine o);
	void delete(Ordine o);
	Ordine getOrdineById(int id);
	boolean confrontaDataProdotto(Prodotto p);
	boolean confrontaDataUtente(Utente utente);
	List<Ordine>getOrdineByUtente(Utente utente);
	
}

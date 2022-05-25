package it.pw.dao;

import java.util.List;

import it.pw.model.Ordini;
import it.pw.model.Prodotto;
import it.pw.model.Utente;


public interface OrdiniDao  {
	
	List<Ordini>vediTutti();
	void create(Ordini o);
	void update(Ordini o);
	void delete(Ordini o);
	Ordini getOrdineById(int id);
	boolean confrontaDataProdotto(Prodotto p);
	boolean confrontaDataUtente(Utente utente);
	boolean confrontaDataOrdine(Ordini ordine);
	
}

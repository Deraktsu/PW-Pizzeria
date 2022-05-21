package it.pw.dao;

import java.util.List;

import it.pw.model.Prodotto;

public interface ProdottoDao {
	
	List<Prodotto>vediTutti();
	void create(Prodotto p);
	void update(Prodotto p);
	void delete(int id);
	Prodotto getProdottoById(int id);
	
}

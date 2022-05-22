package it.pw.service;



import java.util.List;

import it.pw.model.Carrello;

import it.pw.model.Prodotto;

public interface ProdottoService {
	boolean confrontaProdotti(int id, List<Carrello> lista);
	List<Prodotto>vediTutti();
	void create(Prodotto p);
	void update(Prodotto p);
	void delete(Prodotto p);
	Prodotto getProdottoById(int id);
	double calcolaPrezzo(List<Carrello>listacalcolare);
	int trovaIndex(List<Carrello> lcs,int id);
	
	
}

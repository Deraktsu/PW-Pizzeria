package it.pw.service;



import java.util.List;

import it.pw.model.ProdottoNelCarrello;

import it.pw.model.Prodotto;

public interface ProdottoService {
	boolean confrontaProdotti(int id, List<ProdottoNelCarrello> lista);
	List<Prodotto>vediTutti();
	void create(Prodotto p);
	void update(Prodotto p);
	void delete(Prodotto p);
	Prodotto getProdottoById(int id);
	double calcolaPrezzo(List<ProdottoNelCarrello>listacalcolare);
	int trovaIndex(List<ProdottoNelCarrello> lcs,int id);
	
	
}

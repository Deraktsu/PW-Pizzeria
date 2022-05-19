package it.pw.service;



import java.util.List;

import it.pw.model.Prodotto;

public interface ProdottoService {
	List<Prodotto>vediTutti();
	void create(Prodotto p);
	void update(Prodotto p);
	void delete(int id);
	
	
	
}

package it.pw.service;

import java.util.List;

import it.pw.model.Ordine;

public interface OrdiniService {

	List<Ordine>vediTutti();
	void create(Ordine o);
	void update(Ordine o);
	void delete(Ordine o);
}

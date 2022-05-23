package it.pw.service;

import java.util.List;

import it.pw.model.Ordini;

public interface OrdiniService {

	List<Ordini>vediTutti();
	void create(Ordini o);
	void update(Ordini o);
	void delete(Ordini o);
}

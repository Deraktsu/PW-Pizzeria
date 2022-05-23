package it.pw.dao;

import java.util.List;

import it.pw.model.Ordini;

public interface OrdiniDao {
	
	List<Ordini>vediTutti();
	void create(Ordini o);
	void update(Ordini o);
	void delete(Ordini o);
}

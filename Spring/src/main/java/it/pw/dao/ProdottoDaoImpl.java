package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import it.pw.model.Prodotto;

@Repository
public class ProdottoDaoImpl implements ProdottoDao{

	@PersistenceContext
	EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> vediTutti() {
		List<Prodotto>prodotti = new ArrayList<>();
		
		String jpql = "SELECT p FROM Prodotto p";
		prodotti = manager.createQuery(jpql).getResultList();
		return prodotti;
	}
	@Override
	@Transactional
	public void create(Prodotto p) {
		manager.persist(p);
	}
	@Override
	@Transactional
	public void update(Prodotto p) {
		manager.merge(p);
		
	}
	
	@Override
	@Transactional
	public void delete(Prodotto p) 
	{
		manager.remove(manager.merge(p));
	}
	
	@Override
	public Prodotto getProdottoById(int id) {
	
		return manager.find(Prodotto.class, id);
	}
}
	
	


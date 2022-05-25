package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.pw.model.Ordini;

@Repository
public class OrdiniDaoImpl implements OrdiniDao {

	@PersistenceContext
	EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordini> vediTutti() {
		List<Ordini>ordini = new ArrayList<>();
		
		String jpql = "SELECT p FROM Ordini p";
		ordini = manager.createQuery(jpql).getResultList();
		return ordini;
	}

	@Override
	@Transactional
	public void create(Ordini o) {
		manager.persist(o);
		
	}

	@Override
	@Transactional
	public void update(Ordini o) {
		manager.merge(o);
		
	}

	@Override
	@Transactional
	public void delete(Ordini o) {
		manager.remove(manager.merge(o));
		
	}

	@Override
	public Ordini getOrdineById(int id) {
		
		return manager.find(Ordini.class, id);
	}

}

package it.pw.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.pw.model.Carrello;
@Repository
public class CarrelloDaoImpl implements CarrelloDao {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	@Transactional
	public void create(Carrello c) {
		manager.persist(c);
		
	}

}

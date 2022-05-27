package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import it.pw.model.Utente;

@Repository
public class UtenteDaoImpl implements UtenteDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void create(Utente u) {
		manager.persist(u);
	}
	
	
	@Override
	public boolean verificaLogin(String email, String password) {
	
	return leggiTutti().stream().
			anyMatch(x -> x.getEmail().equalsIgnoreCase(email)&&
			x.getPassword().equals(password));	}
	
	
	@Override
	public boolean verficaUsername(String email) {
		
		return leggiTutti().stream().
				anyMatch(x -> x.getEmail().equalsIgnoreCase(email));
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> leggiTutti() {
		List<Utente>utenti = new ArrayList<>();
		
		String jpql = "SELECT u FROM Utente u";
		utenti = manager.createQuery(jpql).getResultList();
		return utenti;
	}

	
	@Override
	public Utente getUtenteByUsername(String email) {
		
		String jpql = "SELECT u FROM Utente u WHERE email=?1";
		
		Utente u= new Utente();
		u = (Utente) manager.createQuery(jpql)
		.setParameter(1, email)
		.getSingleResult();

		return u;
	}

	@Override
	@Transactional
	public void update(Utente u) {
		manager.merge(u);
		
	}
	
	@Override
	@Transactional
	public void delete(Utente u)
	{
		manager.remove(manager.merge(u));
	}
	
	
	public Utente getutenteById(int id) {
		return manager.find(Utente.class, id);
	}

	
	}
	



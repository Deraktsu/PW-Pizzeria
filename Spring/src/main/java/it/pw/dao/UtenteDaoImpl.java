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
	public boolean verificaLogin(String username, String password) {
	
		

		
				
		
	return leggiTutti().stream().
			anyMatch(x -> x.getUsername().equalsIgnoreCase(username)&&
			x.getPassword().equals(password));	}


	@Override
	public boolean verficaUsername(String username) {

		return leggiTutti().stream().
				anyMatch(x -> x.getUsername().equalsIgnoreCase(username));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> leggiTutti() {
		List<Utente>utenti = new ArrayList<>();
		
		String jpql = "SELECT u FROM Utente u";
		utenti = manager.createQuery(jpql).getResultList();
		return utenti;
	}

}

package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;


import org.springframework.jdbc.core.RowMapper;
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
	
	
	private RowMapper<Utente> utenteMapper = (resultSet, rowNum)
			->
	{
		Utente u = new Utente();
		u.setUsername(resultSet.getString("username"));
		u.setPassword(resultSet.getString("nome"));
	
		return u;
	};

	@SuppressWarnings("unchecked")
	@Override
	public boolean verificaLogin(String username, String password) {
	
		
		List<Utente>utenti = new ArrayList<>();
		
		String jpql = "SELECT c FROM Utente c";
		utenti = manager.createQuery(jpql).getResultList();
		
		
				
		
	return utenti.stream().
			anyMatch(x -> x.getUsername().equalsIgnoreCase(username)&&
			x.getPassword().equalsIgnoreCase(password));	}

}

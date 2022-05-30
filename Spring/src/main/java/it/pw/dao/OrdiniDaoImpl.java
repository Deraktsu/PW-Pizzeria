package it.pw.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.pw.model.Ordine;
import it.pw.model.Prodotto;
import it.pw.model.Utente;

@Repository
public class OrdiniDaoImpl implements OrdiniDao {

	@PersistenceContext
	EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> vediTutti() {
		List<Ordine>ordine = new ArrayList<>();
		
		String jpql = "SELECT p FROM Ordine p";
		ordine = manager.createQuery(jpql).getResultList();
		return ordine;
	}

	@Override
	@Transactional
	public void create(Ordine o) {
		manager.persist(o);
		
	}

	@Override
	@Transactional
	public void update(Ordine o) {
		manager.merge(o);
		
	}

	@Override
	@Transactional
	public void delete(Ordine o) {
		manager.remove(manager.merge(o));
		
	}

	@Override
	public Ordine getOrdineById(int id) {
		
		return manager.find(Ordine.class, id);
	}
	

	@Override
	public boolean confrontaDataProdotto(Prodotto prodotto) {
		
		
		List<Ordine>ordine = prodotto.getOrdini();
		Date dataCorrente = new Date();
		
		
		for(Ordine o : ordine) {
			if(o.getDataOrdine().after(dataCorrente)) {
				System.out.println("IMPOSSIBILE CANCELLARE");
			return true; 	
			}
			
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean confrontaDataUtente(Utente utente) {
		List<Ordine>ordini = new ArrayList<>();
		Date dataCorrente = new Date();
		
		String jpql = "SELECT u FROM Ordine u WHERE utente=?1";
		ordini = manager.createQuery(jpql).setParameter(1, utente).
				getResultList();
		
		for(Ordine o : ordini) {
			if(o.getDataOrdine().after(dataCorrente)) {
			System.out.println("IMPOSSIBILE CANCELLARE");
			return true; 
			}
		}

		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordine>getOrdineByUtente(Utente utente){
		List<Ordine> lista = new ArrayList<>();
		
		String jpql = "SELECT o FROM Ordine o WHERE utente=?1";
				lista = manager.createQuery(jpql).setParameter(1, utente).
						getResultList();
			
		return lista;
	}
	
	
	

}

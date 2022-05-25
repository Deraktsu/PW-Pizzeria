package it.pw.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.pw.model.Ordini;
import it.pw.model.Prodotto;
import it.pw.model.Utente;

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
	
	@Override
	public boolean confrontaDataOrdine(Ordini ordine) {
		Date dataCorrente = new Date();
		if(ordine.getDataOrdine().after(dataCorrente)){
			System.out.println("IMPOSSIBILE CANCELLARE");
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean confrontaDataProdotto(Prodotto id_prodotto) {
		
		
		
		
		
		
		
		
		
		List<Ordini>ordini = new ArrayList<>();
		Date dataCorrente = new Date();
		//select distinct o from Distributor o  join o.towns town join u.district district where
		String jpql2 = "SELECT ordini_prodotti.id_ordine FROM ordini_prodotti where id_prodotto=1";
		String jpql = "SELECT o FROM Ordini o JOIN ordini.prodotti prodotto WHERE id_prodotto=?1";
		ordini = manager.createQuery(jpql).setParameter(1, id_prodotto.getId_prodotto()).
				getResultList();
		
		for(Ordini o : ordini) {
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
		List<Ordini>ordini = new ArrayList<>();
		Date dataCorrente = new Date();
		
		String jpql = "SELECT u FROM Ordini u WHERE utente=?1";
		ordini = manager.createQuery(jpql).setParameter(1, utente).
				getResultList();
		
		for(Ordini o : ordini) {
			if(o.getDataOrdine().after(dataCorrente)) {
			System.out.println("IMPOSSIBILE CANCELLARE");
			return true; 
			}
		}

		return false;
	}
	

}

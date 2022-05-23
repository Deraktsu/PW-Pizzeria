package it.pw.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.ProdottoDao;
import it.pw.model.ProdottoNelCarrello;
import it.pw.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoDao prodottoDao;

	@Override
	public List<Prodotto> vediTutti() {
		
		return prodottoDao.vediTutti();
	}
	
	
	@Override
	public void create(Prodotto p) {
		
		prodottoDao.create(p);
	}

	@Override
	public void update(Prodotto p) {
		prodottoDao.update(p);
		
	}

	@Override
	public void delete(Prodotto prodotto) {
		prodottoDao.delete(prodotto);
		
	}


	@Override
	public Prodotto getProdottoById(int id) {
		
		return prodottoDao.getProdottoById(id);
	}


	@Override
	public double calcolaPrezzo(List<ProdottoNelCarrello> listacalcolare) {
		double totale = 0;
		
		for(ProdottoNelCarrello c : listacalcolare) {
			
		totale += c.getQuantita() *	prodottoDao.getProdottoById(c.getId_prodotto()).getPrezzo();
			
		}
			
		return totale;
	}


	@Override
	public int trovaIndex(List<ProdottoNelCarrello> lcs, int id) {
		
		int index = 0;
		
		for(ProdottoNelCarrello c : lcs) {

			if(c.getId_prodotto() == id) {
				index = lcs.indexOf(c);
				break;
			}
			
		}
		
		return index;
	}


	@Override
	public boolean confrontaProdotti(int id, List<ProdottoNelCarrello> lista) {
		
		for(ProdottoNelCarrello c : lista) {
			if(c.getId_prodotto() == id) {
				return true;
			}
			
		}
		
		return false;
	}

		
	
}

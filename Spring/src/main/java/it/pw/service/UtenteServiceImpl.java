package it.pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pw.dao.UtenteDao;
import it.pw.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;
	
	
	@Override
	public void create(Utente u) {
		utenteDao.create(u);
	}


	@Override
	public boolean verificaLogin(String username, String password) {
		
		return utenteDao.verificaLogin(username,password);
	}


	@Override
	public boolean verficaUsername(String username) {
		
		return utenteDao.verficaUsername(username);
	}

	
	
}

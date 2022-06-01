package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.pw.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	private List<Admin> leggiTutti() {
		List<Admin>admin = new ArrayList<>();
		
		String jpql = "SELECT a FROM Admin a";
		admin = manager.createQuery(jpql).getResultList();
		return admin;
	}
	
	
	@Override
	public boolean verificaLoginAdmin(String username, String password) {
		
		return leggiTutti().stream().
				anyMatch(x -> x.getUsername().equalsIgnoreCase(username)&&
						x.getPassword().equals(password));	}
	

	@Override
	public boolean verficaUsernameAdmin(String username) {
		
		return leggiTutti().stream().
				anyMatch(x -> x.getUsername().equalsIgnoreCase(username));
	}


	@Override
	public Admin getAdmineByUsername(String username) {
		String jpql = "SELECT a FROM Admin a WHERE username=?1";
		
		Admin a= new Admin();
		a = (Admin) manager.createQuery(jpql)
		.setParameter(1, username)
		.getSingleResult();

		return a;
	}


	}
	
	
	


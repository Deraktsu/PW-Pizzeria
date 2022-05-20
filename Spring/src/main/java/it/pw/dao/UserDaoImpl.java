package it.pw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.pw.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void create(User u) {
		
		manager.persist(u);

	}

	@Override
	public boolean verificaLogin(String username, String password) {
		//List<User>utenti = new ArrayList<>();
		
		//String sql = "SELECT * FROM anagrafica WHERE username=? AND password=?";
		//manager.(sql,username,password);
		
		TypedQuery<User> query = manager.createQuery("from users u where lower(u.username) = :name and u.password = :password", User.class);
		query.setParameter("name", "foo");
		query.setParameter("password", "pwd");
		try {
		    User user = query.getSingleResult();
		    System.out.println("User found");
		} catch( javax.persistence.NoResultException e ){
		    System.out.println("No user found");
		}
		 
				//utenti.stream().anyMatch(x -> x.getUsername().equalsIgnoreCase(username)&&
				//		x.getPassword().equalsIgnoreCase(password));
				
		
	return false;
	}

}

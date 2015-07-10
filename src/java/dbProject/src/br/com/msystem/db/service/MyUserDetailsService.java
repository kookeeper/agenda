package br.com.msystem.db.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import br.com.msystem.db.entity.Usuario;
import br.com.msystem.db.to.UserDetailsTO;

@Repository
public class MyUserDetailsService implements UserDetailsService {

	/*
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager newEm){
        this.entityManager = newEm;
    }
    */

    public UserDetails loadUserByUsername(String username){

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("dbProject");
		
		EntityManager em = emFactory.createEntityManager();

    	TypedQuery<Usuario> query = em.createQuery("from Usuario where login = :login", Usuario.class);
    	
    	query.setParameter("login", username);
    	
    	Usuario usuario = query.getSingleResult();
    	
    	UserDetailsTO userDetails = null;
    	
		if (usuario != null) {
    		userDetails = new UserDetailsTO(usuario, true, true, true, true);
    	}
    	
    	return userDetails;

    }
}
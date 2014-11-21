package com.jcrons.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcrons.dao.UsertableDao;
import com.jcrons.entity.Usertable;

@Stateless
public class UsertableDaoImpl implements UsertableDao{
	
	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
	@Override
	public void createUser(String username, String password) {
		Usertable usertable = new Usertable();
		usertable.setUsername(username);
		usertable.setPassword(password);
		em.persist(usertable);
		
	}

}

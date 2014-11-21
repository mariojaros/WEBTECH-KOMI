package com.jcrons.dao.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcrons.dao.GrouptableDao;
import com.jcrons.entity.Grouptable;

@Stateless
public class GroupTableDaoImpl implements GrouptableDao{
	
	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
	@Override
	public void createUserGroup(String username, String group) {
		Grouptable grouptable = new Grouptable();
		grouptable.setUsername(username);
		grouptable.setGroupname(group);
		em.persist(grouptable);
	}

}

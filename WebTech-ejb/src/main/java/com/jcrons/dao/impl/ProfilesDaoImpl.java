package com.jcrons.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jcrons.dao.ProfilesDao;
import com.jcrons.entity.Profile;

@Stateless
public class ProfilesDaoImpl implements ProfilesDao{
	
	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;

	@Override
	public void createProfile(String firstname, String lastname, String username) {
		Profile profile = new Profile();
		profile.setFirstName(firstname);
		profile.setLastName(lastname);
		profile.setNick(username);
		em.persist(profile);
		
		
	}

	@Override
	public Profile getProfile(String username) {
		Query query = em.createQuery("Select p FROM Profile p where p.nick = :nick");
		query.setParameter("nick", username);
		Profile profile = (Profile) query.getSingleResult();
		return profile;
	}
	

}

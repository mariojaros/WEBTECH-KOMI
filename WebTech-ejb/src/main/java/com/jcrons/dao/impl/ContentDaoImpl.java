package com.jcrons.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcrons.dao.ContentDao;
import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.Profile;

@Stateless
public class ContentDaoImpl implements ContentDao {

	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	
	public void createDigitalContent(int startValue, String description,
			int finishValue, int minFee, String name, String path, Profile user) {
		DigitalContent content = new DigitalContent();
		content.setCurrentValue(startValue);
		content.setDescription(description);
		content.setFinishValue(finishValue);
		content.setMinFee(minFee);
		content.setName(name);
		content.setPath(path);
		content.setProfile(user);
		em.persist(content);
		
	}

	@Override
	public void updateCurrentValue(int newPay, int idContent) {
		DigitalContent content = em.find(DigitalContent.class, idContent);
		int newValue = newPay + content.getCurrentValue();
		content.setCurrentValue(newValue);
		
	}

	@Override
	public List<DigitalContent> findAll() {
		List<DigitalContent> contents = em.createNamedQuery("DigitalContent.findAll", DigitalContent.class).getResultList();
		return contents;
	}

}

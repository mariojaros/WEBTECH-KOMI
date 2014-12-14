package com.jcrons.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jcrons.dao.PaymentInfoDao;
import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.PaymentInfo;
import com.jcrons.entity.Profile;

@Stateless
public class PaymentInfoDaoImpl implements PaymentInfoDao{
	
	@PersistenceContext(name="WEBTECH-PU")
	EntityManager em;
	

	@Override
	public void createPaymentInfo(int value, Profile profile,
			DigitalContent content) {
		PaymentInfo payInfo = new PaymentInfo();
		payInfo.setDate(new Date());
		payInfo.setDigitalContent(content);
		payInfo.setProfile(profile);
		payInfo.setValue(value);
		em.persist(payInfo);		
	}


	@Override
	public List<DigitalContent> getContentByProfile(int id) {
		Query query = em.createNamedQuery("PaymentInfo.findContentbyProfile", DigitalContent.class);
		query.setParameter("profile", id);
		return query.getResultList();
	}

}

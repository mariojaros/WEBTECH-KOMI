package com.jcrons.services.implement;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.jcrons.dao.ContentDao;
import com.jcrons.dao.PaymentInfoDao;
import com.jcrons.dao.ProfilesDao;
import com.jcrons.services.PaymentService;

@Stateless
public class PaymentServiceImpl implements PaymentService{

	@EJB
	PaymentInfoDao payInfoDao;
	
	@EJB
	ProfilesDao profileDao;
	
	@EJB
	ContentDao contentDao;
	
	@Override
	public void doPayment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePaymentInfo(int value, String username,
			int idContent) {
		payInfoDao.createPaymentInfo(value, profileDao.getProfile(username), contentDao.getContentById(idContent));
	}

}

package com.jcrons.dao;

import java.util.List;

import javax.ejb.Local;

import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.Profile;

@Local
public interface PaymentInfoDao {
	
	public void createPaymentInfo(int value, Profile profile, DigitalContent content);

	public List<DigitalContent> getContentByProfile(int id);
}

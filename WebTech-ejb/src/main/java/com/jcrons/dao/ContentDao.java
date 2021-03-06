package com.jcrons.dao;

import java.util.List;

import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.Profile;

public interface ContentDao {
	
	public List<DigitalContent> findAll();
	
	public List<DigitalContent> findAllMinTarget();
	
	public List<DigitalContent> findAllByProfile(int id);

	public void createDigitalContent(int startValue, String descritpion, int finishValue, int minFee, String name, String path, Profile user);
	
	public void updateCurrentValue(int newPay, int idContent);
	
	public DigitalContent getContentById(int id);
}

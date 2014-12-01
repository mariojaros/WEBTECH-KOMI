package com.jcrons.dao;

import javax.ejb.Local;

import com.jcrons.entity.Profile;

@Local
public interface ProfilesDao {

	public void createProfile(String firstname, String lastname, String username);
	
	public Profile getProfile(String username);
}

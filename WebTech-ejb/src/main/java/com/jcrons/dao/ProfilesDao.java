package com.jcrons.dao;

import javax.ejb.Local;

@Local
public interface ProfilesDao {

	public void createProfile(String firstname, String lastname, String username);
}

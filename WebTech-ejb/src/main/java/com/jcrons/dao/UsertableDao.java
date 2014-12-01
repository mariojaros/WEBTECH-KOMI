package com.jcrons.dao;

import javax.ejb.Local;

@Local
public interface UsertableDao {
	
	public void createUser(String username,String password);
	
}

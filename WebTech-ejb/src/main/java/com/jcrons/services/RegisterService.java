package com.jcrons.services;

import javax.ejb.Local;

@Local
public interface RegisterService {
	
	public void register(String username,String password,String rola);
}

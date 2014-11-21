package com.jcrons.dao;

import javax.ejb.Local;

@Local
public interface GrouptableDao {

	public void createUserGroup(String username,String group);
}

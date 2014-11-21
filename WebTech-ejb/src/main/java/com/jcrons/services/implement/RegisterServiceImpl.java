package com.jcrons.services.implement;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.jcrons.HashTool;
import com.jcrons.dao.GrouptableDao;
import com.jcrons.dao.UsertableDao;
import com.jcrons.services.RegisterService;

@Stateless
public class RegisterServiceImpl implements RegisterService{

	@EJB
	GrouptableDao grouptable;
	
	@EJB
	UsertableDao usertable;
	
	@Override
	public void register(String username, String password, String rola) {
		HashTool tool = new HashTool();
		grouptable.createUserGroup(username, rola);
		usertable.createUser(username, tool.toSHA256(password));
	}

}

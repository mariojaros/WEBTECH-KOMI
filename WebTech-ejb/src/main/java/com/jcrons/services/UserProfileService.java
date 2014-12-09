package com.jcrons.services;

import java.util.List;

import javax.ejb.Local;

import com.jcrons.dto.News;
import com.jcrons.dto.ProfileDto;

@Local
public interface UserProfileService {
	
	public List<News> getNews();
	
	public String getUserName(String username);
	
	public String getUserSurname(String username);
	
	public String getUserNick(String username);
	
	public void setUserName(String username, String newName);
	
	public void setUserSurname(String username, String newSurname);
	
	public void setUserNick(String username, String newNick);
	
	public void createUser(ProfileDto profile);
}

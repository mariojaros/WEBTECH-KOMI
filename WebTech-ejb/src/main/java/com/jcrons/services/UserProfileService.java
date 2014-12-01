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
	
	public void createUser(ProfileDto profile);
}

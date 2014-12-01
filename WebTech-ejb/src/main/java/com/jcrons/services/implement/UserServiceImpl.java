package com.jcrons.services.implement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.jcrons.dao.ContentDao;
import com.jcrons.dao.ProfilesDao;
import com.jcrons.dto.News;
import com.jcrons.dto.ProfileDto;
import com.jcrons.entity.DigitalContent;
import com.jcrons.services.UserProfileService;

@Stateless
public class UserServiceImpl implements UserProfileService{
	
	@EJB
	ContentDao contentDao;
	
	@EJB
	ProfilesDao profileDao;
	
	@Override
	public List<News> getNews() {
		List<DigitalContent> contents= contentDao.findAll();
		List<News> news = new ArrayList<News>();
		for (DigitalContent content : contents){
			News newOne = new News();
			newOne.setContentName(content.getName());
			newOne.setDescription(content.getDescription());
			newOne.setNazovAutora(content.getProfile().getFirstName());
			news.add(newOne);
		}
		return news;
	}

	@Override
	public String getUserName(String username) {
		return profileDao.getProfile(username).getFirstName();
	}

	@Override
	public String getUserSurname(String username) {
		return profileDao.getProfile(username).getLastName();
	}

	@Override
	public void createUser(ProfileDto profile) {
		// TODO Auto-generated method stub
		
	}

}

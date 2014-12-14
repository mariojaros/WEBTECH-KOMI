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
import com.jcrons.services.ContentService;
import com.jcrons.services.PaymentService;
import com.jcrons.services.UserProfileService;

@Stateless
public class UserServiceImpl implements UserProfileService{
	
	@EJB
	ContentDao contentDao;
	
	@EJB
	ProfilesDao profileDao;
	
	@EJB 
	ContentService contentService;
	
	@EJB
	PaymentService payInfoService;
	
	@Override
	public List<News> getNews(boolean unlocked) {
		List<DigitalContent> contents= contentDao.findAll();
		List<News> news = new ArrayList<News>();
		for (DigitalContent content : contents){
			News newOne = new News();
			newOne.setId(content.getIdDigitalContent());
			newOne.setContentName(content.getName());
			newOne.setDescription(content.getDescription());
			newOne.setNazovAutora(content.getProfile().getFirstName());
			newOne.setPath(content.getPath());
			newOne.setValue(getPercent(content.getCurrentValue(),content.getFinishValue()));
			if (content.getCurrentValue()<content.getFinishValue()){
				if (!unlocked) news.add(newOne);
			}
			else{
				if(unlocked) news.add(newOne);
			}
		}
		return news;
	}
	
	public int getPercent(int currentValue, int finishValue){
		int percent = ((currentValue * 100) /(finishValue));
		if(percent >= 100) return 100;
		else return percent;
		
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

	@Override
	public String getUserNick(String username) {
		return profileDao.getProfile(username).getNick();
	}

	@Override
	public void setUserName(String username, String newName) {
		profileDao.getProfile(username).setFirstName(newName);
	}

	@Override
	public void setUserSurname(String username, String newSurname) {
		profileDao.getProfile(username).setLastName(newSurname);
	}

	@Override
	public void setUserNick(String username, String newNick) {
		profileDao.getProfile(username).setNick(newNick);
	}

	@Override
	public void donate(int newPay, String username,int idContent) {
		contentService.setContentCurrentValue(newPay, idContent);
		payInfoService.savePaymentInfo(newPay, username, idContent);
		
	}

	@Override
	public List<News> getNewsByTakeOf() {
		List<DigitalContent> contents= contentDao.findAllMinTarget();
		List<News> news = new ArrayList<News>();
		for (DigitalContent content : contents){
			News newOne = new News();
			newOne.setId(content.getIdDigitalContent());
			newOne.setContentName(content.getName());
			newOne.setDescription(content.getDescription());
			newOne.setNazovAutora(content.getProfile().getFirstName());
			newOne.setPath(content.getPath());
			newOne.setValue(getPercent(content.getCurrentValue(),content.getFinishValue()));
			if (content.getCurrentValue()<content.getFinishValue()){
				news.add(newOne);
			}
		}
		return news;
	}

	@Override
	public List<News> getNewsByProfile(String username) {
		
		List<DigitalContent> contents= contentDao.findAllByProfile(profileDao.getProfile(username).getIdProfile());
		List<News> news = new ArrayList<News>();
		for (DigitalContent content : contents){
			News newOne = new News();
			newOne.setId(content.getIdDigitalContent());
			newOne.setContentName(content.getName());
			newOne.setDescription(content.getDescription());
			newOne.setNazovAutora(content.getProfile().getFirstName());
			newOne.setPath(content.getPath());
			newOne.setValue(getPercent(content.getCurrentValue(),content.getFinishValue()));
			news.add(newOne);
		}
		return news;
	}

}

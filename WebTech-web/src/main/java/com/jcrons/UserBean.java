package com.jcrons;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jcrons.dto.News;
import com.jcrons.services.UserProfileService;

@Named
@ViewScoped
public class UserBean implements Serializable{
	
	private List<News> news;

	private static final long serialVersionUID = 1L;
	
	private String label;
	
	@EJB
	UserProfileService userService;
	
	@PostConstruct
	public void init(){
		news = userService.getNews();
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
}

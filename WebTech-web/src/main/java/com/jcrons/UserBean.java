package com.jcrons;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jcrons.dto.News;
import com.jcrons.services.UserProfileService;

@Named
@ViewScoped
public class UserBean implements Serializable{
	
	private List<News> news;

	private String firstName;
	
	private String lastName;
	
	private String nick;
	
	private static final long serialVersionUID = 1L;
	
	private String label;
	
	@EJB
	UserProfileService userService;
	
	@PostConstruct
	public void init(){
		label = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		news = userService.getNews();
		firstName=userService.getUserName(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		lastName=userService.getUserSurname(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		nick=userService.getUserNick(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	}
	
	public void changeFirstName(){
		FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Successful",  "Your first name is "+firstName+" now") );
		userService.setUserName(label, firstName);
	}
	
	public void changeLastName(){
		FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Successful",  "Your last name is "+lastName+" now") );
		userService.setUserSurname(label, lastName);
	}
	
	public void changeNick(){
		FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Successful",  "Your first name is "+nick+" now") );
		userService.setUserNick(label, nick);
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}

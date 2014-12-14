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
import com.jcrons.services.implement.UserServiceImpl;

@Named
@ViewScoped
public class AuthorBean implements Serializable{
	
	private String label="label";
	
	private List<News> books;
	
	private String selectedBook;
	
	@EJB
	private UserProfileService userService;

	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		label = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		books = userService.getNewsByProfile(label);
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

	public List<News> getBooks() {
		return books;
	}

	public void setBooks(List<News> books) {
		this.books = books;
	}

	public String getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(String selectedBook) {
		this.selectedBook = selectedBook;
	}

	
}

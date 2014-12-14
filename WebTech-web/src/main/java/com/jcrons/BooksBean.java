package com.jcrons;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jcrons.dto.News;
import com.jcrons.services.UserProfileService;

@Named
@ViewScoped
public class BooksBean {
	
	private List<News> books;
	
	private String selectedBook;
	
	@EJB
	UserProfileService userService;
	
	@PostConstruct
	public void init(){
		books = userService.getNews(true);
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

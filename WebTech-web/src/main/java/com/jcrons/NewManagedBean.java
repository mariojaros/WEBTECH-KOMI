package com.jcrons;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jcrons.services.NewSessionBean;
import com.jcrons.services.RegisterService;

@Named
@ViewScoped
public class NewManagedBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String label;
	private List<String> majkos;
	private String username;
	private String password;
	private String rola;

	@EJB
	NewSessionBean sessionBean;
	
	@EJB 
	RegisterService registerService;

	@PostConstruct
	private void init(){
		
	}
	
	public String register() {
		registerService.register(username, password, rola);
		return "index?faces-redirect=true";
	}
	
	public List<String> getMajkos() {
		return majkos;
	}

	public void setMajkos(List<String> majkos) {
		this.majkos = majkos;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}
}

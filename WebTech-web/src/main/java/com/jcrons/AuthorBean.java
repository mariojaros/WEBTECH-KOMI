package com.jcrons;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AuthorBean implements Serializable{
	
	private String label="label";

	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		label = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
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

	
}

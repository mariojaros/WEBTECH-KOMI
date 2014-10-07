package com.jcrons;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NewManagedBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String label;
	
	@EJB
	NewSessionBean sessionBean;

	@PostConstruct
	private void init(){
		label = sessionBean.businessMethod();
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

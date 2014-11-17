package com.jcrons;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jcrons.services.NewSessionBean;

@Named
@ViewScoped
public class NewManagedBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private String label;
	private List<String> majkos;
	
	public List<String> getMajkos() {
		return majkos;
	}

	public void setMajkos(List<String> majkos) {
		this.majkos = majkos;
	}

	@EJB
	NewSessionBean sessionBean;

	@PostConstruct
	private void init(){
		label=sessionBean.getAllDigitalContent();
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

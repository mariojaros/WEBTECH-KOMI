package com.jcrons;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.jcrons.services.ContentService;

@Named
@ViewScoped
public class UploadBean {
	
	private String name;
	
	private String description;
	
	private int finishValue;
	
	private UploadedFile file;
	
	@EJB
	ContentService contentServices;
	
	public void hadnleFileUpload(FileUploadEvent event) {
		file = event.getFile();
	}
	
	public String upload() {
		String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		try {			 
			contentServices.createContent(name, description, finishValue, username, file.getInputstream(), file.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index?faces-redirect=true";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrition) {
		this.description = descrition;
	}

	public int getFinishValue() {
		return finishValue;
	}

	public void setFinishValue(int finishValue) {
		this.finishValue = finishValue;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	


}

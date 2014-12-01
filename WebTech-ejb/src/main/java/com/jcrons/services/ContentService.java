package com.jcrons.services;

import java.io.InputStream;
import java.util.List;

import javax.ejb.Local;

import com.jcrons.dto.DigitalContentDto;
import com.jcrons.entity.DigitalContent;

@Local
public interface ContentService {
	
	public List<DigitalContent> findAll();
	
	public String getContentName(Long id);
	
	public String getContentPath(String name);
	
	public String getContentPath(Long id);
	
	public void createContent(DigitalContentDto content);
	
	public void createContent(String name, String description, int finishValue, String username, InputStream fileStream,String fileName);

}

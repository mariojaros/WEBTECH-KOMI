package com.jcrons.services;

import java.util.List;

import com.jcrons.dto.DigitalContentDto;
import com.jcrons.entity.DigitalContent;

public interface ContentService {
	
	public List<DigitalContent> findAll();
	
	public String getContentName(Long id);
	
	public String getContentPath(String name);
	
	public String getContentPath(Long id);
	
	public void createContent(DigitalContentDto content);

}

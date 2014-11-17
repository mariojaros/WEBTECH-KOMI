package com.jcrons.services;

import com.jcrons.dto.DigitalContentDto;

public interface ContentService {
	
	public String getContentName(Long id);
	
	public String getContentPath(String name);
	
	public String getContentPath(Long id);
	
	public void createContent(DigitalContentDto content);

}

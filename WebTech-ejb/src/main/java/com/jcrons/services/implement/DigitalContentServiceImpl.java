package com.jcrons.services.implement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.google.common.io.ByteStreams;
import com.jcrons.dao.ContentDao;
import com.jcrons.dao.ProfilesDao;
import com.jcrons.dto.DigitalContentDto;
import com.jcrons.entity.DigitalContent;
import com.jcrons.entity.Profile;
import com.jcrons.services.ContentService;

@Stateless
public class DigitalContentServiceImpl implements ContentService{
	
	private final String destination = File.separator + "Users" + File.separator + "mariojaros" +File.separator + "WEBTECH-DIGITALCONTENTS"; 
	
	@EJB
	ProfilesDao profileDao;
	
	@EJB
	ContentDao contentDao;

	@Override
	public String getContentName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentPath(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentPath(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createContent(DigitalContentDto content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DigitalContent> findAll() {
		
		return null;
	}

	@Override
	public void createContent(String name, String description, int finishValue,
			String username, InputStream fileStream, String fileName) {
		
		Profile profile = profileDao.getProfile(username);
		String finalDestination = destination + "/" + username + "/" + fileName;
		File file = new File(destination + File.separator + username + File.separator + fileName);
		file.getParentFile().mkdirs();
		
		try {
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			ByteStreams.copy(fileStream, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentDao.createDigitalContent(0, description, finishValue, 1, name, finalDestination, profile);
		
	}

}

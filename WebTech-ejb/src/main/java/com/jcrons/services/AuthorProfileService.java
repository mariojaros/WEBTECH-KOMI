package com.jcrons.services;

import com.jcrons.dto.ProfileDto;

public interface AuthorProfileService {
	
	public String getAuthorName(String username);
	
	public String getAuthorSurname(String username);
	
	public void createAuthor(ProfileDto profile);

}

package com.jcrons.services;

import com.jcrons.dto.ProfileDto;

public interface UserProfileService {
	
	public String getUserName(String username);
	
	public String getUserSurname(String username);
	
	public void createUser(ProfileDto profile);
}

package com.jcrons;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HashTool {
	public String toSHA256(String password){
		String hash = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
		
		return hash;
		
	}
}

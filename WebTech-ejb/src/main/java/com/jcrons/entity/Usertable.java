package com.jcrons.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERTABLE database table.
 * 
 */
@Entity
@NamedQuery(name="Usertable.findAll", query="SELECT u FROM Usertable u")
public class Usertable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	public Usertable() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
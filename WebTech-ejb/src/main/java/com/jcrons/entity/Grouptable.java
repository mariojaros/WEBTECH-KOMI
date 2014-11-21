package com.jcrons.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grouptable database table.
 * 
 */
@Entity
@NamedQuery(name="Grouptable.findAll", query="SELECT g FROM Grouptable g")
public class Grouptable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String groupname;

	private String username;

	public Grouptable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
package com.jcrons;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Majko
 *
 */
@Entity
@Table(name="MARIO_JAROS")
public class Majko implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="MENO")
	private String name;
	
	public Majko() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}

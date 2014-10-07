package com.jcrons;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: APP_TABLE1
 *
 */
@Entity
@Table(name="APP_TABLE1")
public class APP_TABLE1 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="content")
	private String content;

	public APP_TABLE1() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
   
}

package com.jcrons.dto;

public class News {
	
	private int id;

	private String contentName;
	
	private String description;
	
	private String nazovAutora;
	
	private String path;
	
	private int finalValue;
	
	private int value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNazovAutora() {
		return nazovAutora;
	}

	public void setNazovAutora(String nazovAutora) {
		this.nazovAutora = nazovAutora;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}
}

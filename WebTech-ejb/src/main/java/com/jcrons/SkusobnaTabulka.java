package com.jcrons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SKUSOBNA_TABULKA")
public class SkusobnaTabulka {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="skuska")
	private String skuska;
	
	public SkusobnaTabulka(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkuska() {
		return skuska;
	}

	public void setSkuska(String skuska) {
		this.skuska = skuska;
	}
}

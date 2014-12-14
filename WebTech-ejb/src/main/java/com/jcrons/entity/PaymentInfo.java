package com.jcrons.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PaymentInfo database table.
 * 
 */
@Entity
@NamedQuery(name="PaymentInfo.findAll", query="SELECT p FROM PaymentInfo p")
public class PaymentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPaymentInfo;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int value;

	//bi-directional many-to-one association to DigitalContent
	@ManyToOne
	@JoinColumn(name="idContent")
	private DigitalContent digitalContent;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="idProfile")
	private Profile profile;

	public PaymentInfo() {
	}

	public int getIdPaymentInfo() {
		return this.idPaymentInfo;
	}

	public void setIdPaymentInfo(int idPaymentInfo) {
		this.idPaymentInfo = idPaymentInfo;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DigitalContent getDigitalContent() {
		return this.digitalContent;
	}

	public void setDigitalContent(DigitalContent digitalContent) {
		this.digitalContent = digitalContent;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
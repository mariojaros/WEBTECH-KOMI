package com.jcrons.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfile;

	private String firstName;

	private String lastName;

	private String nick;

	//bi-directional many-to-one association to DigitalContent
	@OneToMany(mappedBy="profile")
	private List<DigitalContent> digitalContents;

	//bi-directional many-to-one association to PaymentInfo
	@OneToMany(mappedBy="profile")
	private List<PaymentInfo> paymentInfos;

	public Profile() {
	}

	public int getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public List<DigitalContent> getDigitalContents() {
		return this.digitalContents;
	}

	public void setDigitalContents(List<DigitalContent> digitalContents) {
		this.digitalContents = digitalContents;
	}

	public DigitalContent addDigitalContent(DigitalContent digitalContent) {
		getDigitalContents().add(digitalContent);
		digitalContent.setProfile(this);

		return digitalContent;
	}

	public DigitalContent removeDigitalContent(DigitalContent digitalContent) {
		getDigitalContents().remove(digitalContent);
		digitalContent.setProfile(null);

		return digitalContent;
	}

	public List<PaymentInfo> getPaymentInfos() {
		return this.paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().add(paymentInfo);
		paymentInfo.setProfile(this);

		return paymentInfo;
	}

	public PaymentInfo removePaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().remove(paymentInfo);
		paymentInfo.setProfile(null);

		return paymentInfo;
	}

}
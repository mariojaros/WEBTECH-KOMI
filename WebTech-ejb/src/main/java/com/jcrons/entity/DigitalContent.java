package com.jcrons.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DigitalContent database table.
 * 
 */
@Entity
@NamedQuery(name="DigitalContent.findAll", query="SELECT d FROM DigitalContent d")
public class DigitalContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDigitalContent;

	private int currentValue;

	private String description;

	private int finishValue;

	private int minFee;

	private String name;

	private String path;

	private byte status;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	//bi-directional many-to-one association to PaymentInfo
	@OneToMany(mappedBy="digitalContent")
	private List<PaymentInfo> paymentInfos;

	public DigitalContent() {
	}

	public int getIdDigitalContent() {
		return this.idDigitalContent;
	}

	public void setIdDigitalContent(int idDigitalContent) {
		this.idDigitalContent = idDigitalContent;
	}

	public int getCurrentValue() {
		return this.currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFinishValue() {
		return this.finishValue;
	}

	public void setFinishValue(int finishValue) {
		this.finishValue = finishValue;
	}

	public int getMinFee() {
		return this.minFee;
	}

	public void setMinFee(int minFee) {
		this.minFee = minFee;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<PaymentInfo> getPaymentInfos() {
		return this.paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().add(paymentInfo);
		paymentInfo.setDigitalContent(this);

		return paymentInfo;
	}

	public PaymentInfo removePaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().remove(paymentInfo);
		paymentInfo.setDigitalContent(null);

		return paymentInfo;
	}

}
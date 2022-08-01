package com.componentprocessing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProcessResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int requestId;
	private int processingCharge;
	private int packagingAndDeleveryCharge;
	private String dateOfDelivery;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getProcessingCharge() {
		return processingCharge;
	}
	public void setProcessingCharge(int processingCharge) {
		this.processingCharge = processingCharge;
	}
	public int getPackagingAndDeleveryCharge() {
		return packagingAndDeleveryCharge;
	}
	public void setPackagingAndDeleveryCharge(int packagingAndDeleveryCharge) {
		this.packagingAndDeleveryCharge = packagingAndDeleveryCharge;
	}
	public String getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}

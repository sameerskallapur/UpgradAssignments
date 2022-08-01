package com.packaginganddelevery.entity;

import org.springframework.stereotype.Component;

@Component
public class ChargeDetails {
	
	private int processingAndDeliveryCharge;

	public int getProcessingAndDeliveryCharge() {
		return processingAndDeliveryCharge;
	}

	public void setProcessingAndDeliveryCharge(int processingAndDeliveryCharge) {
		this.processingAndDeliveryCharge = processingAndDeliveryCharge;
	}
	
	

}

package com.packaginganddelevery.entity;

import org.springframework.stereotype.Component;

@Component
public class PackageAndDeliveryCostDetail {
	//packaging items
	 private int  integraItem= 100;
	 private int acessory = 50;
	 private int protectiveSheath = 50;
	
	//delivery items
	 private int integralItemDeliveryCharge=200;
	 private int accessoryDeliveryCharge=100;
	 
	 
	public int getIntegraItem() {
		return integraItem;
	}
	public int getAcessory() {
		return acessory;
	}
	public int getProtectiveSheath() {
		return protectiveSheath;
	}
	public int getIntegralItemDeliveryCharge() {
		return integralItemDeliveryCharge;
	}
	public int getAccessoryDeliveryCharge() {
		return accessoryDeliveryCharge;
	}
	 
	 

	

}

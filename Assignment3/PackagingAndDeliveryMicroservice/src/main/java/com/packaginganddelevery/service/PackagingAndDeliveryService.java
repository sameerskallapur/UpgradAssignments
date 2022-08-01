package com.packaginganddelevery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packaginganddelevery.entity.ChargeDetails;
import com.packaginganddelevery.entity.PackageAndDeliveryCostDetail;

@Service
public class PackagingAndDeliveryService {
	
	@Autowired
	PackageAndDeliveryCostDetail detail;

	public ChargeDetails getPackagingAndDeliveryCharge(String componentType, int count) {
		ChargeDetails chargeDetails = new ChargeDetails();
		if (componentType.equalsIgnoreCase("integral") && count > 0) {
			int charge = (detail.getIntegraItem()*count)+(detail.getIntegralItemDeliveryCharge()*count)+detail.getProtectiveSheath();
			chargeDetails.setProcessingAndDeliveryCharge(charge);
			return chargeDetails;
  
		}
		
		else if(componentType.equalsIgnoreCase("accessory") && count > 0){
			int charge = (detail.getAcessory()*count)+(detail.getAccessoryDeliveryCharge()*count)+detail.getProtectiveSheath();
			chargeDetails.setProcessingAndDeliveryCharge(charge);
			return chargeDetails;
			
		}
		return chargeDetails;
	}

}

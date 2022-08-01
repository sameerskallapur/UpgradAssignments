package com.packaginganddelevery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.packaginganddelevery.entity.ChargeDetails;
import com.packaginganddelevery.service.PackagingAndDeliveryService;

@RestController
public class PackagingAndDeliveryController {
	
    @Autowired
	PackagingAndDeliveryService service;
	
	@GetMapping("/getPackagingDeliveryCharge/{componentType}/{count}")
		public ChargeDetails getPackagingAndDeliveryCharge(@PathVariable String componentType,@PathVariable int count) {
			return service.getPackagingAndDeliveryCharge(componentType,count);
		}
	}


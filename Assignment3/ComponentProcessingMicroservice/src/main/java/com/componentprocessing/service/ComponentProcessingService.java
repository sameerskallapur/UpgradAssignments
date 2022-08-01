package com.componentprocessing.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.componentprocessing.common.ChargeDetails;
import com.componentprocessing.entity.ProcessRequest;
import com.componentprocessing.entity.ProcessResponse;
import com.componentprocessing.entity.RepairForIntegralPart;
import com.componentprocessing.entity.ReplacementForAccessoryPart;
import com.componentprocessing.repository.ProcessRequestRepo;
import com.componentprocessing.repository.ProcessResponseRepo;

@Service
public class ComponentProcessingService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProcessRequestRepo processRequestRepo;
	@Autowired
	private ProcessResponseRepo processResponseRepo;
	@Autowired
	private RepairForIntegralPart integralPart;
	@Autowired
	private ReplacementForAccessoryPart accessoryPart;
	
	public ProcessResponse getProcessDetails(ProcessRequest processRequest) {
		
		processRequestRepo.save(processRequest);
		ProcessResponse processResponse = new ProcessResponse();
		Random random = new Random();
		processResponse.setRequestId(random.nextInt(100000, 200000));
        ChargeDetails chargeDetails  = restTemplate.getForObject("http://PACKAGINGANDDELIVERY-SERVICE/getPackagingDeliveryCharge/"+processRequest.getDefectiveComponentDetail().getComponentType()+"/"+processRequest.getDefectiveComponentDetail().getQuantity(),ChargeDetails.class);
        processResponse.setPackagingAndDeleveryCharge(chargeDetails.getProcessingAndDeliveryCharge());
        if(processRequest.getDefectiveComponentDetail().getComponentType().equalsIgnoreCase("integral")) {
        	 processResponse.setProcessingCharge(integralPart.processingFee()*processRequest.getDefectiveComponentDetail().getQuantity());
        }
        else if(processRequest.getDefectiveComponentDetail().getComponentType().equalsIgnoreCase("accessory")) {
       	 processResponse.setProcessingCharge(accessoryPart.processingFee()*processRequest.getDefectiveComponentDetail().getQuantity());

        }
        processResponse.setDateOfDelivery(processRequest.getDate());
        processResponseRepo.save(processResponse);
		return processResponse;
	}

	public String completeProcessing(int requestId, int creditCardNumber, int creditLimit, int processingCharge) {
		
		return "process completed";
	}

}

package com.componentprocessing.entity;

import org.springframework.stereotype.Component;

@Component
public class RepairForIntegralPart implements ProcessingService{
	
	private int duration=5;
	private int processingCharge=500;
	@Override
	public int processingFee() {
		return processingCharge;
	}
	@Override
	public int duration() {
		return duration;
	}

}

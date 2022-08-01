package com.componentprocessing.entity;

import org.springframework.stereotype.Component;

@Component
public class ReplacementForAccessoryPart implements ProcessingService{

	private int duration=2;
	private int processingCharge=300;
	@Override
	public int processingFee() {
		return processingCharge;
	}
	@Override
	public int duration() {
		return duration;
	}
	
}

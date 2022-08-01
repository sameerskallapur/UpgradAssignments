package com.componentprocessing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class DefectiveComponentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String componentType;
	private String componentName;
	private int quantity;
	@OneToOne(mappedBy = "defectiveComponentDetail")
	private ProcessRequest processRequest;
	
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProcessRequest getProcessRequest() {
		return processRequest;
	}
	public void setProcessRequest(ProcessRequest processRequest) {
		this.processRequest = processRequest;
	}
	
	
}

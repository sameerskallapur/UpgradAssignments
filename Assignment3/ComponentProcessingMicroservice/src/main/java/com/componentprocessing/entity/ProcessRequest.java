package com.componentprocessing.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProcessRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int contactNumber;
	private String date;
	@OneToOne(cascade = CascadeType.ALL)
	private DefectiveComponentDetail defectiveComponentDetail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public DefectiveComponentDetail getDefectiveComponentDetail() {
		return defectiveComponentDetail;
	}
	public void setDefectiveComponentDetail(DefectiveComponentDetail defectiveComponentDetail) {
		this.defectiveComponentDetail = defectiveComponentDetail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}

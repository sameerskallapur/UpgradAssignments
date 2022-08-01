package com.ordermanagement.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.ordermanagement.statusEnum.OrderLineStatus;

public class OrderLine {
	@NotNull(message = "item cannot be null")
	private String item;
	@Min(value = 1, message = "price cant be less than 1")
	private int price;
	@Min(value = 1, message = "quantity cant be less than 1")
	private int quantity;
	private Date eta;
	private String status;
	
	public OrderLine(@NotNull(message = "item cannot be null") String item,
			@Min(value = 1, message = "price cant be less than 1") int price,
			@Min(value = 1, message = "quantity cant be less than 1") int quantity, Date eta, String status) {
		super();
		this.item = item;
		this.price = price;
		this.quantity = quantity;
		this.eta = eta;
		this.status = status;
	}

	public OrderLine() {
		// TODO Auto-generated constructor stub
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}

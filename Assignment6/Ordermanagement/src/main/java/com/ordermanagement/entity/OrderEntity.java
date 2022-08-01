package com.ordermanagement.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ordermanagement.dto.OrderLine;
import com.ordermanagement.statusEnum.OrderStatus;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private int totalAmount;
	private Date orderDate;
	private String status;
	
	@OneToMany(targetEntity = OrderLineEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_orderLine_fk" , referencedColumnName = "id")
	private List<OrderLineEntity> orderLines;
	
	@OneToOne
	@JoinColumn(name = "order_address_fk")
	private AddressEntity addressEntity;

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderLineEntity> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLineEntity> orderLines) {
		this.orderLines = orderLines;
	}

	
	

}

package com.ordermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ordermanagement.dto.Order;
import com.ordermanagement.entity.OrderEntity;

@Service
public interface OrderManagementService {

	public OrderEntity placeOrder(Order order);

	public OrderEntity getOrderById(int id);

	public List<OrderEntity> getOrderByPincode(String pincode);

	
}

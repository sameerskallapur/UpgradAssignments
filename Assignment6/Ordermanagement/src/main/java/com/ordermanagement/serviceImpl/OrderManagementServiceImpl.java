package com.ordermanagement.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ordermanagement.dto.Address;
import com.ordermanagement.dto.Order;
import com.ordermanagement.dto.OrderLine;
import com.ordermanagement.entity.AddressEntity;
import com.ordermanagement.entity.OrderEntity;
import com.ordermanagement.entity.OrderLineEntity;
import com.ordermanagement.repository.AddressRepository;
import com.ordermanagement.repository.OrderLineRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.service.OrderManagementService;
import com.ordermanagement.statusEnum.OrderLineStatus;
import com.ordermanagement.statusEnum.OrderStatus;

@Component
public class OrderManagementServiceImpl implements OrderManagementService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderLineRepository orderLineRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void placeOrder(Order order) {
		OrderEntity orderEntity = new OrderEntity();
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(order.getAddress().getCity());
		addressEntity.setCountry(order.getAddress().getCountry());
		addressEntity.setPincode(order.getAddress().getPincode());
		addressRepository.save(addressEntity);
		
		List<OrderLineEntity> allOrderLineEntity = new ArrayList<>();
		
		for (OrderLine orderLine : order.getOrderLines()) {
			OrderLineEntity orderlineEntity = new OrderLineEntity();
			orderlineEntity.setEta(orderLine.getEta());
			orderlineEntity.setItem(orderLine.getItem());
			orderlineEntity.setPrice(orderLine.getPrice());
			orderlineEntity.setQuantity(orderLine.getQuantity());
			
			if (orderLine.getStatus().equals("open")) {
				orderlineEntity.setStatus(OrderLineStatus.OPEN.toString());
			} else if (orderLine.getStatus().equals("cancel")) {
				orderlineEntity.setStatus(OrderLineStatus.CANCELLED.toString());
			}else if (orderLine.getStatus().equals("completed")) {
				orderlineEntity.setStatus(OrderLineStatus.DELIVERED.toString());
			}else if (orderLine.getStatus().equals("cancelled")) {
				orderlineEntity.setStatus(OrderLineStatus.CANCELLED.toString());
			}
			
//			orderlineEntity.setStatus(orderLine.getStatus());
			allOrderLineEntity.add(orderlineEntity);
		}
		orderLineRepository.saveAll(allOrderLineEntity);
		
		orderEntity.setOrderLines(allOrderLineEntity);
		
		orderEntity.setTotalAmount(order.getTotalAmount());
		orderEntity.setOrderDate(order.getOrderDate());
//		orderEntity.setOrderLines(order.getOrderLines());
		if (order.getStatus().equals("open")) {
			orderEntity.setStatus(OrderStatus.OPEN.toString());
		} else if (order.getStatus().equals("cancel")) {
			orderEntity.setStatus(OrderStatus.CANCELLED.toString());
		}else if (order.getStatus().equals("completed")) {
			orderEntity.setStatus(OrderStatus.COMPLETED.toString());
		}
		orderEntity.setAddressEntity(addressEntity);
		orderRepository.save(orderEntity);
	}

	@Override
	public OrderEntity getOrderById(int id) {
		OrderEntity orderEntity = orderRepository.findById(id).get();
		return orderEntity;
	}

	@Override
	public List<OrderEntity> getOrderByPincode(String pincode) {
		List<AddressEntity> addressList = addressRepository.findByPincode(pincode);
		List<OrderEntity> orderList = new ArrayList<>();
		for (AddressEntity addressEntity : addressList) {
			OrderEntity order = orderRepository.getOrderEntity(addressEntity.getId());
			orderList.add(order);
		}
		return orderList;
	}

}

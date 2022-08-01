package com.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.dto.Order;
import com.ordermanagement.entity.OrderEntity;
import com.ordermanagement.service.OrderManagementService;

@RestController
@RequestMapping("/api/v1/orderManagement")
public class OrderManagementController {
	
	@Autowired
	private OrderManagementService orderManagementService;
	
	@PostMapping("/placeOrder")
	public 	ResponseEntity<String>  placeOrder(@RequestBody Order order) {
		String message = null;
		try {
			if (order == null) {
				throw new Exception("order can not be null");
			}
			orderManagementService.placeOrder(order);
			message = "Placing Order success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "Something went wrong please check again";
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	
	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<OrderEntity> getOrerById(@PathVariable("id") int id){
		OrderEntity orderEntity = null;
		try {
			if (id == 0) {
				throw new Exception("id can not be zero");
			}
			orderEntity = orderManagementService.getOrderById(id);
			if (orderEntity == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<OrderEntity>(orderEntity , HttpStatus.OK);
	}
	
	@GetMapping("/getOrderByPincode/{pincode}")
	public ResponseEntity<List<OrderEntity>> getOrerByPincode(@PathVariable("pincode") String pincode){
		List<OrderEntity> orderEntity = null;
		try {
			if (pincode == null) {
				throw new Exception("pincode can not be null");
			}
			orderEntity = orderManagementService.getOrderByPincode(pincode);
			if (orderEntity == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<OrderEntity>>(orderEntity , HttpStatus.OK);
	}

}

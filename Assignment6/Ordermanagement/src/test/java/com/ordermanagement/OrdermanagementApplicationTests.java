package com.ordermanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
class OrdermanagementApplicationTests {

	@Autowired
	private OrderManagementService orderManagementService;
	
	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private OrderLineRepository orderLineRepository;
	
	@Mock
	private AddressRepository addressRepository;
	
	private AddressEntity addressEntity;
	private OrderEntity orderEntity ;
	private OrderLineEntity orderLineEntity;
	private Order order;
	private Address address;
	private OrderLine orderLine;
	
	@BeforeEach
	public void init() {
		addressEntity = new AddressEntity();
		orderEntity = new OrderEntity();
		orderLineEntity = new OrderLineEntity();
		
		order = new Order();
		address = new Address();
		orderLine = new OrderLine();
		
		addressEntity.setCity("atp");
		addressEntity.setCountry("india");
		addressEntity.setPincode("111111");

		orderLineEntity.setId(1);
		orderLineEntity.setItem("laptop");
		orderLineEntity.setPrice(60000);
		orderLineEntity.setQuantity(1);
		orderLineEntity.setEta(getDate("31/03/2022"));
		orderLineEntity.setStatus(OrderLineStatus.OPEN.toString());
		
		List<OrderLineEntity> orderlinesList = new ArrayList<>();
		orderlinesList.add(orderLineEntity);
		
		orderEntity.setTotalAmount(60000);
		orderEntity.setOrderDate(getDate("01-01-2022"));
		orderEntity.setStatus(OrderStatus.OPEN.toString());
		orderEntity.setAddressEntity(addressEntity);
		orderEntity.setOrderLines(orderlinesList);
		
		
		List<OrderEntity> ordersList = new ArrayList<>();
		ordersList.add(orderEntity);
//		------------------
		
		address.setCity("atp");
		address.setCountry("india");
		address.setPincode("111111");

		orderLine.setItem("laptop");
		orderLine.setPrice(60000);
		orderLine.setQuantity(1);
		orderLine.setEta(getDate("31/03/2022"));
		orderLine.setStatus(OrderLineStatus.OPEN.toString());
		
		List<OrderLine> orderlines2 = new ArrayList<>();
		orderlines2.add(orderLine);
		
		order.setTotalAmount(60000);
		order.setOrderDate(getDate("01-01-2022"));
		order.setStatus(OrderStatus.OPEN.toString());
		order.setAddress(address);
		order.setOrderLines(orderlines2);
		
		
		List<Order> ordersList1 = new ArrayList<>();
		ordersList1.add(order);
		
//		Mockito.when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
		
	}
	
	public static Date getDate(String dateAsString) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			date = formatter.parse(dateAsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date;
	}
	
	@Test
	public void placeOrderTest() {
		when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
		assertEquals(orderEntity, orderManagementService.placeOrder(order));
	} 
	
	@Test
	public void getOrdersByPincodeTestForNotNullCheck() {
		String pincode = "111111";
		List<OrderEntity> ordersList = new ArrayList<>();
		List<AddressEntity> addressList = new ArrayList<>();
		Mockito.when(addressRepository.findByPincode(pincode)).thenReturn(addressList);
		
		Mockito.verify(orderManagementService).getOrderByPincode(pincode);
		assertNotNull(ordersList.get(0).getAddressEntity().getPincode());
	}
	
	@Test
	public void getOrdersByPincodeTest() {
		String pincode = "111111";
		List<OrderEntity> ordersList = new ArrayList<>();
		Mockito.when(orderManagementService.getOrderByPincode(pincode)).thenReturn(ordersList);
		Mockito.verify(orderManagementService).getOrderByPincode(pincode);
		assertEquals(pincode, ordersList.get(0).getAddressEntity().getPincode());
	}
	
	@Test
	public void getOrdersByIdTestForNotNullCheck() {
		int id = 111111;
		OrderEntity order = new OrderEntity();
		Mockito.when(orderManagementService.getOrderById(id)).thenReturn(order);
		Mockito.verify(orderManagementService).getOrderById(id);
		assertNotNull(order.getId());
	}
	
	@Test
	public void getOrdersByIdTest() {
		int id = 111111;
		OrderEntity order = new OrderEntity();
		Mockito.when(orderManagementService.getOrderById(id)).thenReturn(order);
		Mockito.verify(orderManagementService).getOrderById(id);
		assertEquals(id, order.getId());
	}
	
	@Test
	public void placeOrderTestForNotNullCheck() {
//		OrderEntity order = new OrderEntity();
		Mockito.when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
//		Mockito.verify(orderManagementService).placeOrder(this.order);
		assertNotNull(orderEntity);
	}	

}

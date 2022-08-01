package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ordermanagement.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
//	public OrderEntity findByOrder_address_fk(int order_address_pk);
	
	@Query("from OrderEntity o where o.addressEntity.id=?1")
	OrderEntity getOrderEntity(int order_address_fk);

}

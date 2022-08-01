package com.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.entity.OrderLineEntity;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity	, Integer> {

}

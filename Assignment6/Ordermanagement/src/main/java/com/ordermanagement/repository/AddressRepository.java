package com.ordermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

	List<AddressEntity> findByPincode(String pincode);
}

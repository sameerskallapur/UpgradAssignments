package com.StoreManagement.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.StoreManagement.demo.entities.StoreEntity;

@Repository
public interface StoreDetailRepo extends CrudRepository<StoreEntity, Integer> {

	List<StoreEntity> findByPincode(String pincode);
	
	
}

package com.StoreManagement.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StoreManagement.demo.entities.StoreEntity;
import com.StoreManagement.demo.pojos.Store;

@Service
public interface StoreService {

	public void addStore(Store store) throws Exception;
	
	public StoreEntity getStore(String storeId);

	public List<StoreEntity> getStoresOnPincode(String pincode);
}

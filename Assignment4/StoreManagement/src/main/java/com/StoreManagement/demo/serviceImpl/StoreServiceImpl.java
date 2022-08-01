package com.StoreManagement.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.StoreManagement.demo.entities.StoreEntity;
import com.StoreManagement.demo.pojos.Store;
import com.StoreManagement.demo.repositories.StoreDetailRepo;
import com.StoreManagement.demo.services.StoreService;

@Component
public class StoreServiceImpl implements StoreService {

	@Autowired 
	private StoreDetailRepo storeDetailRepo;
	
	@Override
	public void addStore(Store store) throws Exception {
//		validation
		if (store.getStoreName().isEmpty()||store.getAddressLine1().isEmpty()||store.getState().isEmpty()
				||store.getCountry().isEmpty()||store.getPincode().isEmpty()||store.getPhNumber().isEmpty()){
			throw new Exception("Insufficient Details");
		}
		
		StoreEntity storeEntity = new StoreEntity();
		storeEntity.setName(store.getStoreName());
		storeEntity.setAddressline1(store.getAddressLine1());
		storeEntity.setAddressline2(store.getAddressLine2());
		storeEntity.setState(store.getState());
		storeEntity.setCountry(store.getCountry());
		storeEntity.setPincode(store.getPincode());
		storeEntity.setPhNumber(store.getPhNumber());
		storeEntity.setEmail(store.getEmail());
		
		StoreEntity newStore = storeDetailRepo.save(storeEntity);
	}

	@Override
	public StoreEntity getStore(String storeId) {
		Integer id = Integer.parseInt(storeId);
		StoreEntity storeDetails = storeDetailRepo.findById(id).get();
		return storeDetails;
	}

	@Override
	public List<StoreEntity> getStoresOnPincode(String pincode) {
		List<StoreEntity> allStores = storeDetailRepo.findByPincode(pincode);
		return allStores;
	}
	
}

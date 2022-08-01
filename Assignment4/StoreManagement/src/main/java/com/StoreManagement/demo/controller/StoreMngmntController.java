package com.StoreManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StoreManagement.demo.entities.StoreEntity;
import com.StoreManagement.demo.pojos.Store;
import com.StoreManagement.demo.services.StoreService;

@RestController
public class StoreMngmntController {

	@Autowired
	private StoreService storeService;
	
	
	@PostMapping("/store/add")
	public ResponseEntity<String> addStore(@RequestBody Store newStore) {
		String message = null;
		HttpStatus status ;
		try {
			 storeService.addStore(newStore);
			 message = "new Store added";
			 status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(message);
	}
	
	@GetMapping("/store/getDetails/{id}")
	public ResponseEntity<StoreEntity> getStoreDetails(@PathVariable("id") String storeId){
		 StoreEntity store = storeService.getStore(storeId);
		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StoreEntity>(store , HttpStatus.OK);
	}
	
	@GetMapping("/store/getBasedOnPincode/{pincode}")
	public ResponseEntity<List<StoreEntity>> getStoreDetailsOnPincpde(@PathVariable("pincode") String pincode){
		 List<StoreEntity> store = storeService.getStoresOnPincode(pincode);
		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StoreEntity>>(store , HttpStatus.OK);
	}
}

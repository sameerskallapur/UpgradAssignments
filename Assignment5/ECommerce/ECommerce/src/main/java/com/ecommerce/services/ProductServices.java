package com.ecommerce.services;

import org.springframework.stereotype.Service;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.pojos.Product;

@Service
public interface ProductServices {

	public void addProduct(Product product) throws Exception;

	public ProductEntity viewProduct(String productName, String model);

	public ProductEntity searchProduct(String productName, String model, String minAmount, String maxAmount);

}

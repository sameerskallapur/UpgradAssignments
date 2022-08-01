package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Product;


@Service
public class ProductService {
	
	@Autowired
	ProductMongoRepository productMongoRepository;
	
	@Transactional
	public Product saveProduct(Product product) {
		productMongoRepository.save(product);
		return product;
	}

	public Optional<Product> getProduct(String id) {
		return productMongoRepository.findById(id);
	}

	public Optional<Product> getProductByName(String name) {
		Optional<Product> product = productMongoRepository.getByName(name);
		return product;
	}
}

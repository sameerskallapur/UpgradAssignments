package com.example.service;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Product;


public interface ProductMongoRepository extends MongoRepository<Product, String>{

	Optional<Product> getByName(String name);

}

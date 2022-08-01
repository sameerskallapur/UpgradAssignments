package com.ecommerce.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.repositories.ProductRepository;

//@Component
public class InitializationCommandLineRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		 ProductEntity product = new ProductEntity();
		 product.setProductName("phone");
		 product.setModel("samsung");
		 product.setMadeBy("SamsungCreator");
		 product.setPrice(40000);
		 product.setQuantity(10);
		 productRepository.save(product);
		 
		 ProductEntity product2 = new ProductEntity();
		 product.setProductName("laptop");
		 product.setModel("toshiba");
		 product.setMadeBy("ToshibaCreator");
		 product.setPrice(80000);
		 product.setQuantity(10);
		 productRepository.save(product2);
		 
		 ProductEntity product3 = new ProductEntity();
		 product.setProductName("pen");
		 product.setModel("renolds");
		 product.setMadeBy("RenoldsCreator");
		 product.setPrice(50);
		 product.setQuantity(10);
		 productRepository.save(product3);
		 
		 ProductEntity product4 = new ProductEntity();
		 product.setProductName("Book");
		 product.setModel("Harrypotter");
		 product.setMadeBy("HarrypotterCreator");
		 product.setPrice(400);
		 product.setQuantity(10);
		 productRepository.save(product4);
		 
		 ProductEntity product5 = new ProductEntity();
		 product.setProductName("Tv");
		 product.setModel("Nokia");
		 product.setMadeBy("NokiaCreator");
		 product.setPrice(50000);
		 product.setQuantity(10);
		 productRepository.save(product5);
		 
   }


}

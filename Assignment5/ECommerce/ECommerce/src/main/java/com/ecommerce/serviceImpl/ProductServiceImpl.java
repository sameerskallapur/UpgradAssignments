package com.ecommerce.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.pojos.Product;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.services.ProductServices;

@Component
public class ProductServiceImpl implements ProductServices {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) throws Exception {
		if (product.getProductName().isEmpty()||product.getMadeBy().isEmpty()||product.getModel().isEmpty()||
				Integer.valueOf(product.getPrice())==null||Integer.valueOf(product.getQuantity())==null){
			throw new Exception("Insufficient Details");
		}
		ProductEntity prodEntity = productRepository.findByProductNameAndModel(product.getProductName(), product.getModel());
//				new ProductEntity();
				
		if (prodEntity!=null) {
			int newQuantity = prodEntity.getQuantity()+product.getQuantity();
			prodEntity.setQuantity(newQuantity);
			prodEntity.setProductName(product.getProductName());
			prodEntity.setMadeBy(product.getMadeBy());
			prodEntity.setPrice(product.getPrice());
			prodEntity.setModel(product.getModel());
			
			productRepository.save(prodEntity);
		} 
		else {
			prodEntity = new ProductEntity();
			BeanUtils.copyProperties(product, prodEntity);
			productRepository.save(prodEntity);
		}
		
	}

	@Override
	public ProductEntity viewProduct(String productName , String model) {
		ProductEntity prodEntity = productRepository.findByProductNameAndModel(productName, model);
				
		return prodEntity;
	}

	@Override
	public ProductEntity searchProduct(String productName, String model, String minAmount, String maxAmount) {
		ProductEntity prodEntity = productRepository.searchProductForBuyer(productName, model,minAmount,maxAmount);
		return prodEntity;
	}

}

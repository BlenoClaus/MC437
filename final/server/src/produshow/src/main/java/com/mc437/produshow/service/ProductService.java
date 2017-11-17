package com.mc437.produshow.service;

import org.springframework.stereotype.Service;

import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.retro.ProductModule;

import retrofit2.Retrofit;

@Service
public class ProductService {

	public Product getProductById(Long productId) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://54.232.225.17:8082/").build();
		ProductModule productModule = retrofit.create(ProductModule.class);
		Product product = productModule.getProduct(productId);
		System.out.println("fetching product for id " + productId);
		System.out.println("name " + product.getName());
		System.out.println("amount " + product.getAmount());
		
		return product;
	}
	
}

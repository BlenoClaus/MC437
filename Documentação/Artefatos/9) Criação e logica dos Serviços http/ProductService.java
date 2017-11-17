package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Product;
import com.mc437.produshow.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Page<Product> findAll (Pageable p) {
		return productRepository.findAll(p);
	}
	
	public Product findById (Long productId) throws GeneralException {
		Product product = productRepository.findOne(productId);
		
		if (product == null) {
			throw new GeneralException("PRODUCT_NOT_FOUND");
		}
		
		return product;
	}
	
	public Product create (Product product) throws GeneralException {
		
		if (product.getId() != null) {
			throw new GeneralException("NEW_ENTITY_ID");
		}
		
		return productRepository.save(product);
	}
	
	public Product update (Product product, Long productId) throws GeneralException {
		
		if (product.getId() != productId) {
			throw new GeneralException("MULTIPLE_ENTITY_ID");
		}
		
		Product fromDb = productRepository.findOne(productId);
		
		if (fromDb == null) {
			throw new GeneralException("PRODUCT_NOT_FOUND");
		}
		
		return productRepository.save(product);
		
	}
	
}

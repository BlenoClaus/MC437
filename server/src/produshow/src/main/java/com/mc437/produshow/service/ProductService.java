package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Product;
import com.mc437.produshow.model.SortOrderType;
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
	
	public Long removeSome (Long productId, Long amount) throws GeneralException {
		Product product = productRepository.findOne(productId);
		
		if (product.getAmount() < amount) {
			throw new GeneralException("NOT_ENOUGH_STOCK");
		}
		product.setAmount(product.getAmount() - amount);
		
		productRepository.save(product);
		
		return product.getAmount();
	}
	
	public Page<Product> searchProducts(String query, String category, SortOrderType sortOrder, Pageable p) {
//		System.out.println("query");
//		System.out.println(query);
//		System.out.println("category");
//		System.out.println(category);
//		System.out.println("sortOrder");
//		System.out.println(sortOrder);
//		return null;
//		return productRepository.findByNameContaining(query, p);
		if (query == null) {
			query = "";
		}
		if (sortOrder == null) {
			sortOrder = SortOrderType.LOWER_PRICE;
		}
		
		Sort sort = null;
		if (sortOrder != null && sortOrder.equals(SortOrderType.HIGHEST_PRICE)) {
			sort = new Sort(Direction.DESC, "price");
		} else {
			sort = new Sort(Direction.ASC, "price");
		}
		
		if (category != null) {
			return productRepository.findByNameContainingAndCategory(query, category, p);
		} else {
			return productRepository.findByNameContaining(query, p);
		}
	}
}

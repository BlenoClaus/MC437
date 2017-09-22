package com.mc437.produshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}

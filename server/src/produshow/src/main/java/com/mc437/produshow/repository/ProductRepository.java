package com.mc437.produshow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	Page<Product> findByNameContainingAndCategory(String name, String category, Pageable p);
	Page<Product> findByNameContaining(String name, Pageable p);
}

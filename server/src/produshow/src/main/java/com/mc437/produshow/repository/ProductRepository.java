package com.mc437.produshow.repository;

import org.springframework.data.repository.CrudRepository;

import com.mc437.produshow.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}

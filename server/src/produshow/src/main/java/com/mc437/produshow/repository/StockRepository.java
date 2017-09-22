package com.mc437.produshow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
	Page<Stock> findByProductId(Long productId, Pageable p);
}

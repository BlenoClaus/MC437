package com.mc437.produshow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.Lot;

public interface LotRepository extends JpaRepository<Lot, Long>{
	Page<Lot> findByStockId(Long stockId, Pageable p);
}

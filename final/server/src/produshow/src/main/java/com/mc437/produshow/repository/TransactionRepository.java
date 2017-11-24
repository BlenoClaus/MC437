package com.mc437.produshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.payment.BuyProductRequest;

public interface TransactionRepository extends JpaRepository<BuyProductRequest, Long>{

	List<BuyProductRequest> findByClientId(String clientId);
	
}

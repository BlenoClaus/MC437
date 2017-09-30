package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Stock;
import com.mc437.produshow.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired ProductService productService;
	
	public Page<Stock> findAll (Long productId, Pageable p) throws GeneralException {
		
		productService.findById(productId);
		
		return stockRepository.findByProductId(productId, p);
	}
	
	
	public Stock findById (Long productId, Long stockId) throws GeneralException {
		
		productService.findById(productId);
		
		Stock stock = stockRepository.findOne(stockId);
		if (stock == null || stock.getProductId() != productId) {
			throw new GeneralException("STOCK_NOT_FOUND");
		}
		
		return stock;
	}
	
	public Stock create (Long productId, Stock stock) throws GeneralException {
		productService.findById(productId);
		
		stock.setProductId(productId);
		
		if (stock.getId() != null) {
			throw new GeneralException("NEW_ENTITY_ID");
		}
		
		return stockRepository.save(stock);
	}
	
}

package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Lot;
import com.mc437.produshow.repository.LotRepository;

@Service
public class LotService {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private LotRepository lotRepository;
	
	public	Page<Lot> findAll (Long productId, Long stockId, Pageable p) throws GeneralException {
		
		stockService.findById(productId, stockId);
		
		return lotRepository.findByStockId(stockId, p);
	}
	
	public Lot create (Long productId, Long stockId, Lot lot) throws GeneralException {
		
		stockService.findById(productId, stockId);
		
		if (lot.getId() != null) {
			throw new GeneralException("NEW_ENTITY_ID");
		}
		
		lot.setStockId(stockId);
		return lotRepository.save(lot);
	}
	
	public Lot findById (Long productId, Long stockId, Long lotId) throws GeneralException {
		stockService.findById(productId, stockId);
		Lot lot = lotRepository.findOne(lotId);
		if (lot == null) {
			throw new GeneralException("LOT_NOT_FOUND");
		}
		return lot;
	}
	
}

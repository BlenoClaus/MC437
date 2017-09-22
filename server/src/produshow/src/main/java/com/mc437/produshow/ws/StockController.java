package com.mc437.produshow.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Stock;
import com.mc437.produshow.service.StockService;

@RestController
@RequestMapping("/product/{productId}/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Page<Stock> findAll (@PathVariable("productId") Long productId ,Pageable p) {
		return stockService.findAll(productId, p);
	}
	
	@RequestMapping(value="{stockId}", method=RequestMethod.GET)
	public Stock findById (@PathVariable("productId") Long productId, @PathVariable("stockId") Long stockId) throws Exception {
		return stockService.findById(productId, stockId);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Stock create (@PathVariable("productId") Long productId, @RequestBody Stock stock) throws GeneralException {
		return stockService.create(productId, stock);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public Stock update (@PathVariable("productId") Long productId, @RequestBody Stock stock) throws GeneralException {
		return stockService.create(productId, stock);
	}
}

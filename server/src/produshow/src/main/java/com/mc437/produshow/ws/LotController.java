package com.mc437.produshow.ws;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Lot;
import com.mc437.produshow.model.validator.LotValidator;
import com.mc437.produshow.service.LotService;

@RestController
@RequestMapping("product/{productId}/stock/{stockId}/lot")
public class LotController {

	@Autowired
	private LotService lotService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Page<Lot> findAll (@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			Pageable p) throws GeneralException {
		return lotService.findAll(productId, stockId, p);
	}
	
	@RequestMapping(value="{lotId}")
	public Lot findById (@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			@PathVariable("lotId") Long lotId) throws GeneralException {
		return lotService.findById(productId, stockId, lotId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="", method=RequestMethod.POST)
	public Lot create (@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			@Valid @RequestBody Lot lot) throws GeneralException {
		return lotService.create(productId, stockId, lot);
	}
	
	@InitBinder("lot")
	void initValidator(WebDataBinder binder) {
		binder.setValidator(new LotValidator());
	}
	
}

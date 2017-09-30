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
import com.mc437.produshow.model.Occurrence;
import com.mc437.produshow.model.validator.OccurrenceValidator;
import com.mc437.produshow.service.OccurrenceService;

@RestController
@RequestMapping(value="product/{productId}/stock/{stockId}/lot/{lotId}/occurrence")
public class OccurrenceController {

	@Autowired
	private OccurrenceService occurrenceService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Page<Occurrence> findAll (
			@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			@PathVariable("lotId") Long lotId,
			Pageable p) throws GeneralException {
		return occurrenceService.findAll(productId, stockId, lotId, p);
	}
	
	@RequestMapping(value="{occurrenceId}")
	public Occurrence findById (@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			@PathVariable("lotId") Long lotId,
			@PathVariable("occurrenceId") Long occurrenceId) throws GeneralException {
		return occurrenceService.findById(productId, stockId, lotId, occurrenceId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="", method=RequestMethod.POST)
	public Occurrence create (@PathVariable("productId") Long productId,
			@PathVariable("stockId") Long stockId,
			@PathVariable("lotId") Long lotId,
			@Valid @RequestBody Occurrence occurrence) throws GeneralException {
		return occurrenceService.create(productId, stockId, lotId, occurrence);
	}
	
	@InitBinder("occurrence")
	void initValidator(WebDataBinder binder) {
		binder.setValidator(new OccurrenceValidator());
	}
}

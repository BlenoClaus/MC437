package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Occurrence;
import com.mc437.produshow.repository.OccurrenceRepository;

@Service
public class OccurrenceService {

	@Autowired
	private OccurrenceRepository occurrenceRepository;
	
	@Autowired
	private LotService lotService;
	
	public Page<Occurrence> findAll (Long productId, Long stockId, Long lotId, Pageable p) throws GeneralException {
		lotService.findById(productId, stockId, lotId);
		
		return occurrenceRepository.findByLotId(lotId, p);
	}
	
	public Occurrence create (Long productId, Long stockId, Long lotId, Occurrence occurrence) throws GeneralException {
		
		lotService.findById(productId, stockId, lotId);
		
		if (occurrence.getId() != null) {
			throw new GeneralException("NEW_ENTITY_ID");
		}
		
		occurrence.setLotId(lotId);
		return occurrenceRepository.save(occurrence);
	}
	
	public Occurrence findById (Long productId, Long stockId, Long lotId, Long occurrenceId) throws GeneralException {
		lotService.findById(productId, stockId, lotId);
		
		Occurrence occurrence = occurrenceRepository.findOne(occurrenceId);
		if (occurrence == null) {
			throw new GeneralException("OCCURRENCE_NOT_FOUND");
		}
		return occurrence;
	}
	
}

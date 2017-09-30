package com.mc437.produshow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.Occurrence;

public interface OccurrenceRepository extends JpaRepository<Occurrence, Long>{
	Page<Occurrence> findByLotId (Long lotId, Pageable p);
}

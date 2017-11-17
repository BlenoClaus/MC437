package com.mc437.produshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "occurrence")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Occurrence {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "event")
	private Event event;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "lot_id")
	private Long lotId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getLotId() {
		return lotId;
	}
	
	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}
	
}

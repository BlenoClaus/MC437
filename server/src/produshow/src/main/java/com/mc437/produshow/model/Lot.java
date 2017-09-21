package com.mc437.produshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lot")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lot {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "action")
	private Action action;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;
	
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;

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

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
}

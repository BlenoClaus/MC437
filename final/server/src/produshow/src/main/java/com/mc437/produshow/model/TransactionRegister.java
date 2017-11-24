package com.mc437.produshow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mc437.produshow.model.payment.Transaction;
import com.mc437.produshow.model.product.Product;

public class TransactionRegister {

	private Product product;
	
	@JsonProperty("transacao")
	private Transaction transaction;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
}

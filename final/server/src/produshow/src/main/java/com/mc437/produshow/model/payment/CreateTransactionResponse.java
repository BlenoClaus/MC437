package com.mc437.produshow.model.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateTransactionResponse {

	@JsonProperty("dados")
	private Data data;
	
	@JsonProperty("msg")
	private String msg;
	

	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Data {
		
		public Data() {
			// TODO Auto-generated constructor stub
		}
		
		@JsonProperty("estado")
		private TransactionState state;
		
		@JsonProperty("tipo_pagamento")
		private String paymentType;
		
		@JsonProperty("valor_total")
		private String totalValue;
		
		@JsonProperty("id_transacao")
		private long id;

		public TransactionState getState() {
			return state;
		}

		public void setState(TransactionState state) {
			this.state = state;
		}

		public String getPaymentType() {
			return paymentType;
		}

		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		public String getTotalValue() {
			return totalValue;
		}

		public void setTotalValue(String totalValue) {
			this.totalValue = totalValue;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		} 
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
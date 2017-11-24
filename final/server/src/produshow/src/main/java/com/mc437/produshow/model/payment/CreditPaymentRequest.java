package com.mc437.produshow.model.payment;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditPaymentRequest {

	@JsonProperty("valor_total")
	private long totalValue;
	
	@JsonProperty("n_parcelas")
	private long amountParcel;
	
	@JsonProperty("valor_parcela")
	private long valueParcel;
	
	@JsonProperty("cnpj_loja")
	private String taxDoc;
	
	@JsonProperty("format")
	private PaymentFormat format;
	
	@JsonProperty("api_key")
	private String apiKey;
	
	@JsonProperty("tipo_trans")
	private Long transType;
	
	@JsonProperty("numero_cartao")
	private String cardNumber;
	
	@JsonProperty("nome_cartao")
	private String cardHolder;
	
	@JsonProperty("data_expiracao")
	private Date expirationDate;
	
	@JsonProperty("codigo_verificacao")
	private String cardSecurity;
	
	@JsonProperty("tipo_cartao")
	private CardType cardType;

	public long getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}

	public long getAmountParcel() {
		return amountParcel;
	}

	public void setAmountParcel(long amountParcel) {
		this.amountParcel = amountParcel;
	}

	public long getValueParcel() {
		return valueParcel;
	}

	public void setValueParcel(long valueParcel) {
		this.valueParcel = valueParcel;
	}

	public String getTaxDoc() {
		return taxDoc;
	}

	public void setTaxDoc(String taxDoc) {
		this.taxDoc = taxDoc;
	}

	public PaymentFormat getFormat() {
		return format;
	}

	public void setFormat(PaymentFormat format) {
		this.format = format;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Long getTransType() {
		return transType;
	}

	public void setTransType(Long transType) {
		this.transType = transType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardSecurity() {
		return cardSecurity;
	}

	public void setCardSecurity(String cardSecurity) {
		this.cardSecurity = cardSecurity;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
}

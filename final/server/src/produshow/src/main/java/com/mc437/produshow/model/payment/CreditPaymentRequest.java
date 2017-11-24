package com.mc437.produshow.model.payment;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditPaymentRequest {
	private Long totalValue;
	
	private Long amountParcel;
	
	private Long valueParcel;
	
	private String taxDoc;
	
	private PaymentFormat format;
	
	private String apiKey;
	
	private Long transType;
	
	private String cardNumber;
	
	private String cardHolder;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expirationDate;
	
	private String cardSecurity;
	
	private CardType cardType;

	public Long getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}

	public Long getAmountParcel() {
		return amountParcel;
	}

	public void setAmountParcel(Long amountParcel) {
		this.amountParcel = amountParcel;
	}

	public Long getValueParcel() {
		return valueParcel;
	}

	public void setValueParcel(Long valueParcel) {
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

	@Enumerated(EnumType.STRING)
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
}

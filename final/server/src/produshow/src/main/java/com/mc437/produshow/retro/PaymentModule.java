package com.mc437.produshow.retro;

import com.mc437.produshow.model.payment.CreditPaymentRequest;
import com.mc437.produshow.model.payment.Transaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentModule {

	@POST("transacoes")
	Call<Transaction> create(@Body CreditPaymentRequest request);
	
}

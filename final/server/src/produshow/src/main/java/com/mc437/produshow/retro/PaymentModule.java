package com.mc437.produshow.retro;

import com.mc437.produshow.model.TransactionRegister;
import com.mc437.produshow.model.payment.CreateTransactionResponse;
import com.mc437.produshow.model.payment.Transaction;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PaymentModule {

	@FormUrlEncoded
	@POST("transacoes")
	Call<CreateTransactionResponse> create(
			@Field("valor_total") String totalValue,
			@Field("cnpj_loja") String taxDocument,
			@Field("format") String format,
			@Field("api_key") String apiKey,
			@Field("tipo_trans") String transType,
			@Field("numero_cartao") String cardNumber,
			@Field("nome_cartao") String cardHolder,
			@Field("data_expiracao") String expirationDate,
			@Field("codigo_verificacao") String securityCode,
			@Field("tipo_cartao") String cardType,
			@Field("n_parcelas") String amountParcels,
			@Field("valor_parcela") String parcelValue
			);
	
	@GET("transacoes")
	Call<TransactionRegister> getTransaction (
		@Query("id_trans") String id,
		@Query("cnpj_loja") String taxDoc,
		@Query("format") String format,
		@Query("api_key") String key
	);
	
}

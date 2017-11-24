package com.mc437.produshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.mc437.produshow.retro.PaymentModule;
import com.mc437.produshow.retro.ProductModule;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PaymentService {

	
	@Value("${module.payment.baseUrl}")
	private String baseUrl;
	
	@Value("${module.payment.key}")
	private String key;
	
	@Value("${module.payment.taxDocument}")
	private String taxDocument;

	@Autowired
	private PaymentModule paymentModule;
	
	@Bean
	private PaymentModule paymentModule() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(this.baseUrl).build();
		return retrofit.create(PaymentModule.class);
	}
	
}

package com.mc437.produshow.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.TransactionRegister;
import com.mc437.produshow.model.payment.BuyProductRequest;
import com.mc437.produshow.model.payment.CardType;
import com.mc437.produshow.model.payment.CreateTransactionResponse;
import com.mc437.produshow.model.payment.CreditPaymentRequest;
import com.mc437.produshow.model.payment.PaymentFormat;
import com.mc437.produshow.model.payment.Transaction;
import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.repository.TransactionRepository;
import com.mc437.produshow.retro.PaymentModule;
import com.mc437.produshow.retro.ProductModule;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class PaymentService {

	
	@Value("${module.payment.baseUrl}")
	private String baseUrl;
	
	@Value("${module.payment.key}")
	private String key;
	
	@Value("${module.payment.taxDocument}")
	private String taxDocument;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private PaymentModule paymentModule;
	
	@Autowired
	private ProductService productService;
	
	public void buyProduct (BuyProductRequest request) throws IOException, GeneralException {
		System.out.println("testee");
		
		Product product = productService.getProductById(request.getProductId());
		System.out.println("product price " + product.getPrice());
		
		CreditPaymentRequest paymentReq = request.getRequest();
		paymentReq.setApiKey(this.key);
		paymentReq.setCardType(CardType.credito);
		paymentReq.setFormat(PaymentFormat.json);
		paymentReq.setTaxDoc(this.taxDocument);
		paymentReq.setTotalValue(product.getPrice());
		paymentReq.setTransType(2L);
		paymentReq.setValueParcel(paymentReq.getTotalValue() / paymentReq.getAmountParcel());

		Response<CreateTransactionResponse> transactionResponse = paymentModule.create(
				paymentReq.getTotalValue().toString(),
				paymentReq.getTaxDoc().toString(),
				paymentReq.getFormat().toString(),
				paymentReq.getApiKey().toString(),
				paymentReq.getTransType().toString(),
				paymentReq.getCardNumber().toString(),
				paymentReq.getCardHolder().toString(),
				paymentReq.getExpirationDate().toString(),
				paymentReq.getCardSecurity().toString(),
				paymentReq.getCardType().toString(),
				paymentReq.getAmountParcel().toString(),
				paymentReq.getValueParcel().toString()
				).execute();
		
		if (transactionResponse == null || transactionResponse.body() == null || transactionResponse.body().getData() == null) {
			throw new GeneralException("SEM_PACIENCIA_PRA_MSG_DE_ERRO");
		}
		
		
		request.setTransactionId(transactionResponse.body().getData().getId());
		
		transactionRepository.save(request);
		System.out.println("transaction payment " + transactionResponse.body().getMsg());

	}
	
	public List<TransactionRegister> getHistory (String clientId) throws IOException, GeneralException {
		
		List<BuyProductRequest> reqs = transactionRepository.findByClientId(clientId);
		
		List<TransactionRegister> registers = new ArrayList<>();
		
		for (BuyProductRequest req : reqs) {
			TransactionRegister register = this.paymentModule.getTransaction(req.getTransactionId().toString(), this.taxDocument, "json", this.key).execute().body();
			Product product = productService.getProductById(req.getProductId());

			register.setProduct(product);
			
			registers.add(register);
		}
		
		return registers;
	}
	
	@Bean
	private PaymentModule paymentModule() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(this.baseUrl)
				.addConverterFactory(JacksonConverterFactory.create()).build();;
		return retrofit.create(PaymentModule.class);
	}
	
}

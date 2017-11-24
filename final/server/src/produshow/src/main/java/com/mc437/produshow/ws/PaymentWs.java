package com.mc437.produshow.ws;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.TransactionRegister;
import com.mc437.produshow.model.payment.BuyProductRequest;
import com.mc437.produshow.service.PaymentService;


@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentWs {
	
	@Autowired
	private PaymentService paymentService;
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@RequestMapping(value="", method=RequestMethod.POST)
	public void buyProduct(@RequestBody BuyProductRequest request) throws IOException, GeneralException {
		paymentService.buyProduct(request);
	}
	
	@RequestMapping(value="history/{clientId}", method=RequestMethod.GET)
	public List<TransactionRegister> getHistory (@PathVariable("clientId") String clientId) throws IOException, GeneralException {
		return paymentService.getHistory(clientId);
	}

}

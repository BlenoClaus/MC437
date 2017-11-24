package com.mc437.produshow.ws;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.client.Client;
import com.mc437.produshow.model.client.ClientToken;
import com.mc437.produshow.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientWs {
	
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ClientToken createUser (@RequestBody Client client) throws GeneralException, IOException {
		return clientService.create(client);
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ClientToken login (@RequestBody Client client) throws GeneralException, IOException {
		return clientService.login(client);
	}
	
	@RequestMapping(value="/me", method=RequestMethod.POST)
	public Client fetchClient (@RequestBody ClientToken clientToken) throws IOException, GeneralException {
		return clientService.fetchClient(clientToken);
	}
}

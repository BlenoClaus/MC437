package com.mc437.produshow.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.client.Client;
import com.mc437.produshow.model.client.ClientToken;
import com.mc437.produshow.model.client.Payload;
import com.mc437.produshow.retro.ClientModule;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class ClientService {

	@Value("${module.client.baseUrl}")
	private String baseUrl;
	
	@Autowired
	private ClientModule clientModule;
	
	public ClientToken create (Client client) throws GeneralException, IOException {
		Call<Payload<ClientToken>> call = this.clientModule.createClient(client);
		Response<Payload<ClientToken>> response = call.execute();

		if (response.isSuccessful() == false || response.body().getPayload() == null) {
			System.out.println("Error creating client - " + response.body().getErrorCode());
			throw new GeneralException("GENERIC_ERROR");
		}
		ClientToken clientToken = response.body().getPayload();
		return clientToken;
	}
	
	public ClientToken login (Client client) throws GeneralException, IOException {
		Call<Payload<ClientToken>> call = this.clientModule.authClient(client);
		Response<Payload<ClientToken>> response = call.execute();
		if (response.isSuccessful() == false || response.body().getPayload() == null) {
			throw new GeneralException("GENERIC_ERROR");
		}
		
		ClientToken clientToken = response.body().getPayload();
		return clientToken;
	}
	
	public Client fetchClient (ClientToken token) throws IOException, GeneralException {
		Call<Payload<Client>> call = this.clientModule.fetchClient(token.getId(), token.getToken());
		Response<Payload<Client>> response = call.execute();
		if (response.isSuccessful() == false || response.body().getPayload() == null) {
			System.out.println("Error fetching client - " + response.body().getErrorCode());
			throw new GeneralException("GENERIC_ERROR");
		}
		
		Client client = response.body().getPayload();
		return client;
	}
	
	@Bean
	private ClientModule clientModule () {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(this.baseUrl)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		return retrofit.create(ClientModule.class);
	}
	
}

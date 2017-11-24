package com.mc437.produshow.retro;

import com.mc437.produshow.model.client.Client;
import com.mc437.produshow.model.client.ClientToken;
import com.mc437.produshow.model.client.Payload;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClientModule {

	@POST("client")
	Call<Payload<ClientToken>> createClient (@Body Client client);
	
	@POST("client/auth")
	Call<Payload<ClientToken>> authClient (@Body Client client);
	
	@GET("client/{clientId}")
	Call<Payload<Client>> fetchClient (@Path("clientId") String clientId, @Header("x-access-token") String clientToken);
}

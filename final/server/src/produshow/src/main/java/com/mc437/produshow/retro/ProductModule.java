package com.mc437.produshow.retro;

import com.mc437.produshow.model.product.Product;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductModule {
	
	@GET("product/{productId}")
	Product getProduct (@Path("productId") Long productId);
}

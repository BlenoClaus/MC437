package com.mc437.produshow.retro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.model.product.ProductPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductModule {
	
	@GET("product/{productId}")
	Call<Product> getProduct (@Path("productId") Long productId, @Header("Authorization") String token);
	
	@GET("product/search")
	Call<ProductPage> searchProducts (
			@Query("query") String query,
			@Query("category") String category,
			@Query("size") Long size,
			@Query("page") Long page,
			@Header("Authorization") String token);
}

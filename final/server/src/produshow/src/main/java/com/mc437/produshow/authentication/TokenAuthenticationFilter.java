package com.mc437.produshow.authentication;

import java.io.Console;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mc437.produshow.model.product.Role;
import com.mc437.produshow.model.product.User;
import com.mc437.produshow.service.UserService;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain fc)
			throws ServletException, IOException {
		SecurityContextHolder.getContext().setAuthentication(null);
		
		String authToken = req.getHeader("Authorization");
		
		if (authToken != null && authToken.isEmpty() == false) {
			User user = userService.fetchUserByToken(authToken);
			System.out.println("Token received " + authToken);
			if (user != null) {
				
				UserAuthentication userAuthentication = new UserAuthentication(user);
				
				System.out.println();
				System.out.println("######## User identified ###########");
				System.out.println("id " + user.getId());
				System.out.println("roles " + userAuthentication.getAuthorities());
				System.out.println();
				
				SecurityContextHolder.getContext().setAuthentication(userAuthentication);
			}
		}
		
		fc.doFilter(req, res);
	}
	
}

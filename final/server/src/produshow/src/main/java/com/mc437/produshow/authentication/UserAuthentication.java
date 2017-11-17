package com.mc437.produshow.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mc437.produshow.model.product.Role;
import com.mc437.produshow.model.product.User;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {

	private User user;
	
	public UserAuthentication(User user) {
		super("", "");
		
		this.user = user;
	}
	
	public static User GetCurrentUser () {
		return ((UserAuthentication) SecurityContextHolder.getContext().getAuthentication()).user;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
	
}

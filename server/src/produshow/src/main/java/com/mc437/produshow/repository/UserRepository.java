package com.mc437.produshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc437.produshow.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 User findOneByToken(String token);
	 User findOneByUsername(String username);
}

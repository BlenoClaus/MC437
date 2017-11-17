package com.mc437.produshow.service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.User;
import com.mc437.produshow.repository.UserRepository;

@Service
public class UserService {

	private static final String salt = "anystuff";
	
	@Autowired
	private UserRepository userRepository;
	
	public User fetchUserByToken (String token) {
		return userRepository.findOneByToken(token);
	}
	
	public void createUser (User user) throws GeneralException, NoSuchAlgorithmException {
		User userDb = userRepository.findOneByUsername(user.getUsername());
		if (userDb != null) {
			throw new GeneralException("DUPLICATED_USERNAME");
		}
			
		String hashPassword = getHash(user.getPassword());
		user.setPassword(hashPassword);
		
		userRepository.save(user);
	}
	
	public String getUserToken (User user) throws GeneralException {
		
		User userDb = userRepository.findOneByUsername(user.getUsername());
		if (userDb == null) {
			throw new GeneralException("INVALID_USER");
		}
		
		String hashPassword = getHash(user.getPassword());
		
		if (hashPassword.equals(userDb.getPassword()) == false) {
			throw new GeneralException("INVALID_USER");
		}
		
		if (userDb.getToken() == null || userDb.getToken().isEmpty()) {
			userDb.setToken(UUID.randomUUID().toString());
		}
		
		userRepository.save(userDb);
		return userDb.getToken();
	}
	
	private static String getHash (String original) {
		return DigestUtils.md5DigestAsHex(original.concat(salt).getBytes());
	}
	
	
}

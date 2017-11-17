package com.mc437.produshow.ws;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.product.User;
import com.mc437.produshow.model.validator.UserValidator;
import com.mc437.produshow.service.UserService;
import com.mc437.produshow.ws.body.Token;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@RequestMapping(value="register", method=RequestMethod.POST)
	public void registerUser (@Valid @RequestBody User user) throws NoSuchAlgorithmException, GeneralException {
		userService.createUser(user);
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Token login (@RequestBody User user) throws GeneralException {
		Token token = new Token();
		token.setToken(userService.getUserToken(user));
		return token;
	}
	
	@InitBinder("user")
	void initValidator(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
}

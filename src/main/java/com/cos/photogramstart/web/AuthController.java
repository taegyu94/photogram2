package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthService authService;
	
	@GetMapping("/auth/signin")
	public String signInForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signUpForm() {
		return "auth/signup";
	}
	
	@PostMapping("/auth/signup")
	public String signUp(SignupDto signupDto) {

		
		log.info(signupDto.toString());
		User user = signupDto.toEntity();
		log.info(user.toString());
		
		
		User userEntity = authService.회원가입(user);
		System.out.println(userEntity);
		
		return "auth/signin";
	}

}

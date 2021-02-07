package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	
	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "login-page";
	}
	@PostMapping("/homePage")
	public String showHomeLoginPage() {
		return "home-page";
	}
	@PostMapping("/logout")
	public String showHomeLogOutPage() {
		return "login-page";
	}
	@GetMapping("/access-handling-page")
	public String accessDeniedPage() {
		return "funy-access-denied-page";
	}
}

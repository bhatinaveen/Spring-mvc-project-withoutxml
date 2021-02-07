package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoClass {

	@GetMapping("/")
	public String showHome() {
	System.out.println("hell");
		return "home";
	}
	@GetMapping("/employee")
	public String showHomeEmployee() {
	System.out.println("hell");
		return "employee";
	}
	
}

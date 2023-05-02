package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	
	@GetMapping(value = "/")
	public @ResponseBody String getHomePage() {
		return "home page";
	}
	
	
	@GetMapping(value = "/welcome")
	public String getWelcomePage() {
		return "welcomePage";
	}
	
	@GetMapping(value = "/admin")
	public String getAdminPage() {
		return "adminPage";
	}
	
	@GetMapping(value = "/basic")
	public String getBasicPage() {
		return "basicPage";
	}
}

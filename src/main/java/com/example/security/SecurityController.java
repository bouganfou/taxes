package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/")
	public String home() {
		return "entreprises";
	}
	@RequestMapping("/403")
	public String acceessDenied() {
		return "403";
	}
}

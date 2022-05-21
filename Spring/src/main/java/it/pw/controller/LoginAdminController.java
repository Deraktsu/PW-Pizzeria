package it.pw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.model.Admin;

@Controller
@RequestMapping("/loginAdmin")
public class LoginAdminController {
	
	@GetMapping
	String getPage(Model model) {
		Admin admin;
		admin = new Admin();
		model.addAttribute("admin",admin);
		
		return "login-admin";
	}

}

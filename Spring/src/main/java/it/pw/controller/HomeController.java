package it.pw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/","/index","/home"})
public class HomeController {
	
	@GetMapping
	public String getPage(Model model) {
		
		
		
		return "home";
	}

}

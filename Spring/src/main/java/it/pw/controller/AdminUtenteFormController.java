package it.pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.service.UtenteService;

@Controller
@RequestMapping("/adminUtenti")
public class AdminUtenteFormController {

	@Autowired
	UtenteService utenteService;
	
	@GetMapping
	String getPage(Model model) {
		model.addAttribute("utenti",utenteService.leggiTutti());
		
		return "admin-utenti";
	}
	

	
	
	
}

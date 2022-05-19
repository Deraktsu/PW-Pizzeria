package it.pw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/infoProdotto")
public class InfoProdottoController {
	
	
	
	@GetMapping
	public String getPage(Model model) {
		
		
		return "info-prodotti";
	}
	
	


}

package it.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pw.model.Prodotto;
import it.pw.service.ProdottoService;

@Controller
@RequestMapping("/prodotti") 
public class ProdottiController {

	@Autowired
	private ProdottoService prodottoService;

	
	// http:localhost:8080/pizzeria/prodotti
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("prodotti",vediTutti());
		
		return "prodotti";
	}
	
	
	private List<Prodotto> vediTutti(){
		return prodottoService.vediTutti();
	}
	
	@GetMapping("/infoProdotto")
	private String getProdotti(Model model,@RequestParam("id") int id) {
		model.addAttribute("prodotto",getProdottoById(id));
		
		
		return "info-prodotti";
	}
	
	
}
	
	

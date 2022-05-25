package it.pw.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.pw.service.ProdottoService;

@Controller
@RequestMapping("/prodotti2") 
public class ProdottiController {

	@Autowired
	private ProdottoService prodottoService;

	
	// http:localhost:8080/pizzeria/prodotti
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("prodotti",prodottoService.vediTutti());
		
		return "index";
	}
	
	@GetMapping("/infoProdotto")
	public String getProdotti(Model model,@RequestParam("id") int id,HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String path2 = path + "static\\images\\"+String.valueOf(id)+".png";
		File file = new File(path2);
		
		model.addAttribute("prodotto",prodottoService.getProdottoById(id));
		model.addAttribute("immagine", file);
		return "info-prodotti";
	}
	
	
}
	
	

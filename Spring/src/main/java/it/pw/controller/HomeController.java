package it.pw.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pw.model.ProdottoNelCarrello;
import it.pw.service.ProdottoService;

@Controller
@RequestMapping("/home") 
public class HomeController {

	@Autowired
	private ProdottoService prodottoService;

	
	// http:localhost:8080/pizzeria/home
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model,HttpSession session) {
		if(session.getAttribute("prodottoAggiunto") == null) {
			session.setAttribute("prodottoAggiunto", false);
		}
		model.addAttribute("prodottoAggiunto",(boolean) session.getAttribute("prodottoAggiunto"));
		model.addAttribute("prodotti",prodottoService.vediTutti());
		
		
		if(session.getAttribute("listaCarrello") != null) {
		List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		model.addAttribute("listaCarrello",lpc);
		model.addAttribute("totale",prodottoService.calcolaPrezzo(lpc));
		model.addAttribute("lista",true);
		}else {
			model.addAttribute("lista",false);
		}
		
		return "home";
	}
	
	@GetMapping("/infoProdotto")
	public String getProdotti(Model model,@RequestParam("id") int id,HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String path2 = path + "static\\pizze\\"+String.valueOf(id)+".png";
		File file = new File(path2);
		
		model.addAttribute("prodotto",prodottoService.getProdottoById(id));
		model.addAttribute("immagine", file);
		return "info-prodotti";
	}
	
	
}
	
	

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
import it.pw.model.Utente;
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
		Utente u = (Utente) session.getAttribute("Utente");
		if(session.getAttribute("prodottoAggiunto") == null) {
			session.setAttribute("prodottoAggiunto", false);
		}
		
		try {
		if((boolean) session.getAttribute("logUtente")) {
            model.addAttribute("logUtente",true);
            model.addAttribute("utente",session.getAttribute("Utente"));
            
        }else {
            model.addAttribute("logUtente",false);
        }
		}catch (Exception e) {
			model.addAttribute("logUtente",false);
		}
			
		try {
			if((boolean) session.getAttribute("logAdmin")) {
	            model.addAttribute("logAdmin",true);
	            
	        }else {
	            model.addAttribute("logAdmin",false);
	        }
			}catch (Exception e) {
				model.addAttribute("logAdmin",false);
			}
		////
        if(session.getAttribute("listaCarrello") != null) {
        List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
        model.addAttribute("listaCarrello",lpc);
        model.addAttribute("totale",prodottoService.calcolaPrezzo(lpc));
        model.addAttribute("aggiunto",true);
        }else {
            model.addAttribute("aggiunto",false);
        }
		
        
        model.addAttribute("prodottoAggiunto",(boolean) session.getAttribute("prodottoAggiunto"));
        model.addAttribute("prodotti",prodottoService.vediTutti());
        //model.addAttribute("prodotti",prodottoService.vediTutti());
        //model.addAttribute("prodotti",prodottoService.vediTutti());
        

        
		
		
		
		
		return "home";
	}
	

        

    
	
	
	
	
	@GetMapping("/infoProdotto")
	public String getProdotti(Model model,@RequestParam("id") int id,HttpSession session) {
		try {
			if((boolean) session.getAttribute("logUtente")) {
	            model.addAttribute("logUtente",true);
	            model.addAttribute("utente",session.getAttribute("Utente"));
	            
	        }else {
	            model.addAttribute("logUtente",false);
	        }
			}catch (Exception e) {
				model.addAttribute("logUtente",false);
			}
		
		String path = session.getServletContext().getRealPath("/");
		String path2 = path + "static\\pizze\\"+String.valueOf(id)+".png";
		File file = new File(path2);
		
		model.addAttribute("prodotto",prodottoService.getProdottoById(id));
		model.addAttribute("immagine", file);
		
		
		return "info-prodotti";
	}
	
	@GetMapping("/doveSiamo")
	public String dovesiamo(Model model, HttpSession session) {
		
		try {
			if((boolean) session.getAttribute("logUtente")) {
	            model.addAttribute("logUtente",true);
	            model.addAttribute("utente",session.getAttribute("Utente"));
	            
	        }else {
	            model.addAttribute("logUtente",false);
	        }
			}catch (Exception e) {
				model.addAttribute("logUtente",false);
			}
	
		return "doveSiamo";
	}
	
	
}
	
	

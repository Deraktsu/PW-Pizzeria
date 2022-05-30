package it.pw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.model.Utente;
import it.pw.service.OrdiniService;
import it.pw.service.UtenteService;

@Controller
@RequestMapping("/areaClienti")
public class AreaClientiController {

	@Autowired
	UtenteService utenteService;
	
	@Autowired
	OrdiniService ordiniService;
	
	@GetMapping
	String getPage(HttpServletRequest request, HttpSession session, Model model) {
		
		if(session.getAttribute("logUtente") == null)
		session.setAttribute("logUtente", false);	
		if(session.getAttribute("logAdmin") == null)
			session.setAttribute("logAdmin", false);
		
		if(!(boolean) session.getAttribute("logUtente"))
			return "redirect:/registrazione/login";
		Utente utente = (Utente) session.getAttribute("Utente");
		model.addAttribute("ordini",ordiniService.getOrdineByUtente(utente));
		
		
		model.addAttribute("areaClientiForm",utente);	
		model.addAttribute("esitoUpdate",true);
		return "area-clienti";
	}
	
	@PostMapping
	public String updateUser(@Valid @ModelAttribute("areaClientiForm") Utente utente, BindingResult result,Model model,
			HttpServletRequest request, HttpSession session) {
		Utente oldUtente = (Utente) session.getAttribute("Utente");
		if (result.hasErrors()) 
			return "area-clienti";
			
		if(oldUtente.getEmail().equalsIgnoreCase(utente.getEmail())) {
			utente.setId_utente(oldUtente.getId_utente());
			utenteService.update(utente);
			session.setAttribute("Utente", utente);
		}else {
			if(!utenteService.verficaUsername(utente.getEmail())) {
				utente.setId_utente(oldUtente.getId_utente());
				utenteService.update(utente);
				session.setAttribute("Utente", utente);
			}else {
				model.addAttribute("esitoUpdate",false);
			}
			
		}
		
		return "redirect:/areaClienti";
			
	
	}
	
	
}

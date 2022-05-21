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
import it.pw.service.UtenteService;

@Controller
@RequestMapping("/areaClienti")
public class AreaClientiController {

	@Autowired
	UtenteService utenteService;
	
	@GetMapping
	String getPage(HttpServletRequest request, HttpSession session, Model model
		) {
		if(session.getAttribute("loggato") == null) {
			session.setAttribute("loggato", false);
		}
		
		model.addAttribute("areaClientiForm",session.getAttribute("Utente"));
		
		try {
			
		if(!(Boolean)session.getAttribute("loggato")){
			
			return "redirect:/registrazione/login";	
		}
		
		}catch (Exception e) {

			return "redirect:/registrazione/login";	
		}

		return "area-clienti";
	}
	
	@PostMapping
	public String updateUser(@Valid @ModelAttribute("areaClientiForm") Utente utente, BindingResult result,HttpServletRequest request, HttpSession session) {
		Utente u = (Utente) session.getAttribute("Utente");
		if (result.hasErrors()) {
			return "areaClienti";
		}else {

			utente.setId_utente(u.getId_utente());
			utenteService.update(utente);
			if(!utenteService.verficaUsername(utente.getUsername())){
			
				
			}else {
		
				return "redirect:/prodotti";
			}
		}
		
		return"redirect:/prodotti";
	}
	
	
}

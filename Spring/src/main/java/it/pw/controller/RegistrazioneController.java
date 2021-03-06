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
@RequestMapping("/registrazione")
public class RegistrazioneController {

	@Autowired
	UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model,
			HttpServletRequest request, HttpSession session) {
		boolean logUtente;
		boolean logAdmin;
		if(session.getAttribute("logUtente") == null)
		session.setAttribute("logUtente", false);	
		if(session.getAttribute("logAdmin") == null)
			session.setAttribute("logAdmin", false);
		logUtente = (boolean) session.getAttribute("logUtente");
		logAdmin = (boolean) session.getAttribute("logAdmin");
		if(logUtente || logAdmin)
			return "redirect:/home";
		
		Utente utente = new Utente();
		model.addAttribute("esitoRegistrazione",true);
		model.addAttribute("utente", utente);
		model.addAttribute("esito",true);
		return "registrazione";
	}
	
	@PostMapping
	public String registraUser(@Valid @ModelAttribute("utente") Utente utente, BindingResult result,Model model,
			HttpSession session) {
		
		if (result.hasErrors()) {
			return "registrazione";
		}else {
			
			  if(!utenteService.verficaUsername(utente.getEmail())){
				 
			   utenteService.create(utente);
				  
			  }else { 
				  model.addAttribute("signup",false);
				  return "registrazione"; }
			 
		}
		session.setAttribute("signup", true);
		
		return"redirect:/registrazione/login";
	}
	
	
	
	
	
	@GetMapping("/login")
	public String getPageLogin(@ModelAttribute("user") Utente utente, Model model,
			HttpServletRequest request, HttpSession session) {
		boolean logUtente;
		boolean logAdmin;
		if(session.getAttribute("logUtente") == null)
			session.setAttribute("logUtente", false);	
		if(session.getAttribute("logAdmin") == null)
			session.setAttribute("logAdmin", false);
		logUtente = (boolean) session.getAttribute("logUtente");
		logAdmin = (boolean) session.getAttribute("logAdmin");
		
		if(logUtente || logAdmin)
			return "redirect:/areaClienti";
		if(session.getAttribute("signup") == null) {
			session.setAttribute("signup",false);
		}
			
		
		model.addAttribute("registrazioneFatta",session.getAttribute("signup"));
		
		model.addAttribute("user", new Utente());
		model.addAttribute("esitoLogin", true);
		return "login";
		
	}
	
	@PostMapping("/login")
	public String comparaCredenziali(@ModelAttribute("user") Utente utente, Model model,
			HttpServletRequest request, HttpSession session) {	
			session.setAttribute("signup", false);
		if(utenteService.verificaLogin(utente.getEmail(), utente.getPassword())) {
			session.setAttribute("logUtente", true);
			session.setAttribute("Utente", utenteService.getUtenteByUsername(utente.getEmail()));
			
			
		}else {
			
			session.setAttribute("logUtente", false);
			model.addAttribute("esitoLogin",false);
			return "login";
		}
		
			
			
		return "redirect:/home";
		
	}
	
}

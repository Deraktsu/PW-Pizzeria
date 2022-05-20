package it.pw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
	public String getPage(Model model) {
		Utente utente;
		utente = new Utente();
		
		model.addAttribute("utente", utente);

		return "registrazione";
	}
	
	private boolean loggato = false;
	
	@PostMapping
	public String registraUser(@Valid @ModelAttribute("utente") Utente utente, BindingResult result) {
		
		if (result.hasErrors())
			return "registrazione";
		
		utenteService.create(utente);
		
		
		
		
		return"redirect:/login";
	}
	@GetMapping("/login")
	public String getPageLogin(@ModelAttribute("user") Utente utente, Model model) {
		model.addAttribute("user", new Utente());
		return "login";
	}
	
	@PostMapping("/login")
	public String comparaCredenziali(@ModelAttribute("user") Utente utente, Model model,
			HttpServletRequest request, HttpSession session) {	
		
		String esito;
		
		if(utenteService.verificaLogin(utente.getUsername(), utente.getPassword())) {
			System.out.println("SEI LOGGATO");
			esito = "Ti sei loggato correttamente";
			session.setAttribute("loggato", true);
			
		}else {
			System.out.println("ERRORE");
			esito = "Errore durante il login";
			session.setAttribute("loggato", false);
			return "redirect:/registrazione/login";
		}
		
		model.addAttribute("esito",esito);
		
	
		return "redirect:/areaClienti";
		
	}
	
}

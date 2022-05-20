package it.pw.controller;

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

import it.pw.model.User;
import it.pw.service.UserService;

@Controller
@RequestMapping("/registrazione")
public class RegistrazioneController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getPage(Model model) {
		User user;
		user = new User();
		
		model.addAttribute("user", user);

		return "registrazione";
	}
	
	@PostMapping
	public String registraUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if (result.hasErrors())
			return "registrazione";
		
		userService.create(user);
		
		
		
		
		return"redirect:/login";
	}
	
	@PostMapping("/login")
	public String comparaCredenziali(@ModelAttribute("user") User user, Model model) {
		String esito;
		boolean presente = userService.verificaLogin(user.getUsername(),user.getPassword());
		
		if(presente) {
			esito = "Ti sei loggato correttamente";
		}else {
			esito = "Errore durante il login";
		}
		model.addAttribute("esito",esito);
		
		return "redirect:/login";
	}
	
}

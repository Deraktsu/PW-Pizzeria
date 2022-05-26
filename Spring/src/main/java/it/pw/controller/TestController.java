package it.pw.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public String getPage(Model model,HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("logUtente") == null)
		session.setAttribute("logUtente", false);
		
		if(session.getAttribute("logAdmin") == null)
		session.setAttribute("logAdmin", false);
		
		Date data = new Date();
		model.addAttribute("data",data);
		
		return "test";
	}
	
	@PostMapping
	public String logout(Model model,HttpServletRequest request, HttpSession session) {
		session.removeAttribute("logUtente");
		session.removeAttribute("logAdmin");
		session.removeAttribute("listaCarrello");
		session.removeAttribute("Utente");
		return "test";
	}

}

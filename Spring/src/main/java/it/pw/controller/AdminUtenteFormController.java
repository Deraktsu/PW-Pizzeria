package it.pw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.dao.OrdiniDao;
import it.pw.dao.UtenteDao;
import it.pw.service.UtenteService;

@Controller
@RequestMapping("/adminUtenti")
public class AdminUtenteFormController {

	@Autowired
	UtenteDao utenteDao;
	
	@Autowired
	OrdiniDao ordinidao;
	
	@GetMapping
	String getPage(Model model) {
		model.addAttribute("utenti",utenteDao.leggiTutti());
		model.addAttribute("esitoRegistrazione",true);
		
		
		return "admin-utenti";
	}
	
	
	@GetMapping("/eliminaUtente")
	String eliminaUtente(HttpServletRequest request, HttpSession session, Model model) {
		int id = 0;		
		id= Integer.parseInt(request.getParameter("id"));
		
		if(ordinidao.confrontaDataUtente(utenteDao.getutenteById(id))) {
			model.addAttribute("esitoRegistrazione",false);
			model.addAttribute("utenti",utenteDao.leggiTutti());
			return "admin-utenti";
		}
		
		utenteDao.delete(utenteDao.getutenteById(id));
		
		
		return "redirect:/adminUtenti";
		
		
		
		
	}
	
	
	
}

package it.pw.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.dao.OrdiniDao;
import it.pw.model.Ordini;


	@Controller
	@RequestMapping("/adminOrdini")
	public class AdminOrdiniFormController {

	@Autowired
	OrdiniDao ordiniDao;
	
	@GetMapping
	String getPage(Model model) {
		model.addAttribute("utenti",ordiniDao.vediTutti());
		
		
		
		return "admin-utenti";
	}
	
	
	@GetMapping("/eliminaUtente")
	String eliminaUtente(HttpServletRequest request, HttpSession session, Model model) {
		int id = 0;		
		id= Integer.parseInt(request.getParameter("id"));
		Ordini ordine = ordiniDao.getOrdineById(id);
		Date dataordine = ordine.getDataOrdine();
		
		Date dataCorrente = new Date();
		if(dataordine.after(dataCorrente)) {
			return "redirect:/adminUtenti";
			
			}
        
		
		//ordiniDao.delete();
		
		
		return "redirect:/adminUtenti";
		
	}
	}
	


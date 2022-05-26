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
import org.springframework.web.bind.annotation.RequestParam;

import it.pw.dao.OrdiniDao;
import it.pw.model.Ordine;


	@Controller
	@RequestMapping("/adminOrdini")
	public class AdminOrdiniFormController {

	@Autowired
	OrdiniDao ordiniDao;
	
	@GetMapping
	String getPage(Model model) {
		model.addAttribute("ordini",ordiniDao.vediTutti());
		model.addAttribute("esitoRegistrazione",true);
		
		
		return "admin-ordini";
	}
	
	
	@GetMapping("/eliminaOrdine")
	String eliminaOrdine(@RequestParam("id")int id,Model model) {
		Ordine ordine = ordiniDao.getOrdineById(id);
		Date dataCorrente = new Date();
		if(ordine.getDataOrdine().after(dataCorrente)) {
			model.addAttribute("esitoRegistrazione",false);
			model.addAttribute("ordini",ordiniDao.vediTutti());
			return "redirect:/adminOrdini";
		}
		
			ordine.setUtente(null);
			ordiniDao.update(ordine);
			ordiniDao.delete(ordine);
		
		return "redirect:/adminOrdini";
		
	}
}
	
				


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
import org.springframework.web.bind.annotation.RequestParam;

import it.pw.dao.OrdiniDao;
import it.pw.dao.ProdottoDao;
import it.pw.model.Prodotto;
import it.pw.model.Utente;

	@Controller
	@RequestMapping("/adminProdotti")
	public class AdminProdottiFormController {

	@Autowired
	ProdottoDao prodottoDao;
	
	@Autowired
	OrdiniDao ordiniDao;
	
	@GetMapping
	String getPage(Model model) {
		model.addAttribute("prodotti",prodottoDao.vediTutti());
		
		
		
		return "admin-prodotti";
	}
	
	@GetMapping("/creaProdotto")
	String creaProdotto(Model model) {
		Prodotto prodotto= new Prodotto();
		model.addAttribute("aggiornaProdottoForm",prodotto);
		
		return "admin-prodotti-form";
	}
	
	@PostMapping("/creaProdotto")
	String creazioneProdotto(@Valid @ModelAttribute("aggiornaProdottoForm") Prodotto prodotto, BindingResult result,Model model) {
		if(result.hasErrors())
			return "/creaProdotto";
		
		prodottoDao.create(prodotto);
		
		return "redirect:/adminProdotti";
	}
	
	@GetMapping("/modificaProdotto")
	String modificaProdotto(HttpServletRequest request, HttpSession session, Model model) {
		
		int id = 0;		
		id= Integer.parseInt(request.getParameter("id"));
		model.addAttribute("aggiornaProdottoForm",prodottoDao.getProdottoById(id));
		session.setAttribute(null, model);
		
		return "admin-prodotti-form";
		
	}
	
	
	@PostMapping("/modificaProdotto")
	String modificaProdotto(@Valid @ModelAttribute("aggiornaProdottoForm") Prodotto prodotto, BindingResult result,Model model,
			HttpServletRequest request, HttpSession session) {
		
			prodottoDao.update(prodotto);
		
		return "redirect:/adminProdotti";
	}
	
	
	@GetMapping("/eliminaProdotto")
	String eliminaProdotto(@RequestParam("id")int id, HttpSession session, Model model) {	
		Prodotto prodotto = prodottoDao.getProdottoById(id);
		if(ordiniDao.confrontaDataProdotto(prodotto))
			return "redirect:/adminProdotti";
		
			prodottoDao.delete(prodotto);
			return "redirect:/adminProdotti";
		
		
		
		
	}
	
}

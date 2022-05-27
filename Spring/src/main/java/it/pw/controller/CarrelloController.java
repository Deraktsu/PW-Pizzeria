package it.pw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.pw.model.Ordine;
import it.pw.model.Prodotto;
import it.pw.model.ProdottoNelCarrello;
import it.pw.model.Utente;
import it.pw.service.OrdiniService;
import it.pw.service.ProdottoService;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	ProdottoService prodottoService;

	@Autowired
	OrdiniService ordiniService;

	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model,HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("listaCarrello") == null) {
			  List<ProdottoNelCarrello> lpc = new ArrayList<>();
			session.setAttribute("listaCarrello",lpc);
		  }
	List<ProdottoNelCarrello> lpc =(List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		
	model.addAttribute("listaCarello",lpc);
	model.addAttribute("totale",prodottoService.calcolaPrezzo(lpc));
	model.addAttribute("loggato", session.getAttribute("loggato"));
	model.addAttribute("nomeUtente",session.getAttribute("Utente"));
	
	if(lpc.isEmpty()) {
		model.addAttribute("carrelloVuoto",true);
	}else {
		model.addAttribute("carrelloVuoto",false);
	}
	return "carrello";
	}

	  @SuppressWarnings("unchecked")
	@GetMapping("/prodottoInOrdine")
	  public String aggiungiProdotto(HttpServletRequest request, HttpSession session)
	  {		
		  boolean logUtente;
			boolean logAdmin;
			if(session.getAttribute("logUtente") == null)
			session.setAttribute("logUtente", false);	
			if(session.getAttribute("logAdmin") == null)
				session.setAttribute("logAdmin", false);
			logUtente = (boolean) session.getAttribute("logUtente");
			logAdmin = (boolean) session.getAttribute("logAdmin");

			 
			if(!logUtente || logAdmin)
				
				return "redirect:/registrazione/login";
				
		  
		  if(session.getAttribute("listaCarrello") == null) {
			  List<ProdottoNelCarrello> lpc = new ArrayList<>();
			session.setAttribute("listaCarrello",lpc);
		  }
		  
		  int id = 0;
		  id = Integer.parseInt(request.getParameter("id"));
		  
		  List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		  
		  if(!prodottoService.confrontaProdotti(id,lpc)) {
			  
			  if(prodottoService.getProdottoById(id) !=null) {
			  
				  ProdottoNelCarrello c = new ProdottoNelCarrello();
				  c.setId_prodotto(id);
				  c.setQuantita(1);
				  c.setNome(prodottoService.getProdottoById(id).getNome());
				  c.setPrezzo(prodottoService.getProdottoById(id).getPrezzo());
				  lpc.add(c);
				  session.setAttribute("listaCarrello", lpc);
			  }
			  
		  }else {
			  int index = prodottoService.trovaIndex(lpc, id);
			  lpc.get(index).setQuantita(lpc.get(index).getQuantita()+1);
			  
		  }
		 
			  return "redirect:/home#menu";   
		  }

	  
	  
	  
	  @SuppressWarnings({"unchecked"})
	  @GetMapping("/eliminaDalCarrello")
	  public String eliminaDalCarrello(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session) {
		  
		List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		  
		lpc.remove(prodottoService.trovaIndex(lpc,id));
		 
		 session.setAttribute("listaCarrello", lpc);
		 
		  return "redirect:/carrello";
	  }
	  
	  @SuppressWarnings({"unchecked"})
	  @GetMapping("/aumentaQuantita")
	  public String aumentaQuantita(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session) {
		  
		List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		int index = prodottoService.trovaIndex(lpc, id);
		lpc.get(index).setQuantita(lpc.get(index).getQuantita()+1);
		  
		  return "redirect:/carrello";
	  }
	  
	  
	@SuppressWarnings("unchecked")
	@GetMapping("/diminuisciQuantita")
	  public String diminuisciQuantita(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session){
			
		   List<ProdottoNelCarrello> lpc = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		  
		  	int index = prodottoService.trovaIndex(lpc, id);
		  	 if(lpc.get(index).getQuantita() > 1) {
		  		 lpc.get(index).setQuantita(lpc.get(index).getQuantita()-1);
		  
			  }
		  		//mettere alert
				  
				  return "redirect:/carrello";
			  }
	  
	  
	@SuppressWarnings("unchecked")
	@GetMapping("/acquisto")
	String getPageAcquisto(HttpServletRequest request, HttpSession session) {
		boolean logUtente;
		List<ProdottoNelCarrello>lista;
		lista = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		if(session.getAttribute("logUtente") == null)
		session.setAttribute("logUtente", false);	
		if(session.getAttribute("logAdmin") == null)
			session.setAttribute("logAdmin", false);
		logUtente = (boolean) session.getAttribute("logUtente");
		if(!logUtente || lista==null)
			return "redirect:/home";
		
	
		return "form-paypal";
	}
	// http://localhost:8080/pizzeria/carrello/riepilogo
	
		@GetMapping("/riepilogo")
		String concludiPagamento(@RequestParam("data")Date data_ritiro,@RequestParam("orario")String orario_ritiro,Model model, HttpServletRequest request, HttpSession session) {
			Ordine ordine = new Ordine();
			Utente utente = (Utente) session.getAttribute("Utente");
			
			int quantita = 0;
			
			@SuppressWarnings("unchecked")
			List<ProdottoNelCarrello> lista = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
			List<Prodotto> listaAcquisto = new ArrayList<>();
			
			
			for(ProdottoNelCarrello p : lista) {
				quantita = p.getQuantita();
				
				for(int i = 0;i < quantita;i++ ) {
					listaAcquisto.add(prodottoService.getProdottoById(p.getId_prodotto()));
				}
				
			}
			model.addAttribute("listaRiepilogo", listaAcquisto);
			model.addAttribute("dataRiepilogo", data_ritiro);
			model.addAttribute("orarioRiepilogo", orario_ritiro);
			model.addAttribute("totaleRiepilogo",prodottoService.calcolaPrezzo(lista));
			
				ordine.setDataOrdine(data_ritiro);
				ordine.setOrarioRitiro(orario_ritiro);
				ordine.setPrezzoTotale(prodottoService.calcolaPrezzo(lista));
				ordine.setUtente(utente);
				ordine.setProdotti(listaAcquisto);
				ordiniService.create(ordine);
				session.removeAttribute("listaCarrello");
			
			return "riepilogo";
		}
	  
	  
}

package it.pw.controller;

import java.util.ArrayList;
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

import it.pw.model.ProdottoNelCarrello;
import it.pw.service.ProdottoService;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	ProdottoService prodottoService;

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
		 
			  return "redirect:/carrello";   
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
		  	lpc.get(index).setQuantita(lpc.get(index).getQuantita()-1);
		  
			  if(lpc.get(index).getQuantita() <= 0) {
				  lpc.remove(index);
				  
			  }
		  		
				  
				  return "redirect:/carrello";
			  }
	  
	  
	@SuppressWarnings("unchecked")
	@GetMapping("/acquisto")
	String getPageAcquisto(HttpServletRequest request, HttpSession session) {
		boolean logUtente;
		boolean logAdmin;
		List<ProdottoNelCarrello>lista;
		lista = (List<ProdottoNelCarrello>) session.getAttribute("listaCarrello");
		if(session.getAttribute("logUtente") == null)
		session.setAttribute("logUtente", false);	
		if(session.getAttribute("logAdmin") == null)
			session.setAttribute("logAdmin", false);
		logUtente = (boolean) session.getAttribute("logUtente");
		logAdmin = (boolean) session.getAttribute("logAdmin");
		if(!logUtente || lista==null)
			return "redirect:/prodotti";
		
	
		return "form-paypal";
	}
	
		@PostMapping
		String concludiPagamento(HttpServletRequest request, HttpSession session) {
			
			Date orario_ritiro = new Date();
			Date data_ritiro = new Date();
			
			orario_ritiro.setHours(16);
			orario_ritiro.setMinutes(30);
			orario_ritiro.setSeconds(16);
			
			
			data_ritiro.setDate(23);
			
			
			
			
			
			return "/riepilogo";
		}
	  
	  
}

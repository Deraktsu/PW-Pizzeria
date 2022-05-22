package it.pw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pw.model.Carrello;
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
			  List<Carrello> lcs = new ArrayList<>();
			session.setAttribute("listaCarrello",lcs);
		  }
		model.addAttribute("listaCarello",(List<Carrello>) session.getAttribute("listaCarrello"));
	
	model.addAttribute("totale",prodottoService.calcolaPrezzo((List<Carrello>) session.getAttribute("listaCarrello")));
	model.addAttribute("loggato", session.getAttribute("loggato"));
	return "carrello";
	}

	  @SuppressWarnings("unchecked")
	@GetMapping("/prodottoInOrdine")
	  public String aggiungiProdotto(HttpServletRequest request, HttpSession session)
	  {		
		  
		  if(session.getAttribute("listaCarrello") == null) {
			  List<Carrello> lcs = new ArrayList<>();
			session.setAttribute("listaCarrello",lcs);
		  }
		  
		  
		  int id = 0;
		  id = Integer.parseInt(request.getParameter("id"));
		  
		  List<Carrello> lc;
			
		  	lc = (List<Carrello>) session.getAttribute("listaCarrello");
		  
		  
		  if(!prodottoService.confrontaProdotti(id,lc)) {
			  
			  if(prodottoService.getProdottoById(id) !=null) {
			  
				  Carrello c = new Carrello();
				  c.setId_prodotto(id);
				  c.setQuantita(1);
				  c.setNome(prodottoService.getProdottoById(id).getNome());
				  c.setPrezzo(prodottoService.getProdottoById(id).getPrezzo());
				  lc.add(c);
				  session.setAttribute("listaCarrello", lc);
			  }
			  
		  }else {
			  int index = prodottoService.trovaIndex(lc, id);
			  lc.get(index).setQuantita(lc.get(index).getQuantita()+1);
			  
			
		  }
		 
			  return "redirect:/carrello";   
		  }

	  
	  
	  
	  @SuppressWarnings({ "unchecked"})
	  @GetMapping("/eliminaDalCarrello")
	  public String eliminaDalCarrello(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session) {
		  
		List<Carrello>lcs = (List<Carrello>) session.getAttribute("listaCarrello");
		  
		 lcs.remove(prodottoService.trovaIndex(lcs,id));
		 
		 session.setAttribute("listaCarrello", lcs);
		 
		  return "redirect:/carrello";
	  }
	  
	  
	  @GetMapping("/aumentaQuantita")
	  public String aumentaQuantita(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session) {
		  
		  @SuppressWarnings("unchecked")
		List<Carrello>lcs = (List<Carrello>) session.getAttribute("listaCarrello");
		  int index = prodottoService.trovaIndex(lcs, id);
		  lcs.get(index).setQuantita(lcs.get(index).getQuantita()+1);
		  
		  
		  return "redirect:/carrello";
	  }
	  
	
	  @SuppressWarnings("unchecked")
	@GetMapping("/diminuisciQuantita")
	  public String diminuisciQuantita(
			  @RequestParam("id")int id,HttpServletRequest request, HttpSession session){
				  
		  List<Carrello> lcs;
		  	lcs = (List<Carrello>) session.getAttribute("listaCarrello");
		  
		  	int index = prodottoService.trovaIndex(lcs, id);
			  lcs.get(index).setQuantita(lcs.get(index).getQuantita()-1);
		  
			  if(lcs.get(index).getQuantita() < 1) {
				  lcs.remove(index);
				  
			  }
		  		
				  
				  return "redirect:/carrello";
			  }
	  
	  
	  
	  
}

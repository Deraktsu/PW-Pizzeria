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

	@GetMapping
	public String getPage(Model model) {
	model.addAttribute("listaCarello",listaCarrello);
	model.addAttribute("totale",prodottoService.calcolaPrezzo(listaCarrello));
	return "carrello";
	}


 private List<Carrello> listaCarrello = new ArrayList<>();
 		
	  @GetMapping("/prodottoInOrdine")
	  public String aggiungiProdotto(HttpServletRequest request, HttpSession session)
	  {		
		  int id = 0;
		  id = Integer.parseInt(request.getParameter("id"));
		  if(prodottoService.getProdottoById(id) !=null) {
			  if(session.getAttribute("id") == null) {
				  session.setAttribute("id", id);
				  Carrello c = new Carrello();
				  c.setId_prodotto(id);
				  c.setQuantita(1);
				  c.setNome(prodottoService.getProdottoById(id).getNome());
				  c.setPrezzo(prodottoService.getProdottoById(id).getPrezzo());
				  listaCarrello.add(c);
				  //listaOrdine.add(prodottoService.getProdottoById(id));
			  }else {
				  session.setAttribute("id", id);
				  Carrello c = new Carrello();
				  c.setId_prodotto(id);
				  c.setQuantita(1);
				  c.setNome(prodottoService.getProdottoById(id).getNome());
				  c.setPrezzo(prodottoService.getProdottoById(id).getPrezzo());
				  listaCarrello.add(c);
				  //listaOrdine.add(prodottoService.getProdottoById(id));
			  }
		  }

	  return "redirect:/carrello"; 
	  }
	  
	  @GetMapping("/eliminaDalCarrello")
	  public String eliminaProdotto(
			  @RequestParam("indice")int indice) {
		  
		  
		 listaCarrello.remove(indice);

		  return "redirect:/carrello";
	  }
	  
	  
	
}

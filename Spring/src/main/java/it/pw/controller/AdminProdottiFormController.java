package it.pw.controller;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public String getPage(Model model,HttpSession session) {
		model.addAttribute("prodotti",prodottoDao.vediTutti());
		model.addAttribute("esitoRegistrazione",true);
		try {
			if(!(boolean) session.getAttribute("logAdmin")){
				return"redirect:/login-admin";
			}
			}catch (Exception e) {
				return "redirect:/loginAdmin";
			}
		
		return "admin-prodotti";
	}
	
	@GetMapping("/creaProdotto")
	public String creaProdotto(Model model,HttpSession session) {
		try {
			if(!(boolean) session.getAttribute("logAdmin")){
				return"redirect:/login-admin";
			}
			}catch (Exception e) {
				return "redirect:/loginAdmin";
			}
		
		Prodotto prodotto= new Prodotto();
		model.addAttribute("aggiornaProdottoForm",prodotto);
		
		return "admin-prodotti-form";
	}
	
	@PostMapping("/creaProdotto")
	public String creazioneProdotto(@Valid @ModelAttribute("aggiornaProdottoForm") Prodotto prodotto, BindingResult result,Model model) {
		if(result.hasErrors())
			return "admin-prodotti-form";
		
		prodottoDao.create(prodotto);
		
		return "redirect:/adminProdotti";
	}
	
	  @GetMapping("/modificaProdotto") 
	  public String modificaProdotto(HttpServletRequest
	  request, HttpSession session, Model model) {
		  try {
				if(!(boolean) session.getAttribute("logAdmin")){
					return"redirect:/loginAdmin";
				}
				}catch (Exception e) {
					return "redirect:/loginAdmin";
				}
			
			int id = 0;		
			id= Integer.parseInt(request.getParameter("id"));
			
			boolean hasImage = false;
			
			try 
			{
				String rootDir = session.getServletContext().getRealPath("/");
				String filePath = rootDir + "static\\pizze\\" + String.valueOf(id) + ".png";
				File file = new File(filePath);
				hasImage = file.exists();
			} 
			catch (Exception e) 
			{
				hasImage = false;
			}
			
			
			model.addAttribute("aggiornaProdottoForm",prodottoDao.getProdottoById(id));
			session.setAttribute("prodottoId", prodottoDao.getProdottoById(id));
			model.addAttribute("hasImage", hasImage);
			model.addAttribute("prodottoId", String.valueOf(id));
			return "admin-prodotti-form";
			
		}
	  
	  
	  @PostMapping("/modificaProdotto")
	 public String modificaProdotto(@Valid @ModelAttribute("aggiornaProdottoForm") Prodotto
	  newprodotto, BindingResult result,Model model, HttpServletRequest request,
	  HttpSession session) { Prodotto oldProdotto = (Prodotto)
	  session.getAttribute("prodottoId");
	  newprodotto.setId_prodotto(oldProdotto.getId_prodotto());
	  
	  
	  
	  
	  prodottoDao.update(newprodotto);
	  
	  return "redirect:/adminProdotti"; }
	  
	  
	  @PostMapping("/upload")
	  public String imageUpload(@RequestParam("image") MultipartFile image,
			  					@RequestParam("fileName") String fileName, HttpSession session) {
	  
	  
		  if (image != null && !image.isEmpty())
			{
				String rootDir = session.getServletContext().getRealPath("/");
				String filePath = rootDir + "static\\pizze\\" + fileName + ".png";
				try 
				{
					image.transferTo(new File(filePath));
				} 
				catch (IllegalStateException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			return "redirect:/adminProdotti/modificaProdotto?id=" + Integer.parseInt(fileName);
		}
	 
	
	@GetMapping("/eliminaProdotto")
	public String eliminaProdotto(@RequestParam("id")int id, HttpSession session, Model model) {	
		try {
			if(!(boolean) session.getAttribute("logAdmin")){
				return"redirect:/login-admin";
			}
			}catch (Exception e) {
				return "redirect:/loginAdmin";
			}
		
		Prodotto prodotto = prodottoDao.getProdottoById(id);
		if(ordiniDao.confrontaDataProdotto(prodotto)) {
			model.addAttribute("esitoRegistrazione",false);
			model.addAttribute("prodotti",prodottoDao.vediTutti());
			return "admin-prodotti";
		}
		
			prodottoDao.delete(prodotto);
			return "redirect:/adminProdotti";
		
		
		
		
	}
	
	@GetMapping("/cancellaImmagine")
	String cancellaImmagine(@RequestParam("name")String name,HttpServletRequest request,HttpSession session) {
		try {
			if(!(boolean) session.getAttribute("logAdmin")){
				return"redirect:/login-admin";
			}
			}catch (Exception e) {
				return "redirect:/loginAdmin";
			}
		
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\pizze\\" + name + ".png";
		File file = new File(filePath);
		if (file.exists()) file.delete();
		
		
		return "redirect:/adminProdotti/modificaProdotto?id=" + Integer.parseInt(name);
	}
	
	
	
}

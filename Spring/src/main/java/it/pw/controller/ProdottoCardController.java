package it.pw.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import it.pw.dao.ProdottoDao;

@Controller
@RequestMapping("/modificaProdotto")
public class ProdottoCardController {
	
	@Autowired
	ProdottoDao prodottoDao;
	
	@GetMapping
	String modificaProdotto(HttpServletRequest request, HttpSession session, Model model) {
		try {
			if(!(boolean) session.getAttribute("logAdmin")){
				return"redirect:/login-admin";
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
	
	
	
	@PostMapping("/upload")
	public String imageUpload(@RequestParam("image") MultipartFile image,@RequestParam("fileName") String fileName, HttpSession session)
	{
		
		
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
		return "redirect:/modificaProdotto?id=" + Integer.parseInt(fileName);
	}
	
	@GetMapping("/cancellaImmagine")
	
	
	public String cancellaImmagine(@RequestParam("name") String name,HttpServletRequest request,HttpSession session) {
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
		
		
		return "redirect:/modificaProdotto?id=" + Integer.parseInt(name);
	}
	
	
}

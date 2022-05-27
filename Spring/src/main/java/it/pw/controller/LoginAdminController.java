package it.pw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pw.model.Admin;
import it.pw.service.AdminService;

@Controller
@RequestMapping("/loginAdmin")
public class LoginAdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping
	public String getPage(Model model,
		HttpServletRequest request, HttpSession session) {
		model.addAttribute("admin", new Admin());
		model.addAttribute("esitoLoginAdmin",true);
		
		if(session.getAttribute("logAdmin") == null) {
		session.setAttribute("logAdmin", false);
		}
		
		return "login-admin";
	}
	
	@PostMapping
	public String comparaCredenzialiAdmin(@ModelAttribute("admin") Admin admin, Model model,
			HttpServletRequest request, HttpSession session) {	
		
		if(adminService.verificaLoginAdmin(admin.getUsername(), admin.getPassword())) {
			
			session.setAttribute("logAdmin", true);
			model.addAttribute("esitoLoginAdmin",true);
			session.setAttribute("Admin", adminService.getAdminByUsername(admin.getUsername()));
			
			
		}else {
			
			session.setAttribute("logAdmin", false);
			model.addAttribute("esitoLoginAdmin",false);
			return "login-admin";
		}
		
		
		
		return "login-admin";
		
	}
	

}

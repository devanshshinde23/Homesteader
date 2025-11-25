package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Admin;
import com.example.demo.Service.AdminService;

@Controller
public class HomeController {

	@Autowired
	AdminService as;
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/adminLogin")
	public String AdminLogin(){
		return "adminLogin";
	}
	@GetMapping("/adminRegister")
	public String AdminRegister() {
		return "adminRegister";
	}
	
	@PostMapping("/saveAdmin")
	public String AdminInfo(@ModelAttribute Admin a1) {
		
		as.Register(a1);
		return"redirect:/adminLogin";
	}
	
	@PostMapping("/checkAdminData")
	public String CheckAdminData(@RequestParam("username") String u, @RequestParam("password") String p,HttpSession s1)
	{
		Admin ad=as.checkAdminData(u,p);
		if(ad!=null) {
			s1.setAttribute("temp", ad.getAusername());
			return "redirect:/AdminDash";
		}
		return "adminLogin";
		
	}
	
	@GetMapping("/AdminDash")
	public String AdminDash(HttpSession s1 )
	{
		if(s1.getAttribute("temp")!=null) {
			return "AdminDash";
		}
		return "redirect:/adminLogin";
	}
	
	@GetMapping("/FLogout")
	public String flogout(HttpSession s1 ) {
		s1.invalidate();
		return "redirect:/adminLogin";
	}
	
}

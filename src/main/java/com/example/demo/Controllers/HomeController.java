package com.example.demo.Controllers;

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
	public String CheckAdminData(@RequestParam("username") String u, @RequestParam("password") String p)
	{
		Admin ad=as.checkAdminData(u,p);
		if(ad!=null) {
			return "redirect:/AdminDash";
		}
		return "adminLogin";
		
	}
	
	@GetMapping("/AdminDash")
	public String AdminDash()
	{
		return "AdminDash";
	}
	
}

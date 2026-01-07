package com.example.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Farmer;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.AgenciesService;
import com.example.demo.Service.FarmerService;

@Controller

public class HomeController {

	@Autowired
	AdminService as;
	
	@Autowired
	FarmerService fs;
	
	@Autowired 
	AgenciesService ags;
	
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
	public String AdminDash(HttpSession s1 , Model m)
	{
		if(s1.getAttribute("temp")==null) {
			
			
			return "redirect:/adminLogin";
		}
		
//		long agencyCount = ags.countAgencies(); // returns count from DB 
		m.addAttribute("agencyCount", ags.countAgencies()); 
		
		return "AdminDash";
		
		
	}
	
	@GetMapping("/FLogout")
	public String flogout(HttpSession s1 ) {
		s1.invalidate();
		return "redirect:/adminLogin";
	}
	
	@GetMapping("/SearchByVillage")
	public String findbyVillage(@RequestParam ("fregion") String name , Model m){
		
//		System.out.println(name);
		List<Farmer> farmer = fs.fetchData(name);
		m.addAttribute("farmers",farmer);
		m.addAttribute("showFarmers",true);
		return "AdminDash";
	}
	
	@GetMapping("/SearchByFarmerName")
	public String findbyname(@RequestParam ("fname") String fname , Model m) {
		
		List<Farmer> farmerName = fs.findByFname(fname);
		m.addAttribute("farmers" , farmerName);
		m.addAttribute("showFarmers", true);
		return"AdminDash";
	}
	
	@GetMapping("/FarmerDetails/{id}")
	public String farmerDetails(@PathVariable int id, Model m ) {
		Farmer farmer =  fs.getFarmerDetails(id);
		m.addAttribute("fd",farmer);
		
		return "FarmerDetails";
	}
	
	
	
}

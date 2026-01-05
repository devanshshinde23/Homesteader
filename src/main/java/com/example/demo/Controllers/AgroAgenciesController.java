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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Agencies;
import com.example.demo.Service.AgenciesService;

@Controller
public class AgroAgenciesController {

	@Autowired 
	AgenciesService as;
	
	
	@GetMapping("/AgenciesRegistration")
	public String Areg() {
		return "AgenciesRegistration";
	}
	
	@PostMapping("/saveAgency")
	public String SaveAgencies(@ModelAttribute Agencies a1)
	{
	
		as.saveAgency(a1);
		return "redirect:/AgenciesLogin";
	}
	
	@GetMapping("/AgenciesLogin")
	public String AgencyLogin() 
	{
		
		return "AgenciesLogin";
	}
	
	@PostMapping("/checkAgencyData")
	public String checkAgency(@RequestParam("username") String u, @RequestParam("password") String p,HttpSession s1) 
	{
		Agencies ar=as.checkAgency(u,p);
		if(ar!=null) {
			s1.setAttribute("temp", ar.getAusername());
		return "redirect:/AgencyDash";
		}
		return "redirect:/AgenciesLogin";
	}
	
	@GetMapping("/AgencyDash")
	public String agencydash(HttpSession s1 , Model m ) {
		
		
		if(s1.getAttribute("temp")!=null) {
			String x =(String)s1.getAttribute("temp");
			
			m.addAttribute("xx",x);
			
			return "AgencyDash";
			
			
		}
		return "AgenciesLogin";
	}
	
	@GetMapping("/Alogout")
	public String logout(HttpSession s1) {
		s1.invalidate();
		return "redirect:/AgenciesLogin";
	}
	
	
	@GetMapping("/AgencyData/{aname}")
	public String AgencyData(@PathVariable String aname,HttpSession s1 , Model m) {
		as.fetchSingleRecord(aname);
		String ag =(String ) s1.getAttribute("temp");
		m.addAttribute("user", ag);
		return "AgencyData";
	}
	
	// Toggal Logic 
	@GetMapping("/ViewAgroAgencies")
	public String ViewAgencyData(HttpSession Session ,Model m) {
		
		Boolean showAgency =(Boolean) Session.getAttribute("showAgency");
		
		if(showAgency == null || showAgency == false) {
			showAgency = true;
			
			m.addAttribute("agency", as.ADisplay());
		}
		m.addAttribute("showAgency", true); 
		m.addAttribute("showFarmers", false);
		m.addAttribute("agencyCount", as.countAgencies());
		return("AdminDash");
	}
	
}

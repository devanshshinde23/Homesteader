package com.example.demo.Controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Agencies;
import com.example.demo.Service.AgenciesService;

@Controller
public class AgroAgenciesController {

	@Autowired 
	AgenciesService as;
	@GetMapping("/ViewAgroAgencies")
	public String ViewAgro() {
		return "ViewAgroAgencies";
	}
	
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
	public String agencydash(HttpSession s1 ) {
		if(s1.getAttribute("temp")!=null) {
			return "AgencyDash";
		}
		return "AgenciesLogin";
	}
	
	@GetMapping("/Alogout")
	public String logout(HttpSession s1) {
		s1.invalidate();
		return "redirect:/AgenciesLogin";
	}
	
	
}

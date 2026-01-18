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
import com.example.demo.Model.Farmer;
import com.example.demo.Service.AgenciesService;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.ServiceRequestService;

@Controller
public class AgroAgenciesController {

	@Autowired 
	AgenciesService as;
	
	@Autowired 
	FarmerService ffs;
	
	@Autowired 
	ServiceRequestService service;
	
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
			s1.setAttribute("agencyId", ar.getAid());
			s1.setAttribute("temp", ar.getUsername());
		return "redirect:/AgencyDash";
		}
		return "redirect:/AgenciesLogin";
	}
	
//	@GetMapping("/AgencyDash")
//	public String agencydash(HttpSession s1 , Model m ) {
//		
//		
//		if(s1.getAttribute("temp")!=null) {
//			String x =(String)s1.getAttribute("temp");
//			
//			m.addAttribute("xx",x);
//			
//			return "AgencyDash";
//			
//			
//		}
//		return "AgenciesLogin";
//	}
	
//	@GetMapping("/AgencyDash")
//	 public String agencydash(HttpSession s1 , Model m ) 
//	{
//	 	if(s1.getAttribute("temp")!=null) 
//		{
//	 	String username =(String)s1.getAttribute("temp"); 
//		m.addAttribute("xx", username); 
//		Agencies agency = as.fetchSingleRecord(username); 
//		Long agencyId = agency.getAid(); //  
//		m.addAttribute("requests", service.getAgencyRequests(agencyId)); 
//		return "AgencyDash";
//		 } return "AgenciesLogin"; 
//		 
//	}
	
	@GetMapping("/AgencyDash")
	public String agencydash(HttpSession s1, Model m) {
	    Long agencyId = (Long) s1.getAttribute("agencyId"); // ✅ get agencyId
	    if (agencyId != null) {
	        m.addAttribute("requests", service.getAgencyRequests(agencyId));
	        m.addAttribute("agency", as.findById(agencyId)); // optional, for profile info
	        return "AgencyDash";
	    }
	    return "AgenciesLogin"; // fallback if not logged in
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
	
	@GetMapping("/AgencyViewfarmer")
	public String viewFarmer(HttpSession session, Model model) {

	    Boolean showFarmers = (Boolean) session.getAttribute("showFarmers");

	    // toggle logic
	    if (showFarmers == null || showFarmers == false) {
	        showFarmers = true;
	        model.addAttribute("farmers", ffs.Display()); // load data only when showing
	    } 
	    model.addAttribute("showFarmers", true); 
	    

	    return "AgencyDash";
	}
	
	@GetMapping("/SearchVillage")
	public String findbyVillage(@RequestParam ("fregion") String name , Model m){
		
//		System.out.println(name);
		List<Farmer> farmer = ffs.fetchData(name);
		m.addAttribute("farmers",farmer);
		m.addAttribute("showFarmers",true);
		return "AgencyDash";
	}
	
	@GetMapping("/SearchFarmerName")
	public String findbyname(@RequestParam ("fname") String frname ,Model m) {
		List<Farmer> farmerName = ffs.findByname(frname);
		m.addAttribute("farmers", farmerName);
		m.addAttribute("showFarmers", true);
		
		return "AgencyDash";
	}
	
	
}

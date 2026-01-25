package com.example.demo.Controllers;


import java.time.LocalDate;
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
import com.example.demo.Model.Crop;
import com.example.demo.Model.Farmer;
import com.example.demo.Model.Fertilizer;
import com.example.demo.Model.ServiceRequest;
import com.example.demo.Repo.CropRepo;
import com.example.demo.Repo.FertilizerRepo;
import com.example.demo.Repo.HerbRepo;
import com.example.demo.Repo.SeedRepo;
import com.example.demo.Service.AgenciesService;
import com.example.demo.Service.CropService;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.FertilizerService;
import com.example.demo.Service.HerbService;
import com.example.demo.Service.SeedService;
import com.example.demo.Service.ServiceRequestService;

@Controller
public class AgroAgenciesController {

	@Autowired 
	AgenciesService as;
	
	@Autowired 
	FarmerService ffs;
	
	@Autowired 
	ServiceRequestService service;
	
	@Autowired 
	CropService cs;
	
	@Autowired 
	FertilizerService FS;
	
	@Autowired 
	FertilizerRepo Fr;
	
	@Autowired
	SeedRepo SR;
	
	@Autowired 
	HerbRepo Hr;
	
	@Autowired 
	HerbService HS;
	
	@Autowired 
	SeedService sc;
	
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
	

	
	@GetMapping("/AgencyDash")
	public String agencydash(HttpSession s1, Model m) {
	    Long agencyId = (Long) s1.getAttribute("agencyId");
	    if (agencyId != null) {
	        // always load requests and counts
	        m.addAttribute("requests", service.getAgencyRequests(agencyId));
	        m.addAttribute("agency", as.findById(agencyId));
	        m.addAttribute("totalRequests", service.countAllByAgency(agencyId));
	        m.addAttribute("approvedRequests", service.countByStatus(agencyId, "Approved"));
	        m.addAttribute("pendingRequests", service.countByStatus(agencyId, "Pending"));
	        
	        m.addAttribute("crops", cs.getAllCrops()); 
	        m.addAttribute("fertilizers", FS.getAllFertilizers()); 
	        m.addAttribute("seeds", sc.getAllSeeds());
	        m.addAttribute("herbs", HS.getAllHerbs());

	        
//	        m.addAttribute("requests", service.getAgencyRequests(agencyId));
	        // farmer toggle
	        Boolean showFarmers = (Boolean) s1.getAttribute("showFarmers");
	        if (showFarmers != null && showFarmers) {
	            m.addAttribute("farmers", ffs.Display());
	            m.addAttribute("showFarmers", true);
	        } else {
	            m.addAttribute("showFarmers", false);
	        }
	        
	     // Service requests table 
	        Boolean showRequests = (Boolean) s1.getAttribute("showRequests"); 
	        if (showRequests != null && showRequests)
	        {
	        		m.addAttribute("requests", service.getAgencyRequests(agencyId));
	        		m.addAttribute("showRequests", true); 
	        	} else 
	        	{ 
	        		m.addAttribute("showRequests", false); 
	        	}

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
	

	@GetMapping("/showRequests") public String showRequests(HttpSession session) { session.setAttribute("showRequests", true); session.setAttribute("showFarmers", false); return "redirect:/AgencyDash"; } @GetMapping("/showFarmers") public String showFarmers(HttpSession session) { session.setAttribute("showFarmers", true); session.setAttribute("showRequests", false); return "redirect:/AgencyDash"; }
	
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
	
	
	// 
	// Show farmer inventory on Agency Dashboard
	@GetMapping("/browseInventory")
	public String browseInventory(Model model) {
	    model.addAttribute("crops", cs.getAllCrops());
	    model.addAttribute("fertilizers", Fr.findAll());
	    model.addAttribute("seeds", SR.findAll());
	    model.addAttribute("herbs", Hr.findAll());
	    return "AgencyDash"; // reuse dashboard view
	}
	
	@PostMapping("/buyCrop") 
	public String buyCrop(@RequestParam int cropId, @RequestParam int quantity, HttpSession session) 
	{ 
		Long agencyId =  (Long) session.getAttribute("agencyId"); 
	Agencies agency = as.findById(agencyId); 
	service.buyCrop(cropId, quantity, agency);
	return "redirect:/AgencyDash";
	}
	
	@PostMapping("/buyFertilizer")
	public String buyFertilizer(@RequestParam int fertilizerId, @RequestParam int quantity, HttpSession session) 
	{ 
		
	Long agencyId =  (Long) session.getAttribute("agencyId"); 
	Agencies agency = as.findById(agencyId); 
	service.buyFertilizer(fertilizerId, quantity, agency); 
	return "redirect:/AgencyDash"; 
	
	} 
	
	@PostMapping("/buySeed") 
	public String buySeed(@RequestParam int seedId, @RequestParam int quantity, HttpSession session) 
	
	{ 
		Long agencyId =  (Long) session.getAttribute("agencyId");
		Agencies agency = as.findById(agencyId);
		service.buySeed(seedId, quantity, agency); 
		return "redirect:/AgencyDash"; 
		
	} 
	
	@PostMapping("/buyHerb")
	public String buyHerb(@RequestParam int herbId, @RequestParam int quantity, HttpSession session)
	
	{
		Long agencyId =  (Long) session.getAttribute("agencyId"); 
		Agencies agency = as.findById(agencyId);
		service.buyHerb(herbId, quantity, agency); 
		return "redirect:/AgencyDash"; 
		
	}

	

}

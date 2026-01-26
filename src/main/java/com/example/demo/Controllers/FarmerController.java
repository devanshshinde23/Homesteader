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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.Crop;
import com.example.demo.Service.AgenciesService;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.ServiceRequestService;

@Controller
public class FarmerController {

	@Autowired
	FarmerService ff;
	
	@Autowired
	AgenciesService ags ;
	
	@Autowired 
	ServiceRequestService Service;
	
	
	@GetMapping("/FarmerLogin")
	public String FarmerLogin(HttpSession s1){
		return "FarmerLogin";
	}
	
	
	
	@GetMapping("/farmerRegister")
	public String Register() {
		return "FarmerRegister";
	}
	
	@PostMapping("/savefarmer")
	public String saveFarmer(@ModelAttribute Farmer f1,RedirectAttributes ra) {
		
		ff.register(f1);
		 ra.addFlashAttribute("success", "Registration Successful! Please login.");
		return "redirect:/FarmerLogin";
	}
	


//	@GetMapping("/FarmerDash")
//	public String Farmerdash(HttpSession s1, Model m) {
//	    Farmer FD = (Farmer) s1.getAttribute("temp");
//	    if (FD != null) {
//	        m.addAttribute("kk", FD.getFname());
//	        m.addAttribute("agencies", ags.getAllAgencies()); // now strongly typed
//	        return "FarmerDash";
//	    }
//	    return "redirect:/FarmerLogin";
//	}

	@PostMapping("/checkFarmerData")
	public String Checkfarmer(@RequestParam("username") String u , @RequestParam("password") String p,HttpSession s1, Object f1) {
		
		Farmer fk =ff.CheckFarmerData(u,p);
		
		if(fk!=null) {
			s1.setAttribute("fid", fk.getFid());
			s1.setAttribute("temp", fk);
			return "redirect:/FarmerDash";
		}
		return "redirect:/FarmerLogin";
	}
	
	@GetMapping("/Logout")
	public String logout(HttpSession s1) {
		s1.invalidate();
		return "redirect:/FarmerLogin";
	}
	

	
	@GetMapping("/Viewfarmer")
	public String viewFarmer(HttpSession session, Model model) {

	    Boolean showFarmers = (Boolean) session.getAttribute("showFarmers");

	    // toggle logic
	    if (showFarmers == null || showFarmers == false) {
	        showFarmers = true;
	        model.addAttribute("farmers", ff.Display()); // load data only when showing
	    } 
	    model.addAttribute("showFarmers", true); 
	    model.addAttribute("showAgency", false);
	    model.addAttribute("agencyCount", ags.countAgencies());

	    return "AdminDash";
	}
	
	
	@GetMapping("/requests")
	public String viewFarmerRequests(HttpSession session, Model model) {
	    Long farmerId = (Long) session.getAttribute("fid");
	    if (farmerId != null) {
	        model.addAttribute("requests", ff.getFarmerRequests(farmerId));
	        return "FarmerRequests"; // JSP page to show requests
	    }
	    return "redirect:/FarmerLogin";
	}



//	@GetMapping("/FarmerDash") 
//	public String farmerDash(HttpSession session, Model model) 
//	{
//		int farmerId = (int) session.getAttribute("fid"); // farmer logged in 
//		Farmer farmer = ff.findById(farmerId); // summary cards 
//		
//		model.addAttribute("farmer", farmer);
//		model.addAttribute("totalRequests", Service.countAllByFarmer(farmerId)); 
//		model.addAttribute("approvedRequests", Service.countByFarmerStatus(farmerId, "Approved")); 
//		model.addAttribute("pendingRequests", Service.countByFarmerStatus(farmerId, "Pending")); // list of requests 
//		model.addAttribute("requests", Service.getFarmerRequests(farmerId)); 
//		
//		return "FarmerDash"; 
//		
//	} 
	
	@GetMapping("/FarmerDash")
	public String farmerDash(HttpSession session, Model model) {
	    // Farmer object stored in session
	    Farmer farmer = (Farmer) session.getAttribute("temp");
	    Long farmerId = (Long) session.getAttribute("fid");

	    if (farmer == null || farmerId == null) {
	        return "redirect:/FarmerLogin";
	    }

	    // Farmer basic info
	    model.addAttribute("kk", farmer.getFname());
	    model.addAttribute("farmer", farmer);

	    // Agencies list
	    model.addAttribute("agencies", ags.getAllAgencies());

	    // Summary cards
	    model.addAttribute("totalRequests", Service.countAllByFarmer(farmerId));
	    model.addAttribute("approvedRequests", Service.countByFarmerStatus(farmerId, "Approved"));
	    model.addAttribute("pendingRequests", Service.countByFarmerStatus(farmerId, "Pending"));

	    // Requests list
	    model.addAttribute("requests", Service.getFarmerRequests(farmerId));

	    return "FarmerDash";
	}

	// Approve request 
	
	@PostMapping("/approveRequest/{id}") 
	public String approveRequest(@PathVariable int id) 
	{
		Service.updateStatus(id, "Approved");
		return "redirect:/FarmerDash"; 
		
	} 
	// Reject request 
	@PostMapping("/rejectRequest/{id}") 
	public String rejectRequest(@PathVariable int id) 
	{
		Service.updateStatus(id, "Rejected"); 
		return "redirect:/FarmerDash"; 
		
	}
	
	
	
	
	
	
	
	
}

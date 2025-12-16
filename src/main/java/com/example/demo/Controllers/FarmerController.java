package com.example.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.Farmer;
import com.example.demo.Model.Crop;
import com.example.demo.Service.FarmerService;

@Controller
public class FarmerController {

	@Autowired
	FarmerService ff;
	
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
	
	@GetMapping("/FarmerDash")
	public String Farmerdash(HttpSession s1, Model m) {
		if(s1.getAttribute("temp")!=null) {
//			Farmer FD=(Farmer)s1.getAttribute("temp");
//			m.addAttribute("kk", FD);
			return "FarmerDash";
		}
		return "redirect:/FarmerLogin";
	}
	
	@PostMapping("/checkFarmerData")
	public String Checkfarmer(@RequestParam("username") String u , @RequestParam("password") String p,HttpSession s1, Object f1) {
		
		Farmer fk =ff.CheckFarmerData(u,p);
		
		if(fk!=null) {
			s1.setAttribute("fid", fk.getFid());
			s1.setAttribute("temp", fk.getFname());
			return "redirect:/FarmerDash";
		}
		return "redirect:/FarmerLogin";
	}
	
	@GetMapping("/Logout")
	public String logout(HttpSession s1) {
		s1.invalidate();
		return "redirect:/FarmerLogin";
	}
	
//	@GetMapping("/Viewfarmer")
//	public String viewFarmer(Model m) {
//		List<Farmer> ll=ff.Display();
//		m.addAttribute("temp",ll);
//		m.addAttribute("showFarmers", true);
//		return "AdminDash";
//	}
	
	@GetMapping("/Viewfarmer")
	public String viewFarmer(HttpSession session, Model model) {

	    Boolean showFarmers = (Boolean) session.getAttribute("showFarmers");

	    // toggle logic
	    if (showFarmers == null || showFarmers == false) {
	        showFarmers = true;
	        model.addAttribute("temp", ff.Display()); // load data only when showing
	    } else {
	        showFarmers = false;
	    }

	    session.setAttribute("showFarmers", showFarmers);
	    model.addAttribute("showFarmers", showFarmers);

	    return "AdminDash";
	}
	
	
	
	
	
	
	
	
	
	
}

package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Herb;
import com.example.demo.Service.HerbService;

@Controller
public class HerbsController {

	@Autowired
	HerbService hs;
	@GetMapping("/AddHerbs")
	public String OpenAddHerbsPage(Model m ,HttpSession s1) {
		
		Integer farmerId = (Integer) s1.getAttribute("fid");
		
		m.addAttribute("farmerId", farmerId);
		m.addAttribute("herb", new Herb());
		
		return "AddHerbs";
	}
	
	@PostMapping("/saveHerbs")
	public String saveHerb(@ModelAttribute("herb") Herb herb, HttpSession s1) {
		
		Integer fid = (Integer) s1.getAttribute("fid");
		
		if(fid == null) {
			return"redirect:/FarmerLogin";
		}
		
		hs.addHerb(herb , fid);
		return"FarmerDash";
				
	}
	
}

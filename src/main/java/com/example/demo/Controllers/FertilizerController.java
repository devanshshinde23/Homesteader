package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Fertilizer;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.FertilizerService;

@Controller
public class FertilizerController {
	
	@Autowired
	FertilizerService fs;

	@Autowired
	FarmerService fsr;
	
	@GetMapping("/AddFertilizer")
	public String addFertilizer(Model m , HttpSession session ) {
		Integer farmerId = (Integer) session.getAttribute("fid");
		m.addAttribute("fertilizer" , new Fertilizer());
		m.addAttribute("farmerId", farmerId);
		
		return "AddFertilizer";
	}
	
	@PostMapping("/saveFertilizer")
	public String saveFertilizer(@ModelAttribute ("fertilizer")Fertilizer fertilizer , HttpSession session) {
		Integer farmerId = (Integer) session.getAttribute("fid");
		
		if(farmerId == null) {
			return"redirect:/FarmerLogin";
			
		}
		fs.AddFertilizer(fertilizer , farmerId);
		return "FarmerDash";
	}
}

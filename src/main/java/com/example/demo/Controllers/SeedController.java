package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Seed;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.SeedService;

@Controller
public class SeedController {
	
	@Autowired
	SeedService ss;
	
	@Autowired 
	FarmerService fs;
	
	@GetMapping("/AddSeeds")
	public String AddSeed(Model m , HttpSession session) {
		
		Integer farmerId = (Integer) session.getAttribute("fid");
		m.addAttribute("seed",new Seed());
		m.addAttribute("farmerId",farmerId);
		return "AddSeeds";
	}
	
	@PostMapping("/saveSeed")
	public String SaveSeed(@ModelAttribute ("seed") Seed seed, HttpSession session) {
		
		Integer fid = (Integer) session.getAttribute("fid");
		if(fid == null) {
			return "redirect:/FarmerLogin";
		}
		
		ss.AddSeed(seed,fid);
		
		return "FarmerDash";
	}
}

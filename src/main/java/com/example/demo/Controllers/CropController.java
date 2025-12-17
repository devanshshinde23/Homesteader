package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Crop;
import com.example.demo.Model.Farmer;
import com.example.demo.Service.CropService;
import com.example.demo.Service.FarmerService;

@Controller
public class CropController {

	@Autowired 
	CropService cs;
	
	@Autowired 
	FarmerService fs;
	
	
	@GetMapping("/AddCrop")
	public String openAddCropPage(Model model, HttpSession session) {

	    Integer farmerId = (Integer) session.getAttribute("fid"); // OR however you store it

	    model.addAttribute("crop", new Crop());
	    model.addAttribute("farmerId", farmerId);
	    

	    return "AddCrop";
	}

	

	
	@PostMapping("/saveCrop")
	public String saveCrop(
	        @ModelAttribute("crop") Crop crop,
	        HttpSession session) {

	    // get logged-in farmer id from session
	    Integer fid = (Integer) session.getAttribute("fid");

	    if (fid == null) {
	        return "redirect:/FarmerLogin";
	    }

	    cs.AddCrop(crop, fid);

	    return "redirect:/FarmerDash";
	}

	
	

}

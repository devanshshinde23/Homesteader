//package com.example.demo.Controllers;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.Model.Crop;
//import com.example.demo.Model.Farmer;
//import com.example.demo.Service.CropService;
//import com.example.demo.Service.FarmerService;
//
//@Controller
//public class CropController {
//
//	@Autowired 
//	CropService cs;
//	
//	@Autowired 
//	FarmerService fs;
//	
//	
//	@GetMapping("/AddCrop")
//	public String openAddCropPage(Model model, HttpSession session) {
//
//	    Integer farmerId = (Integer) session.getAttribute("fid"); // OR however you store it
//
//	    model.addAttribute("crop", new Crop());
//	    model.addAttribute("farmerId", farmerId);
//	    
//
//	    return "AddCrop";
//	}
//
//	
//
//	
//	@PostMapping("/saveCrop")
//	public String saveCrop(
//	        @ModelAttribute("crop") Crop crop,
//	        HttpSession session) {
//
//	    // get logged-in farmer id from session
//	    Integer fid = (Integer) session.getAttribute("fid");
//
//	    if (fid == null) {
//	        return "redirect:/FarmerLogin";
//	    }
//
//	    cs.AddCrop(crop, fid);
//
//	    return "redirect:/FarmerDash";
//	}
//
//	
//	
//
//}

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
    private CropService cropService;

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/AddCrop")
    public String openAddCropPage(Model model, HttpSession session) {

        Integer farmerId = (Integer) session.getAttribute("fid"); // farmer login
        Object temp = session.getAttribute("temp");               // could be Farmer or String

        model.addAttribute("crop", new Crop());

        if (farmerId != null) {
            // Farmer logged in → hidden field
            model.addAttribute("farmerId", farmerId);
        } else if (temp != null && temp instanceof String) {
            // Admin logged in → dropdown of farmers
            model.addAttribute("farmers", farmerService.Display());
        }

        return "AddCrop";
    }

    @PostMapping("/saveCrop")
    public String saveCrop(
            @ModelAttribute("crop") Crop crop,
            HttpSession session,
            @RequestParam(value = "farmerId", required = false) Integer farmerId) {

        Integer fid = (Integer) session.getAttribute("fid");
        Object temp = session.getAttribute("temp");

        if (fid != null) {
            // Farmer logged in
            cropService.AddCrop(crop, fid);
            return "redirect:/FarmerDash";
        } else if (temp != null && temp instanceof String && farmerId != null) {
            // Admin logged in
            cropService.AddCrop(crop, farmerId);
            return "redirect:/AdminDash";
        }

        return "redirect:/FarmerLogin";
    }
}


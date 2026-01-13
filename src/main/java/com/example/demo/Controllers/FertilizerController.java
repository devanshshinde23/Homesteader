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
//
//import com.example.demo.Model.Fertilizer;
//import com.example.demo.Service.FarmerService;
//import com.example.demo.Service.FertilizerService;
//
//@Controller
//public class FertilizerController {
//	
//	@Autowired
//	FertilizerService fs;
//
//	@Autowired
//	FarmerService fsr;
//	
//	@GetMapping("/AddFertilizer")
//	public String addFertilizer(Model m , HttpSession session ) {
//		Integer farmerId = (Integer) session.getAttribute("fid");
//		m.addAttribute("fertilizer" , new Fertilizer());
//		m.addAttribute("farmerId", farmerId);
//		
//		return "AddFertilizer";
//	}
//	
//	@PostMapping("/saveFertilizer")
//	public String saveFertilizer(@ModelAttribute ("fertilizer")Fertilizer fertilizer , HttpSession session) {
//		Integer farmerId = (Integer) session.getAttribute("fid");
//		
//		if(farmerId == null) {
//			return"redirect:/FarmerLogin";
//			
//		}
//		fs.AddFertilizer(fertilizer , farmerId);
//		return "FarmerDash";
//	}
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

import com.example.demo.Model.Fertilizer;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.FertilizerService;

@Controller
public class FertilizerController {
    
    @Autowired
    private FertilizerService fertilizerService;

    @Autowired
    private FarmerService farmerService;
    
    /**
     * Open Add Fertilizer page.
     * - If Farmer logged in → farmerId comes from session.
     * - If Admin logged in → load list of farmers for dropdown.
     */
    @GetMapping("/AddFertilizer")
    public String openAddFertilizerPage(Model model, HttpSession session) {
        
        Integer farmerId = (Integer) session.getAttribute("fid"); // farmer login
        Object temp = session.getAttribute("temp");               // could be Farmer or String
        
        model.addAttribute("fertilizer", new Fertilizer());
        
        if (farmerId != null) {
            // Farmer logged in → hidden field
            model.addAttribute("farmerId", farmerId);
        } else if (temp != null && temp instanceof String) {
            // Admin logged in → dropdown of farmers
            model.addAttribute("farmers", farmerService.Display());
        }
        
        return "AddFertilizer";
    }
    
    /**
     * Save Fertilizer.
     * - Farmer login → use session fid.
     * - Admin login → use farmerId from form.
     */
    @PostMapping("/saveFertilizer")
    public String saveFertilizer(
            @ModelAttribute("fertilizer") Fertilizer fertilizer,
            HttpSession session,
            @RequestParam(value = "farmerId", required = false) Integer farmerId) {
        
        Integer fid = (Integer) session.getAttribute("fid");
        Object temp = session.getAttribute("temp");
        
        if (fid != null) {
            // Farmer logged in
            fertilizerService.AddFertilizer(fertilizer, fid);
            return "redirect:/FarmerDash";
        } else if (temp != null && temp instanceof String && farmerId != null) {
            // Admin logged in
            fertilizerService.AddFertilizer(fertilizer, farmerId);
            return "redirect:/AdminDash";
        }
        
        // No valid login → redirect
        return "redirect:/FarmerLogin";
    }
}

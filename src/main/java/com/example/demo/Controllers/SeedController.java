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
//import com.example.demo.Model.Seed;
//import com.example.demo.Service.FarmerService;
//import com.example.demo.Service.SeedService;
//
//@Controller
//public class SeedController {
//	
//	@Autowired
//	SeedService ss;
//	
//	@Autowired 
//	FarmerService fs;
//	
//	@GetMapping("/AddSeeds")
//	public String AddSeed(Model m , HttpSession session) {
//		
//		Integer farmerId = (Integer) session.getAttribute("fid");
//		m.addAttribute("seed",new Seed());
//		m.addAttribute("farmerId",farmerId);
//		return "AddSeeds";
//	}
//	
//	@PostMapping("/saveSeed")
//	public String SaveSeed(@ModelAttribute ("seed") Seed seed, HttpSession session) {
//		
//		Integer fid = (Integer) session.getAttribute("fid");
//		if(fid == null) {
//			return "redirect:/FarmerLogin";
//		}
//		
//		ss.AddSeed(seed,fid);
//		
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

import com.example.demo.Model.Seed;
import com.example.demo.Service.FarmerService;
import com.example.demo.Service.SeedService;

@Controller
public class SeedController {
    
    @Autowired
    private SeedService seedService;
    
    @Autowired 
    private FarmerService farmerService;
    
    /**
     * Open Add Seeds page.
     * - If Farmer logged in → farmerId comes from session.
     * - If Admin logged in → load list of farmers for dropdown.
     */
    @GetMapping("/AddSeeds")
    public String openAddSeedsPage(Model model, HttpSession session) {
        
        Integer farmerId = (Integer) session.getAttribute("fid"); // farmer login
        Object temp = session.getAttribute("temp");               // could be Farmer or String
        
        model.addAttribute("seed", new Seed());
        
        if (farmerId != null) {
            // Farmer logged in → hidden field
            model.addAttribute("farmerId", farmerId);
        } else if (temp != null && temp instanceof String) {
            // Admin logged in → dropdown of farmers
            model.addAttribute("farmers", farmerService.Display());
        }
        
        return "AddSeeds";
    }
    
    /**
     * Save Seed.
     * - Farmer login → use session fid.
     * - Admin login → use farmerId from form.
     */
    @PostMapping("/saveSeed")
    public String saveSeed(
            @ModelAttribute("seed") Seed seed,
            HttpSession session,
            @RequestParam(value = "farmerId", required = false) Integer farmerId) {
        
        Integer fid = (Integer) session.getAttribute("fid");
        Object temp = session.getAttribute("temp");
        
        if (fid != null) {
            // Farmer logged in
            seedService.AddSeed(seed, fid);
            return "redirect:/FarmerDash";
        } else if (temp != null && temp instanceof String && farmerId != null) {
            // Admin logged in
            seedService.AddSeed(seed, farmerId);
            return "redirect:/AdminDash";
        }
        
        // No valid login → redirect
        return "redirect:/FarmerLogin";
    }
}

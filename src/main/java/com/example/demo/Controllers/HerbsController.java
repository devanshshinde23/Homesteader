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
//import com.example.demo.Model.Herb;
//import com.example.demo.Service.HerbService;
//
//@Controller
//public class HerbsController {
//
//	@Autowired
//	HerbService hs;
//	@GetMapping("/AddHerbs")
//	public String OpenAddHerbsPage(Model m ,HttpSession s1) {
//		
//		Integer farmerId = (Integer) s1.getAttribute("fid");
//		
//		m.addAttribute("farmerId", farmerId);
//		m.addAttribute("herb", new Herb());
//		
//		return "AddHerbs";
//	}
//	
//	@PostMapping("/saveHerbs")
//	public String saveHerb(@ModelAttribute("herb") Herb herb, HttpSession s1) {
//		
//		Integer fid = (Integer) s1.getAttribute("fid");
//		
//		if(fid == null) {
//			return"redirect:/FarmerLogin";
//		}
//		
//		hs.addHerb(herb , fid);
//		return"FarmerDash";
//				
//	}
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

import com.example.demo.Model.Herb;
import com.example.demo.Service.HerbService;
import com.example.demo.Service.FarmerService;

@Controller
public class HerbsController {

    @Autowired
    private HerbService herbService;

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/AddHerbs")
    public String openAddHerbsPage(Model model, HttpSession session) {

        Integer farmerId = (Integer) session.getAttribute("fid"); // farmer login
        Object temp = session.getAttribute("temp");               // could be Farmer or String

        model.addAttribute("herb", new Herb());

        if (farmerId != null) {
            // Farmer logged in → hidden field
            model.addAttribute("farmerId", farmerId);
        } else if (temp != null && temp instanceof String) {
            // Admin logged in → dropdown of farmers
            model.addAttribute("farmers", farmerService.Display());
        }

        return "AddHerbs";
    }

    @PostMapping("/saveHerbs")
    public String saveHerb(
            @ModelAttribute("herb") Herb herb,
            HttpSession session,
            @RequestParam(value = "farmerId", required = false) Integer farmerId) {

        Integer fid = (Integer) session.getAttribute("fid");
        Object temp = session.getAttribute("temp");

        if (fid != null) {
            // Farmer logged in
            herbService.addHerb(herb, fid);
            return "redirect:/FarmerDash";
        } else if (temp != null && temp instanceof String && farmerId != null) {
            // Admin logged in
            herbService.addHerb(herb, farmerId);
            return "redirect:/AdminDash";
        }

        return "redirect:/FarmerLogin";
    }
}

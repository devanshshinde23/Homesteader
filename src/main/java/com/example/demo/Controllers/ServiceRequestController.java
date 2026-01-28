package com.example.demo.Controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ServiceRequestService;
@Controller
@RequestMapping("/requests")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestService service;
    
    

//    @PostMapping("/create")
//    public String createRequest(@RequestParam Long agencyId,
//                                @RequestParam String type,
//                                @RequestParam String details,
//                                HttpSession session) {
//        Long farmerId = (Long) session.getAttribute("fid");
//        service.createRequest(farmerId, agencyId, type, details);
//        return "redirect:/requests/farmer";
//    }
    
    @PostMapping("/create")
    public String createRequest(@RequestParam Long agencyId,
                                @RequestParam String type,
                                @RequestParam String details,
                                @RequestParam Integer quantity,
                                @RequestParam String unit,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate preferredDate,
                                @RequestParam String deliveryMode,
                                HttpSession session) {
        Long farmerId = (Long) session.getAttribute("fid");
        service.createRequest(farmerId, agencyId, type, details, quantity, unit, preferredDate, deliveryMode);
        return "redirect:/FarmerDash";
    }


    @GetMapping("/farmer")
    public String viewFarmerRequests(HttpSession session, Model model) {
        Long farmerId = (Long) session.getAttribute("fid");
        model.addAttribute("requests", service.getFarmerRequests(farmerId));
        return "FarmerRequests";
    }

    @GetMapping("/agency")
    public String viewAgencyRequests(HttpSession session, Model model) {
        Long agencyId = (Long) session.getAttribute("agencyId");
        model.addAttribute("requests", service.getAgencyRequests(agencyId));
        return "agency/requests";
    }

//    @PostMapping("/update/{id}")
//    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
//        service.updateStatus(id, status);
//        return "redirect:/AgencyDash";
//    }
    
    
    @PostMapping("/update/{id}")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status,
                               HttpSession session) {
        service.updateStatus(id, status);

        if (session.getAttribute("fid") != null) {
            return "redirect:/FarmerDash";
        } else if (session.getAttribute("agencyId") != null) {
            return "redirect:/AgencyDash";
        }
        return "redirect:/"; // fallback
    }

    

}

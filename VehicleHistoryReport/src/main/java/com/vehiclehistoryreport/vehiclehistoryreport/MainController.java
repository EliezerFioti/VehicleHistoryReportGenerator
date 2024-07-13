package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.vehicle.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "index";
    }

    @GetMapping("/report")
    public String showVehicleReport(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "report";
    }
}

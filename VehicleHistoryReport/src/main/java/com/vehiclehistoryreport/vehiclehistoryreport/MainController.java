package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("")
    public String showHomePage(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "index";
    }

}

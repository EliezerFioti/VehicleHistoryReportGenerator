package com.vehiclehistoryreport.vehiclehistoryreport.controller;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.MaintenanceRecord;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
//import com.vehiclehistoryreport.vehiclehistoryreport.service.AccidentService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.AccidentService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.MaintenanceRecordService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.OwnerService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ReportController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private AccidentService accidentService;
    @Autowired
    private MaintenanceRecordService maintenanceRecordService;

    @GetMapping("report")
    public String showReport(@RequestParam String vehicleVin, Model model) {
        Optional<Vehicle> optionalVehicle = vehicleService.findVehicleByVin(vehicleVin);

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            Set<Owner> owners = ownerService.findOwnersByVehicleVin(vehicleVin);
            List<Accident> accidents = accidentService.findAccidentsByVehicleVin(vehicleVin);
            Set<MaintenanceRecord> maintenanceRecords = maintenanceRecordService.findAccidentsByVehicleVin(vehicleVin);

            model.addAttribute("vehicle", vehicle);
            model.addAttribute("owners", owners);
            model.addAttribute("accidents", accidents);
            model.addAttribute("maintenanceRecords", maintenanceRecords);
        } else {
            // Handle case where vehicle is not found, maybe redirect to an error page
            return "error";
        }

        return "report";
    }
}

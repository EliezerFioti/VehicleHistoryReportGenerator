package com.vehiclehistoryreport.vehiclehistoryreport.controller;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {
    @Autowired
    private AccidentService accidentService;

    @GetMapping("/{accidentId}/vehicles")
    public ResponseEntity<List<Vehicle>> getAccidentsForVehicles(
            @PathVariable Long accidentId
    ) {
        Accident accident = accidentService.findAccidentById(accidentId);

        if (accident == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok((List<Vehicle>) accident.getVehicle());
    }

}

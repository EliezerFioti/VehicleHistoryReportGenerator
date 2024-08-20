package com.vehiclehistoryreport.vehiclehistoryreport.controller;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.MaintenanceRecord;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.service.AccidentService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.MaintenanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/maintenance_records")
public class MaintenanceRecordController {
    @Autowired
    private MaintenanceRecordService maintenanceRecordService;

    @GetMapping("/{maintenanceRecordId}/vehicles")
    public ResponseEntity<Set<Vehicle>> getMaintenanceRecordForVehicles(
            @PathVariable Long maintenanceRecordId
    ) {
        MaintenanceRecord maintenanceRecord = maintenanceRecordService.findMaintenanceRecordById(maintenanceRecordId);

        if (maintenanceRecord == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok((Set<Vehicle>) maintenanceRecord.getVehicle());
    }
}

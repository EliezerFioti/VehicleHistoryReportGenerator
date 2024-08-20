package com.vehiclehistoryreport.vehiclehistoryreport.controller;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/{ownerId}/vehicles")
    public ResponseEntity<Set<Vehicle>> getVehiclesForOwner(
            @PathVariable Long ownerId
    ) {
        Owner owner = ownerService.findOwnerById(ownerId);

        if (owner == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(owner.getVehicles());
    }
}



package com.vehiclehistoryreport.vehiclehistoryreport.controller;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.service.OwnerService;
import com.vehiclehistoryreport.vehiclehistoryreport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private OwnerService ownerService;

//    @PostMapping("/{vehicleId}/owners/{ownerId}")
//    public ResponseEntity<Vehicle> addOwnerToVehicle(
//            @PathVariable Long vehicleId,
//            @PathVariable Long ownerId
//    ) {
//        Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
//        Owner owner = ownerService.findOwnerById(ownerId);
//
//        if (vehicle == null || owner == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        vehicle.getOwners().add(owner);
//        vehicleService.save(vehicle);
//
//        return ResponseEntity.ok(vehicle);
//    }
//
//    @DeleteMapping("/{vehicleId}/owners/{ownerId}")
//    public ResponseEntity<Vehicle> removeOwnerFromVehicle(
//            @PathVariable Long vehicleId,
//            @PathVariable Long ownerId
//    ) {
//        Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
//        Owner owner = ownerService.findOwnerById(ownerId);
//
//        if (vehicle == null || owner == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        vehicle.getOwners().remove(owner);
//        vehicleService.save(vehicle);
//
//        return ResponseEntity.ok(vehicle);
//    }

    @GetMapping("/{vehicleId}/owners")
    public ResponseEntity<Set<Owner>> getOwnersForVehicle(
            @PathVariable Long vehicleId
    ) {
        Vehicle vehicle = vehicleService.findVehicleById(vehicleId);

        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicle.getOwners());
    }

}

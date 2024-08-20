package com.vehiclehistoryreport.vehiclehistoryreport.service;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> findVehicleByVin(String vehicleVin) {
        return vehicleRepository.findByVehicleVin(vehicleVin);
    }

    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}

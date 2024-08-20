package com.vehiclehistoryreport.vehiclehistoryreport.repository;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Optional<Vehicle> findByVehicleVin(String vehicleVin);

    Vehicle findByVehicleId(Long vehicleId);
}

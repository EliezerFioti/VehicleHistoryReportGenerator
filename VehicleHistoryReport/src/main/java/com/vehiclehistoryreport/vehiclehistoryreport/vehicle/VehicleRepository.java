package com.vehiclehistoryreport.vehiclehistoryreport.vehicle;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}

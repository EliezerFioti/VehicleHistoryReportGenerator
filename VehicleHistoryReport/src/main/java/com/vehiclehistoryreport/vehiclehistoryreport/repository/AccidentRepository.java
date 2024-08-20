package com.vehiclehistoryreport.vehiclehistoryreport.repository;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Long> {

    @Query("SELECT a FROM Accident a WHERE a.vehicle.vehicleVin = :vehicleVin ORDER BY a.accidentDate DESC")
    List<Accident> findByVehicleVin(@Param("vehicleVin") String vehicleVin);
}


package com.vehiclehistoryreport.vehiclehistoryreport.repository;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    @Query("SELECT o FROM Owner o JOIN o.vehicles v WHERE v.vehicleVin = :vehicleVin")
    Set<Owner> findByVehicleVin(@Param("vehicleVin") String vehicleVin);
}

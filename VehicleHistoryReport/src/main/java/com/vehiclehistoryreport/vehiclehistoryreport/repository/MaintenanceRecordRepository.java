package com.vehiclehistoryreport.vehiclehistoryreport.repository;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.MaintenanceRecord;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MaintenanceRecordRepository extends CrudRepository<MaintenanceRecord, Long> {
    @Query("SELECT mr FROM MaintenanceRecord mr WHERE mr.vehicle.vehicleVin = :vehicleVin ORDER BY mr.maintenanceDate DESC")
    Set<MaintenanceRecord> findByVehicleVin(@Param("vehicleVin") String vehicleVin);
}

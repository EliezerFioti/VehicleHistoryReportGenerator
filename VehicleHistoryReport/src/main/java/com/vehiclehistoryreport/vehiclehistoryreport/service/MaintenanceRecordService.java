package com.vehiclehistoryreport.vehiclehistoryreport.service;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.MaintenanceRecord;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.MaintenanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MaintenanceRecordService {

    @Autowired
    private MaintenanceRecordRepository maintenanceRecordRepository;

    public Set<MaintenanceRecord> findAccidentsByVehicleVin(String vehicleVin) {
        return maintenanceRecordRepository.findByVehicleVin(vehicleVin);
    }

    public MaintenanceRecord findMaintenanceRecordById(Long accidentId) {
        return maintenanceRecordRepository.findById(accidentId).orElse(null);
    }
}

package com.vehiclehistoryreport.vehiclehistoryreport.service;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.AccidentRepository;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentRepository accidentRepository;

    public List<Accident> findAccidentsByVehicleVin(String vehicleVin) {
        return accidentRepository.findByVehicleVin(vehicleVin);
    }

    public Accident findAccidentById(Long accidentId) {
        return accidentRepository.findById(accidentId).orElse(null);
    }

//    public Set<Accident> findAccidentsByVehicleId(Long vehicleId) {
//        return accidentRepository.findByVehicleId(vehicleId);
//    }
}

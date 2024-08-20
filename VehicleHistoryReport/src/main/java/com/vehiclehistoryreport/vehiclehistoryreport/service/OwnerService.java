package com.vehiclehistoryreport.vehiclehistoryreport.service;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Set<Owner> findOwnersByVehicleVin(String vehicleVin) {
        return ownerRepository.findByVehicleVin(vehicleVin);
    }

    public Owner findOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }
}

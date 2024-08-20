package com.vehiclehistoryreport.vehiclehistoryreport.model;

import jakarta.persistence.*;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(length = 50, nullable = false)
    private String ownerName;

    @ManyToMany(mappedBy = "owners", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    public Owner() {
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}

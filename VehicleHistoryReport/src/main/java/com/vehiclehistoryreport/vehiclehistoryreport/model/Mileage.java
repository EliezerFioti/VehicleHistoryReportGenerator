package com.vehiclehistoryreport.vehiclehistoryreport.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mileages")
public class Mileage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mileageId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date milageDate;

    @Column(length = 255)
    private int mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vihicleId")
    private Vehicle vehicle;

    public Long getMileageId() {
        return mileageId;
    }

    public void setMileageId(Long mileageId) {
        this.mileageId = mileageId;
    }

    public Date getMilageDate() {
        return milageDate;
    }

    public void setMilageDate(Date milageDate) {
        this.milageDate = milageDate;
    }

    public int getMileageDescription() {
        return mileage;
    }

    public void setMileageDescription(int mileage) {
        mileage = mileage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

package com.vehiclehistoryreport.vehiclehistoryreport.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "maintenance_records")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceRecordId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date maintenanceDate;

    @Column(length = 255)
    private String maintenanceDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vihicleId")
    private Vehicle vehicle;

    public Long getMaintenanceRecordId() {
        return maintenanceRecordId;
    }

    public void setMaintenanceRecordId(Long maintenanceRecordId) {
        this.maintenanceRecordId = maintenanceRecordId;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.MaintenanceRecord;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.MaintenanceRecordRepository;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.VehicleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MaintenanceRecordRepositoryTests {
    @Autowired
    private MaintenanceRecordRepository maintenanceRecordRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testAddNewAccidents() {
        // Retrieve the existing vehicle by its VIN
        String vehicleVin = "1VXBR12EXCP901214";
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleVin(vehicleVin);

        // Ensure that the vehicle exists
        Assertions.assertThat(optionalVehicle).isPresent();
        Vehicle existingMaintenanceRecord = optionalVehicle.get();

        // Create a new Accident and associate it with the existing Vehicle
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();

        // Set the accident date using a properly formatted Date object
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date maintenanceDate = dateFormat.parse("2024-06-15");
            maintenanceRecord.setMaintenanceDate(maintenanceDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception if the date format is wrong
        }

        maintenanceRecord.setMaintenanceDescription("Computer(s) checked");
        maintenanceRecord.setVehicle(existingMaintenanceRecord);

        // Save the Accident
        MaintenanceRecord savedMaintenanceRecord = maintenanceRecordRepository.save(maintenanceRecord);

        // Assert that the Accident was saved and is associated with the correct Vehicle
        Assertions.assertThat(savedMaintenanceRecord).isNotNull();
        Assertions.assertThat(savedMaintenanceRecord.getMaintenanceRecordId()).isGreaterThan(0);
        Assertions.assertThat(savedMaintenanceRecord.getVehicle().getVehicleVin()).isEqualTo(vehicleVin);
    }
}

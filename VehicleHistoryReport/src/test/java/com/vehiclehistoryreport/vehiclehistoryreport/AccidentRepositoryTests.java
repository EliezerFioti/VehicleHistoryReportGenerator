package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Accident;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.AccidentRepository;
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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AccidentRepositoryTests {
    @Autowired
    private AccidentRepository accidentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testAddNewAccidents() {
        // Retrieve the existing vehicle by its VIN
        String vehicleVin = "1VXBR12EXCP901214";
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleVin(vehicleVin);

        // Ensure that the vehicle exists
        Assertions.assertThat(optionalVehicle).isPresent();
        Vehicle existingVehicle = optionalVehicle.get();

        // Create a new Accident and associate it with the existing Vehicle
        Accident accident = new Accident();

        // Set the accident date using a properly formatted Date object
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date accidentDate = dateFormat.parse("2023-08-10");
            accident.setAccidentDate(accidentDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception if the date format is wrong
        }

        accident.setAccidentDescription("Hit a pothole, damaged tire");
        accident.setVehicle(existingVehicle);

        // Save the Accident
        Accident savedAccident = accidentRepository.save(accident);

        // Assert that the Accident was saved and is associated with the correct Vehicle
        Assertions.assertThat(savedAccident).isNotNull();
        Assertions.assertThat(savedAccident.getAccidentId()).isGreaterThan(0);
        Assertions.assertThat(savedAccident.getVehicle().getVehicleVin()).isEqualTo(vehicleVin);
    }

    @Test
    public void testListAll() {
        Iterable<Accident> accidents = accidentRepository.findAll();
        Assertions.assertThat(accidents).hasSizeGreaterThan(0);

        for(Accident accident : accidents) {
            System.out.println(accidents); // Print each accident individually
        }
    }

    @Test
    public void testUpdate() {
        Long accidentId = 1L;
        Optional<Accident> optionalAccident = accidentRepository.findById(accidentId);
        Accident accident = optionalAccident.get();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date accidentDate = dateFormat.parse("2021-02-13");
            accident.setAccidentDate(accidentDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception if the date format is wrong
        }

        accident.setAccidentDescription("Eliezer Fioti");
        accidentRepository.save(accident);

        Accident updatedAccident = accidentRepository.findById(accidentId).get();
        Assertions.assertThat(updatedAccident.getAccidentDate()).isEqualTo("Eliezer Fioti");
        Assertions.assertThat(updatedAccident.getAccidentDescription()).isEqualTo("Eliezer Fioti");
    }

    @Test
    public void testGet() {
        Long accidentId = 1L;
        Optional<Accident> optionalAccident = accidentRepository.findById(accidentId);
        Assertions.assertThat(optionalAccident).isPresent();
        System.out.println(optionalAccident.get());
    }

    @Test
    public void testDelete() {
        Long accidentId = 2L;
        accidentRepository.deleteById(accidentId);

        Optional<Accident> optionalAccident = accidentRepository.findById(accidentId);
        Assertions.assertThat(optionalAccident).isNotPresent();

    }
}

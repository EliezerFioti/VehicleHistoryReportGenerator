package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.OwnerRepository;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.VehicleRepository;
import com.vehiclehistoryreport.vehiclehistoryreport.service.VehicleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class OwnerRepositoryTests {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testAddNewOwner() {
        // Create vehicles
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleVin("1HGBH41JXMN109186");
        vehicle1.setVehicleYear(2020);
        vehicle1.setVehicleMake("Honda");
        vehicle1.setVehicleModel("Civic");
        vehicle1.setVehicleTrim("EX");
        vehicle1.setVehicleEngine("1.5L Turbo");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleVin("2T1BURHE7JC123456");
        vehicle2.setVehicleYear(2019);
        vehicle2.setVehicleMake("Toyota");
        vehicle2.setVehicleModel("Corolla");
        vehicle2.setVehicleTrim("SE");
        vehicle2.setVehicleEngine("2.0L I4");

        // Create owner
        Owner owner = new Owner();
        owner.setOwnerName("Alice Johnson");

        // Associate vehicles with owner
        Set<Vehicle> vehicles = new HashSet<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        owner.setVehicles(vehicles);

        // Save vehicles and owner
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        Owner savedOwner = ownerRepository.save(owner);

        Assertions.assertThat(savedOwner).isNotNull();
        Assertions.assertThat(savedOwner.getOwnerId()).isGreaterThan(0);
        Assertions.assertThat(savedOwner.getVehicles()).hasSize(2);
    }

    @Test
    public void testListAll() {
        Iterable<Owner> owners = ownerRepository.findAll();
        Assertions.assertThat(owners).hasSizeGreaterThan(0);

        for(Owner owner : owners) {
            System.out.println(owners);
        }
    }

    @Test
    public void testUpdate() {
        Long ownerId = 1L;
        Optional<Owner> optionalVehicle = ownerRepository.findById(ownerId);
        Owner owner = optionalVehicle.get();
        owner.setOwnerName("Eliezer Fioti");
        ownerRepository.save(owner);

        Owner updatedOwner = ownerRepository.findById(ownerId).get();
        Assertions.assertThat(updatedOwner.getOwnerName()).isEqualTo("Eliezer Fioti");
    }

    @Test
    public void testGet() {
        Long ownerId = 1L;
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        Assertions.assertThat(optionalOwner).isPresent();
        System.out.println(optionalOwner.get());
    }

    @Test
    public void testDelete() {
        Long ownerId = 2L;
        ownerRepository.deleteById(ownerId);

        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        Assertions.assertThat(optionalOwner).isNotPresent();

    }
}

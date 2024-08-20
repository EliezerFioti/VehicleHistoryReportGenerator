package com.vehiclehistoryreport.vehiclehistoryreport;

import com.vehiclehistoryreport.vehiclehistoryreport.model.Owner;
import com.vehiclehistoryreport.vehiclehistoryreport.model.Vehicle;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.OwnerRepository;
import com.vehiclehistoryreport.vehiclehistoryreport.repository.VehicleRepository;
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
@Rollback(value = false)
public class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void testAddNewVehicle() {
        // Create vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleVin("3FA6P0HR1DR123456");
        vehicle.setVehicleYear(2018);
        vehicle.setVehicleMake("Ford");
        vehicle.setVehicleModel("Fusion");
        vehicle.setVehicleTrim("SE");
        vehicle.setVehicleEngine("2.0L L4 DOHC 16V");

        // Create owners
        Owner owner1 = new Owner();
        owner1.setOwnerName("Jemima Lukifimpa");

        // Associate owners with vehicle
        Set<Owner> owners = new HashSet<>();
        owners.add(owner1);

        vehicle.setOwners(owners);

        // Save owners and vehicle
        ownerRepository.save(owner1);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        Assertions.assertThat(savedVehicle).isNotNull();
        Assertions.assertThat(savedVehicle.getVehicleId()).isGreaterThan(0);
        Assertions.assertThat(savedVehicle.getOwners()).hasSize(1);
    }

    @Test
    public void testListAll() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        Assertions.assertThat(vehicles).hasSizeGreaterThan(0);

        for(Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    @Test
    public void testUpdate() {
        Long vehicleId = 1L;
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        Vehicle vehicle = optionalVehicle.get();
        vehicle.setVehicleModel("Camry");
        vehicleRepository.save(vehicle);

        Vehicle updatedVehicle = vehicleRepository.findById(vehicleId).get();
        Assertions.assertThat(updatedVehicle.getVehicleModel()).isEqualTo("Camery");
    }

    @Test
    public void testGet() {
        Long vehicleId = 1L;
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        Assertions.assertThat(optionalVehicle).isPresent();
        System.out.println(optionalVehicle.get());
    }

    @Test
    public void testDelete() {
        Long vehicleId = 2L;
        vehicleRepository.deleteById(vehicleId);

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        Assertions.assertThat(optionalVehicle).isNotPresent();

    }

}

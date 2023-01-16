package cars.example.bettercars.dao;

import cars.example.bettercars.model.User;
import cars.example.bettercars.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleDAO {
    List<Vehicle> findAll();

    void addVehicle(Vehicle vehicle);

    Optional<Vehicle> findById(Long id);
    Optional<Vehicle> findByModel(String model_name);
    int deleteVehicle(int id);
    int updateVehicle(int id, Vehicle vehicle);

    void addImageToVehicle(String vehicleId, byte[] bytes);
}


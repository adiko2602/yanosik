package dao.vehicle;

import models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDao implements IVehicleDao {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleDao() {
        vehicles.add(new Vehicle(1, 1, "Audi", "A6"));
        vehicles.add(new Vehicle(2, 1, "BMW", "5"));
        vehicles.add(new Vehicle(3, 2, "BMW", "5"));
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(long userId) {
        List<Vehicle> vehiclesByUserId = new ArrayList<>();

        vehicles.forEach(vehicle -> {
            if(vehicle.getUserId() == userId) vehiclesByUserId.add(vehicle);
        });

        return vehiclesByUserId;
    }

    @Override
    public Vehicle get(long vehicleId) {
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getId() == vehicleId) return vehicle;
        }
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicles.forEach(v -> {
            if (v.getId() == vehicle.getId()) {
                v.setBrand(vehicle.getBrand());
                v.setModel(vehicle.getModel());
            }
        });
    }

    @Override
    public void delete(long vehicleId) {
        vehicles = vehicles.stream().filter(vehicle -> vehicle.getId() != vehicleId).toList();
    }

}

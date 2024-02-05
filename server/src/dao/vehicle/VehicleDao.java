package dao.vehicle;

import models.vehicle.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao implements IVehicleDao {
    private final Connection connection;

    public VehicleDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(long userId) {
        List<Vehicle> vehiclesByUserId = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vehicles WHERE users_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        vehiclesByUserId.add(VehicleHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehiclesByUserId;
    }

    @Override
    public Vehicle get(long vehicleId) {
        Vehicle vehicle = null;
        try {
            String sql = "SELECT * FROM vehicles WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, vehicleId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        vehicle = VehicleHandleDbResponse.handleResponse(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vehicles";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        vehicles.add(VehicleHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicles;
    }

    @Override
    public void save(Vehicle vehicle) {
        // TODO Connect to db and save vehicle
    }

    @Override
    public void update(Vehicle vehicle) {
        // TODO Connect to db and update vehicle

    }

    @Override
    public void delete(long vehicleId) {
        // TODO Connect to db and delete vehicle
    }

}

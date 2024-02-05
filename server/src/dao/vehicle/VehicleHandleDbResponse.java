package dao.vehicle;

import models.vehicle.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VehicleHandleDbResponse {
    public static Vehicle handleResponse(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String brand = resultSet.getString("brand");
        String model = resultSet.getString("model");
        long _userId = resultSet.getLong("users_id");
        Timestamp insertTime = resultSet.getTimestamp("insert_time");

        return new Vehicle(id, _userId, brand, model, insertTime);
    }
}

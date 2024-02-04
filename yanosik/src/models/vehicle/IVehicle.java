package models.vehicle;

import java.sql.Timestamp;

public interface IVehicle {
    // getters
    long getId();
    long getUserId();
    String getBrand();
    String getModel();
    Timestamp getInsertTime();

    // setters
    void setBrand(String brand);
    void setModel(String model);
}

package models.vehicle;

import java.sql.Timestamp;
import java.util.Date;

public class Vehicle implements IVehicle {
    private final long id;
    private final long userId;
    private String brand;
    private String model;
    private final Timestamp insertTime;

    public Vehicle(long id, long userId, String brand, String model) {
        this.id = id;
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.insertTime = new Timestamp(new Date().getTime());
    }

    @Override
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }
    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Timestamp getInsertTime() {
        return insertTime;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}

package models.vehicle;

import java.sql.Timestamp;

public class Vehicle implements IVehicle {
    private final long id;
    private final long userId;
    private String brand;
    private String model;
    private final Timestamp insertTime;

    public Vehicle(long userId, String brand, String model) {
        this.id = -1;
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.insertTime = null;
    }

    public Vehicle(long id, long userId, String brand, String model, Timestamp insertTime) {
        this.id = id;
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.insertTime = insertTime;
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

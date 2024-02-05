package models.insuranceOffer;

import java.sql.Timestamp;

public class InsuranceOffer implements IInsuranceOffer {
    private final long id;
    private final long vehicleId;
    private String insurer;
    private Float price;
    private final Timestamp insertTime;

    public InsuranceOffer(long vehicleId, String insurer, Float price) {
        this.id = -1;
        this.vehicleId = vehicleId;
        this.insurer = insurer;
        this.price = price;
        this.insertTime = null;

    }
    public InsuranceOffer(long id, long vehicleId, String insurer, Float price, Timestamp insertTime) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.insurer = insurer;
        this.price = price;
        this.insertTime = insertTime;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getVehicleId() {
        return vehicleId;
    }

    @Override
    public String getInsurer() {
        return insurer;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public Timestamp getInsertTime() {
        return insertTime;
    }

    @Override
    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    @Override
    public void setPrice(Float price) {
        this.price = price;
    }
}

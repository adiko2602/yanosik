package models.insuranceOffer;

import java.sql.Timestamp;
import java.util.Date;

public class InsuranceOffer implements IInsuranceOffer {
    private final long id;
    private final long vehicleId;
    private String insurer;
    private Float price;
    private final Timestamp insertTime;

    public InsuranceOffer(long id, long vehicleId, String insurer, Float price) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.insurer = insurer;
        this.price = price;
        this.insertTime = new Timestamp(new Date().getTime());
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

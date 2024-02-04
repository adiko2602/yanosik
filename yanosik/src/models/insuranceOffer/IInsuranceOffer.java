package models.insuranceOffer;

import java.sql.Timestamp;

public interface IInsuranceOffer {
    // getters
    long getId();
    long getVehicleId();
    String getInsurer();
    Float getPrice();
    Timestamp getInsertTime();

    // setters
    void setInsurer(String insurer);
    void setPrice(Float price);
}

package dao.insuranceOffer;

import dao.IDao;
import models.insuranceOffer.InsuranceOffer;

import java.util.List;

public interface IInsuranceOfferDao extends IDao<InsuranceOffer> {
    List<InsuranceOffer> getInsuranceOffersByVehicleId(long vehicleId);
}

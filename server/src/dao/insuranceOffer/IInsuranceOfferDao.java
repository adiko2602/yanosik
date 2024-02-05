package dao.insuranceOffer;

import dao.IDao;
import models.insuranceOffer.InsuranceOffer;
import models.vehicle.Vehicle;

import java.util.List;
import java.util.Map;

public interface IInsuranceOfferDao extends IDao<InsuranceOffer> {
    List<InsuranceOffer> getInsuranceOffersByVehicleId(long vehicleId);
    List<InsuranceOffer> getInsuranceOffersByUserId(long userId);
}

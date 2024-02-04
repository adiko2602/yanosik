package dao.insuranceOffer;

import models.insuranceOffer.InsuranceOffer;

import java.util.ArrayList;
import java.util.List;

public class InsuranceOfferDao implements IInsuranceOfferDao {
    private List<InsuranceOffer> insuranceOffers = new ArrayList<>();

    public InsuranceOfferDao() {
        insuranceOffers.add(new InsuranceOffer(1, 1, "AXA", 100.10f));
        insuranceOffers.add(new InsuranceOffer(2, 2, "AXA", 100.10f));
        insuranceOffers.add(new InsuranceOffer(3, 3, "AXA", 100.10f));
        insuranceOffers.add(new InsuranceOffer(4, 1, "Warta", 100.10f));
    }
    @Override
    public List<InsuranceOffer> getInsuranceOffersByVehicleId(long vehicleId) {
        List<InsuranceOffer> insuranceOffersByVehicleId = new ArrayList<>();

        insuranceOffers.forEach(insuranceOffer -> {
            if(insuranceOffer.getVehicleId() == vehicleId) insuranceOffersByVehicleId.add(insuranceOffer);
        });

        return insuranceOffersByVehicleId;
    }

    @Override
    public InsuranceOffer get(long insuranceOfferId) {
        for (InsuranceOffer insuranceOffer : insuranceOffers) {
            if (insuranceOffer.getId() == insuranceOfferId) {
                return insuranceOffer;
            }
        }
        return null;
    }



    @Override
    public List<InsuranceOffer> getAll() {
        return insuranceOffers;
    }

    @Override
    public void save(InsuranceOffer insuranceOffer) {
        insuranceOffers.add(insuranceOffer);
    }

    @Override
    public void update(InsuranceOffer insuranceOffer) {
        insuranceOffers.forEach(i -> {
            if (i.getId() == insuranceOffer.getId()) {
                i.setInsurer(insuranceOffer.getInsurer());
                i.setPrice(insuranceOffer.getPrice());
            }
        });
    }

    @Override
    public void delete(long insuranceOfferId) {
        insuranceOffers = insuranceOffers.stream().filter(insuranceOffer -> insuranceOffer.getId() != insuranceOfferId).toList();
    }

}

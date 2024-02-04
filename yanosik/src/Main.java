import dao.insuranceOffer.InsuranceOfferDao;
import dao.user.UserDao;
import dao.vehicle.VehicleDao;
import models.insuranceOffer.InsuranceOffer;
import models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        VehicleDao vehicleDao = new VehicleDao();
        InsuranceOfferDao insuranceOfferDao = new InsuranceOfferDao();

        List<Vehicle> vehicles = vehicleDao.getVehiclesByUserId(1);
        List<InsuranceOffer> insuranceOffers = new ArrayList<>();

        vehicles.forEach(vehicle ->
            insuranceOffers.addAll(insuranceOfferDao.getInsuranceOffersByVehicleId(vehicle.getId()))
        );

        insuranceOffers.forEach(i -> System.out.println("" + i.getVehicleId() + i.getInsurer()));


    }
}
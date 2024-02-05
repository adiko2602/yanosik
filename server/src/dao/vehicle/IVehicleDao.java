package dao.vehicle;

import dao.IDao;
import models.vehicle.Vehicle;

import java.util.List;

public interface IVehicleDao extends IDao<Vehicle> {
    List<Vehicle> getVehiclesByUserId(long userId);
}

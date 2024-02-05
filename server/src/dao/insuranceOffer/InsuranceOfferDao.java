package dao.insuranceOffer;

import models.insuranceOffer.InsuranceOffer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceOfferDao implements IInsuranceOfferDao {
    private final Connection connection;
    public InsuranceOfferDao(Connection connection) {
       this.connection = connection;
    }

    @Override
    public List<InsuranceOffer> getInsuranceOffersByUserId(long userId) {
        List<InsuranceOffer> insuranceOffersByUserId = new ArrayList<>();
        try {
            String sql =
                    "SELECT *\n" +
                    "FROM insurance_offers\n" +
                    "JOIN vehicles ON insurance_offers.vehicles_id = vehicles.id\n" +
                    "JOIN users ON vehicles.users_id = users.id\n" +
                    "WHERE users.id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        insuranceOffersByUserId.add(InsuranceOfferHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insuranceOffersByUserId;
    }

    @Override
    public List<InsuranceOffer> getInsuranceOffersByVehicleId(long vehicleId) {
        List<InsuranceOffer> insuranceOffersByVehicleId = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vehicles WHERE vehicles_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, vehicleId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        insuranceOffersByVehicleId.add(InsuranceOfferHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insuranceOffersByVehicleId;
    }

    @Override
    public InsuranceOffer get(long insuranceOfferId) {
        InsuranceOffer insuranceOffer = null;
        try {
            String sql = "SELECT * FROM insurance_offers WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, insuranceOfferId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        insuranceOffer = InsuranceOfferHandleDbResponse.handleResponse(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insuranceOffer;
    }

    @Override
    public List<InsuranceOffer> getAll() {
        List<InsuranceOffer> insuranceOffers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM insurance_offers";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        insuranceOffers.add(InsuranceOfferHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insuranceOffers;
    }

    @Override
    public void save(InsuranceOffer insuranceOffer) {
        // TODO Connect to db and save insurance offer
    }

    @Override
    public void update(InsuranceOffer insuranceOffer) {
        // TODO Connect to db and update insurance offer
    }

    @Override
    public void delete(long insuranceOfferId) {
        // TODO Connect to db and delete insurance offer
    }

}

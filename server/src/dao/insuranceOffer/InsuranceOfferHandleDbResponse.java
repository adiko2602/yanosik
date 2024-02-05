package dao.insuranceOffer;

import models.insuranceOffer.InsuranceOffer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsuranceOfferHandleDbResponse {
    public static InsuranceOffer handleResponse(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String insurer = resultSet.getString("insurer");
        float price = resultSet.getFloat("price");
        long _vehicleId = resultSet.getLong("vehicles_id");
        Timestamp insertTime = resultSet.getTimestamp("insert_time");

        return new InsuranceOffer(id, _vehicleId, insurer, price, insertTime);
    }
}

import dao.insuranceOffer.InsuranceOfferDao;
import dao.vehicle.VehicleDao;
import database.DatabaseConnection;
import models.insuranceOffer.InsuranceOffer;
import models.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Connection connection;

        try {
            connection = DatabaseConnection.getConnection();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        VehicleDao vehicleDao = new VehicleDao(connection);
        InsuranceOfferDao insuranceOfferDao = new InsuranceOfferDao(connection);

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server created on port: 1234");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            int userId = -1;
            while ((line = in.readLine()) != null) {
                try {
                    userId = parseInt(line);
                    if(userId != -1) break;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    out.println("Number Format Exception occur. Check if provided number is number.");
                    return;
                }
            }

            List<Vehicle> vehicleList = vehicleDao.getVehiclesByUserId(userId);
            List<InsuranceOffer> insuranceOfferList = insuranceOfferDao.getInsuranceOffersByUserId(userId);

            Map<Vehicle, List<InsuranceOffer>> insuranceOffersForVehicleList = new HashMap<>();

            vehicleList.forEach(vehicle -> {
                List<InsuranceOffer> insuranceOffersForVehicle = insuranceOfferList.stream()
                        .filter(insuranceOffer -> insuranceOffer.getVehicleId() == vehicle.getId())
                        .toList();

                insuranceOffersForVehicleList.put(vehicle, insuranceOffersForVehicle);
            });

            StringBuilder response = new StringBuilder();
            for (var entry : insuranceOffersForVehicleList.entrySet()) {
                Vehicle vehicle = entry.getKey();
                List<InsuranceOffer> insuranceOffers = entry.getValue();

                response.append("\n")
                        .append(vehicle.getBrand())
                        .append(" ")
                        .append(vehicle.getModel())
                        .append("\n");

                for(InsuranceOffer insuranceOffer : insuranceOffers) {
                    response.append("Insurer: ")
                            .append(insuranceOffer.getInsurer())
                            .append("\n").append("Price: ")
                            .append(insuranceOffer.getPrice())
                            .append("\n");
                }
            }

            out.println(response);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
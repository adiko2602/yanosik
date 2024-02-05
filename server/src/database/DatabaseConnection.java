package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnection {

        // This database can be stored as text.
        private static final String URL = "jdbc:postgresql://ep-hidden-art-98123329.eu-central-1.aws.neon.tech/yanosik?user=adi2602&password=M4kORD9WguiI&sslmode=require";
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL);
        }
    }

package javalasttermproject.javalasttermproject.Model;

import java.sql.*;

public class Database {
    public static Connection connectDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/oop_schema", "root", "viethung2909");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

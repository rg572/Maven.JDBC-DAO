package models;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_lab";
    public static final String USER = "root";
    public static final String PASS = "password";

    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // Test main
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}

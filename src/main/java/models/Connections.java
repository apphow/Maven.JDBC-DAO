package models;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class Connections {

    //Dolio's video & dev.mysql.com
    public static final String URL = "jdbc:mysql://localhost:3306/RDBMS?ServerTimezone= UTC";
    public static final String USER = "root";
    public static final String PASS = "spaz3286";
    static Logger demoLog = Logger.getLogger("demoJDBC");

    public static void main(String[] agrs) throws SQLException {
        Car car = new Car();
        demoLog.log(Level.INFO, "SomeStuff");
        System.out.println(("I hope this works"));
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            System.out.println("connected");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");// handle the error
            return;
        }
        System.out.println("MySQL JDBC Driver Registered");
        Connection connection = null;
        try {
            connection = getConnection(URL, USER, PASS);
            System.out.println("SQL Connection to database established!");

            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("SELECT * FROM car");
            System.out.println("Contents of the table: ");
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Make: " + rs.getString("make"));
                System.out.println("Model: " + rs.getString("model"));
                System.out.println("Color:" + rs.getString("color"));
            }
            System.out.println();
            rs.beforeFirst();
            while(rs.next()) {
                String newColor = rs.getString("color") + " , choice";
                rs.updateString("color", newColor);
                rs.updateRow();
                System.out.println();
            }
            return;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection failed!");
            return;
        }
    }
}




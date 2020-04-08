package models;

import daos.CarDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connections {

    //Dolio's video & dev.mysql.com
    public static final String URL = "jdbc:mysql://localhost:3306/RDBMS?ServerTimezone= UTC";
    public static final String USER = "root";
    public static final String PASS = "spaz3286";
    static Logger demoLog = Logger.getLogger("demoJDBC");

    public static Connection getConnection() {
        try {

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] agrs) throws SQLException {
        CarDao carDao = new CarDao();
        demoLog.log(Level. INFO, "SomeStuff");
        System.out.println(("I hope this works"));
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            System.out.println("connected");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch(ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");// handle the error
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered");
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("SQL Connection to database established!");
            Statement stmt = connection.createStatement();

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection failed!");
            return;
        }
    }
}

package daos;

import models.Car;

import java.sql.*;

public abstract class CarDao implements DAO {
    Connection connection;

    Car car = new Car();
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private int Vin;

    public CarDao(int id, String make, String model, int year, String color, int vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.Vin = vin;
    }

    public CarDao() {

    }

    public int getId() {
        return id;
    }
    public int findCarById() {
        return getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public boolean updateCar(Car cars) throws SQLException {
        //https://dzone.com/articles/building-simple-data-access-layer-using-jdbc
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET id=?, make=?, model=? , year=?, color=?WHERE id=?");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getColor());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return Vin;
    }

    public void setVin(int vin) {
        this.Vin = vin;
    }
}
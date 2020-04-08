package daos;

import models.Car;

import java.util.List;

interface DAO {
    public Car findCarById(int id);
    public List findAll();
    public Car update(Car car);
    public Car create(Car dar);
    public void delete (int id);
}
package sda.project.admin.service;

import sda.project.admin.model.Car;


import java.util.List;

public interface CarService {

    List<Car> getAllCar();

    void saveCar(Car car);

    Car getCarById(long id);

    void deleteCarById(long id);

}

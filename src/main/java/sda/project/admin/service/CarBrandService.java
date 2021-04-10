package sda.project.admin.service;

import sda.project.admin.model.CarBrand;

import java.util.List;

public interface CarBrandService {

    List<CarBrand> getAllCarBrand();

    void saveCarBrand(CarBrand carBrand);

    CarBrand getCarBrandById(long id);

    void deleteCarBrandById(long id);
}

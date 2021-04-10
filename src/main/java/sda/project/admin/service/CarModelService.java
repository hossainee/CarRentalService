package sda.project.admin.service;


import sda.project.admin.model.CarModel;

import java.util.List;

public interface CarModelService {

    List<CarModel> getAllCarModel();

    void saveCarModel(CarModel carModel);

    CarModel getCarModelById(long id);

    void deleteCarModelById(long id);

}

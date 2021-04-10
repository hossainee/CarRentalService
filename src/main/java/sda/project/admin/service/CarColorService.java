package sda.project.admin.service;


import sda.project.admin.model.CarColor;

import java.util.List;

public interface CarColorService {

    List<CarColor> getAllCarColor();

    void saveCarColor(CarColor carColor);

    CarColor getCarColorById(long id);

    void deleteCarColorById(long id);

}

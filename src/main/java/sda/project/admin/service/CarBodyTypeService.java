package sda.project.admin.service;


import sda.project.admin.model.CarBodyType;

import java.util.List;

public interface CarBodyTypeService {

    List<CarBodyType> getAllCarBodyType();

    void saveCarBodyType(CarBodyType carBodyType);

    CarBodyType getCarBodyTypeById(long id);

    void deleteCarBodyTypeById(long id);

}

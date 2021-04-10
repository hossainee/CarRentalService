package sda.project.admin.service;

import sda.project.admin.model.CarStatus;

import java.util.List;

public interface CarStatusService {

    List<CarStatus> getAllCarStatus();

    void saveCarStatus(CarStatus carStatus);

    CarStatus getCarStatusById(long id);

    void deleteCarStatusById(long id);
}

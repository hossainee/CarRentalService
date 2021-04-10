package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.CarStatus;
import sda.project.admin.repository.CarStatusRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CarStatusServiceImpl implements CarStatusService {

    @Autowired
    private CarStatusRepository carStatusRepository;

    @Override
    public List<CarStatus> getAllCarStatus() {
        return carStatusRepository.findAll();
    }

    @Override
    public void saveCarStatus(CarStatus carStatus) {
        this.carStatusRepository.save(carStatus);
    }

    @Override
    public CarStatus getCarStatusById(long id) {
        Optional< CarStatus > optional = carStatusRepository.findById(id);
        CarStatus carStatus = null;
        if (optional.isPresent()) {
            carStatus = optional.get();
        } else {
            throw new RuntimeException(" Car Status not found for id :: " + id);
        }
        return carStatus;
    }

    @Override
    public void deleteCarStatusById(long id) {
        this.carStatusRepository.deleteById(id);
    }

}

package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.CarColor;
import sda.project.admin.repository.CarColorRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CarColorServiceImpl implements CarColorService {

    @Autowired
    private CarColorRepository carColorRepository;

    @Override
    public List<CarColor> getAllCarColor() {
        return carColorRepository.findAll();
    }

    @Override
    public void saveCarColor(CarColor carColor) {
        this.carColorRepository.save(carColor);
    }

    @Override
    public CarColor getCarColorById(long id) {
        Optional< CarColor > optional = carColorRepository.findById(id);
        CarColor carColor = null;
        if (optional.isPresent()) {
            carColor = optional.get();
        } else {
            throw new RuntimeException(" Car Color not found for id :: " + id);
        }
        return carColor;
    }

    @Override
    public void deleteCarColorById(long id) {
        this.carColorRepository.deleteById(id);
    }

}

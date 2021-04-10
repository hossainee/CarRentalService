package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.CarModel;
import sda.project.admin.repository.CarModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public List<CarModel> getAllCarModel() {
        return carModelRepository.findAll();
    }

    @Override
    public void saveCarModel(CarModel carModel) {
        this.carModelRepository.save(carModel);
    }

    @Override
    public CarModel getCarModelById(long id) {
        Optional< CarModel > optional = carModelRepository.findById(id);
        CarModel carModel = null;
        if (optional.isPresent()) {
            carModel = optional.get();
        } else {
            throw new RuntimeException(" Car Model not found for id :: " + id);
        }
        return carModel;
    }

    @Override
    public void deleteCarModelById(long id) {
        this.carModelRepository.deleteById(id);
    }

}

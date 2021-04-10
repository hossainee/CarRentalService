package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.CarBrand;
import sda.project.admin.repository.CarBrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Override
    public List<CarBrand> getAllCarBrand() {
        return carBrandRepository.findAll();
    }

    @Override
    public void saveCarBrand(CarBrand carBrand) {
        this.carBrandRepository.save(carBrand);
    }

    @Override
    public CarBrand getCarBrandById(long id) {
        Optional< CarBrand > optional = carBrandRepository.findById(id);
        CarBrand carBrand = null;
        if (optional.isPresent()) {
            carBrand = optional.get();
        } else {
            throw new RuntimeException(" Car Brand not found for id :: " + id);
        }
        return carBrand;
    }

    @Override
    public void deleteCarBrandById(long id) {
        this.carBrandRepository.deleteById(id);
    }

}

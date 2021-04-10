package sda.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.project.admin.model.CarBodyType;
import sda.project.admin.repository.CarBodyTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarBodyTypeServiceImpl implements CarBodyTypeService {

    @Autowired
    private CarBodyTypeRepository carBodyTypeRepository;

    @Override
    public List<CarBodyType> getAllCarBodyType() {
        return carBodyTypeRepository.findAll();
    }

    @Override
    public void saveCarBodyType(CarBodyType carBodyType) {
        this.carBodyTypeRepository.save(carBodyType);
    }

    @Override
    public CarBodyType getCarBodyTypeById(long id) {
        Optional<CarBodyType> optional = carBodyTypeRepository.findById(id);
        CarBodyType carBodyType = null;
        if (optional.isPresent()) {
            carBodyType = optional.get();
        } else {
            throw new RuntimeException(" Car Body Type not found for id :: " + id);
        }
        return carBodyType;
    }

    @Override
    public void deleteCarBodyTypeById(long id) {
        this.carBodyTypeRepository.deleteById(id);
    }

}

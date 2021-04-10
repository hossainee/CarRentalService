package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sda.project.admin.dto.AvailableCar;
import sda.project.admin.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select new sda.project.admin.dto.AvailableCar(a.carId,b.branchName,a.carCode,c.brandName,d.modelName,e.bodyType,a.year,f.colorName,a.perDayRent) from Car a,Branch b,CarBrand c,CarModel d, CarBodyType e,CarColor f where a.branch.branchId=b.branchId and a.carBrand.brandId=c.brandId and a.carModel.modelId=d.modelId and a.carBodyType.bodyTypeId=e.bodyTypeId and a.carColor.colorId=f.colorId and a.carStatus.statusId=1")
    public List<AvailableCar> getAvailableCar();

}

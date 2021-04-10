package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.CarModel;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}

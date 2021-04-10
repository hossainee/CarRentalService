package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.CarBodyType;

@Repository
public interface CarBodyTypeRepository extends JpaRepository<CarBodyType, Long> {
}

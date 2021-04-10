package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.CarColor;

@Repository
public interface CarColorRepository  extends JpaRepository<CarColor, Long> {
}

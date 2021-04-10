package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.CarStatus;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {
}

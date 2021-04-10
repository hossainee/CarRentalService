package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import sda.project.admin.model.CarBrand;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}

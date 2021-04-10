package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

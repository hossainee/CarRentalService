package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.project.admin.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

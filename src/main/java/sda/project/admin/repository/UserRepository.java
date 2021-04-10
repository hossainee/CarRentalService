package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.project.admin.model.Customer;

public interface UserRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u FROM Customer u WHERE u.email = ?1")
    public Customer findByEmail(String email);
}

package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.project.admin.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}

package sda.project.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sda.project.admin.model.ReservationInfo;

public interface ReservationRepositoryInfo  extends JpaRepository<ReservationInfo, Long> {

}

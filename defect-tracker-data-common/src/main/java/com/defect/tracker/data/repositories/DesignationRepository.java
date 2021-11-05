package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.defect.tracker.data.entities.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {

}

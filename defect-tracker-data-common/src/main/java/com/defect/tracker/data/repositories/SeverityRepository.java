package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Severity;

@Repository
public interface SeverityRepository extends JpaRepository<Severity, Long> {

}

package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.defect.tracker.data.entities.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

}

package com.defect.tracker.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.tracker.data.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmail(String email);

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findByDesignationId(Long desId);

	boolean existsByDesignationId(Long id);

	boolean existsByfirstName(String firstName);

	Optional<Employee> findByEmail(String email);

}

package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;

import com.defect.tracker.data.entities.Employee;

public interface EmployeeService {
	public void createEmployee(Employee employee);

	public boolean isEmailAlreadyExist(String email);

	public List<Employee> findByFirstName(String firstName);

	public Optional<Employee> findById(Long id);

	public boolean idExist(Long id);

	public List<Employee> findByDes(Long id);

	public boolean isEmployeeExists(Long id);

	public List<Employee> getAll();

	public void deleteEmployee(Long id);

	public boolean isEmployeeAlreadyExists(Long id);

	public boolean ExistByFirstName(String firstName);

}

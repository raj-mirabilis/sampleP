package com.defect.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.ProjectEmp_Module_ResponseDto;
import com.defect.tracker.data.dto.ProjectEmp_ResponseDto;
import com.defect.tracker.data.dto.Project_EmpDto;
import com.defect.tracker.data.entities.ProjectEmp;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.ProjectEmployeeAllocationRepository;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.ProjectEmployeeAllocationService;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class ProjectEmployeeAllocationController {

	@Autowired
	ProjectEmployeeAllocationRepository projectemployeeallocationRepository;

	@Autowired
	ProjectEmployeeAllocationService projectemployeeallocationService;

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> addPojectAllocation(@RequestBody Project_EmpDto project_EmpDto) {

		if (!employeeService.idExist(project_EmpDto.getEmployeeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPTY_PROJECT_ALLOCATION,
					validationFailureStatusCodes.getProjectAllocationFailed()), HttpStatus.BAD_REQUEST);
		}
		ProjectEmp projectEmp = mapper.map(project_EmpDto, ProjectEmp.class);
		projectemployeeallocationService.addProjectAllocation(projectEmp);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATED, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> getAllProjectAllocation() {
		if (projectemployeeallocationService.getAll().isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_NOT_ALLOCATED,
					validationFailureStatusCodes.getProjectAllocationNotExist()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(
				mapper.map(projectemployeeallocationService.getAll(), ProjectEmp_ResponseDto.class), HttpStatus.OK);
	}

	@DeleteMapping(value = EndpointURI.DEALLOCATE_PROJECT)
	public ResponseEntity<Object> deAllocateProject(@PathVariable Long id) {
		if (!projectemployeeallocationService.existsByid(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_NOT_ALLOCATED,
					validationFailureStatusCodes.getProjectAllocationNotExist()), HttpStatus.BAD_REQUEST);
		}
		projectemployeeallocationService.deAllocateProject(id);
		return new ResponseEntity<Object>(Constants.PROJECT_DEALLOCATED, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.GET_EMPLOYEE_BY_MODULE)
	public ResponseEntity<Object> getEmployeeByModule(@PathVariable Long id) {
		if (!projectemployeeallocationService.existsByModuleId(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMPTY,
					validationFailureStatusCodes.getProjectemployeeNotExists()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(mapper.map(projectemployeeallocationService.getEmployeeByModule(id),
				ProjectEmp_Module_ResponseDto.class), HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.UPDATE_PROJECT_EMPLOYEE_ALLOCATION)
	public ResponseEntity<Object> updateProjectAllocation(@RequestBody Project_EmpDto project_EmpDto) {
		if (!projectemployeeallocationService.existsByid(project_EmpDto.getId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.PROJECT_EMPLOYEE_NOT_AVAILABLE,
							validationFailureStatusCodes.getProjectemployeeNotExists()),
					HttpStatus.BAD_REQUEST);
		}

		ProjectEmp projectEmp = mapper.map(project_EmpDto, ProjectEmp.class);
		projectemployeeallocationService.update(projectEmp);
		return new ResponseEntity<Object>(Constants.PROJECT_EMP_UPDATE, HttpStatus.OK);

	}
}

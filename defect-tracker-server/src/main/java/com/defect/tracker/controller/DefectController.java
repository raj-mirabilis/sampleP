package com.defect.tracker.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.dto.DefectResponseDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.entities.DefectStatus;
import com.defect.tracker.data.entities.ProjectEmp;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.DefectStatusRepository;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DefectService;
import com.defect.tracker.services.DefectServiceImpl;
import com.defect.tracker.services.DefectStatusService;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.MailServiceImpl;
import com.defect.tracker.services.ProjectEmployeeAllocationService;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectController {
	@Autowired
	ProjectService projectService;

	@Autowired
	DefectService defectService;

	@Autowired
	MailServiceImpl mailServiceImpl;

	@Autowired
	DefectServiceImpl defectServiceImpl;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectEmployeeAllocationService projectEmployeeAllocationService;

	@Autowired
	DefectStatusService defectStatusService;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@Autowired
	private Mapper mapper;

	@Autowired
	DefectStatusRepository defectStatusRepository;

	@GetMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> findById() {
		if (defectService.getAllDefect().isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_DOES_NOT_EXISTS,
					validationFailureStatusCodes.getDefectNotExist()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(mapper.map(defectService.getAllDefect(), DefectResponseDto.class),
				HttpStatus.OK);
	}

	@PostMapping(value = EndpointURI.DEFECT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Object> addDefect(@RequestPart String defect1, @RequestPart("file") MultipartFile file)
			throws IOException {
		java.sql.Date date = new Date(System.currentTimeMillis());
		DefectDto defectDto = defectService.getJson(defect1, file);

		defectDto.setTimeStamp(date);
		defectDto.setDefectStatusId(6);
		List<String> mails = new ArrayList<>();
		List<String> names = new ArrayList<>();
		String module = defectService.findById(defectDto.getModuleId()).getModule().getModuleName();
		String assignedEmployee = employeeService.findById(defectDto.getEmployeeId()).get().getFirstName();
		String status = "New";
		List<ProjectEmp> projectList = projectEmployeeAllocationService.findbyModule(defectDto.getModuleId());
		for (ProjectEmp projectEmp : projectList) {
			names.add(projectEmp.getEmployee().getFirstName());
		}
		for (ProjectEmp projectEmp : projectList) {
			mails.add(projectEmp.getEmployee().getEmail());
		}
		mailServiceImpl.sendListEmailNew(mails, module, names, assignedEmployee, status);
		defectDto.setFile(defectServiceImpl.fileUpload(file));
		Defect defect = mapper.map(defectDto, Defect.class);
		defectService.addDefect(defect);
		return new ResponseEntity<Object>(Constants.DEFECT_ADD_SUCCESS, HttpStatus.OK);

	}

	@PutMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> updateDefect(@Valid @RequestBody DefectDto defectDto) {
		java.sql.Date date = new Date(System.currentTimeMillis());
		defectDto.setTimeStamp(date);
		if (!defectService.isDefectExists(defectDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS,
					validationFailureStatusCodes.getDefectNotExist()), HttpStatus.BAD_REQUEST);
		}
		if (defectStatusService.getDefectStatusById(defectDto.getDefectStatusId()).get().getDefectStatusName()
				.equalsIgnoreCase("Open")
				|| defectStatusService.getDefectStatusById(defectDto.getDefectStatusId()).get().getDefectStatusName()
						.equalsIgnoreCase("Fixed")
				|| defectStatusService.getDefectStatusById(defectDto.getDefectStatusId()).get().getDefectStatusName()
						.equalsIgnoreCase("Reject")) {
			defectServiceImpl.dataCall(defectDto);
			Defect defect = mapper.map(defectDto, Defect.class);
			defectService.addDefect(defect);
			return new ResponseEntity<Object>(Constants.UPDATE_DEFECT, HttpStatus.OK);
		}
		if (defectStatusService.getDefectStatusById(defectDto.getDefectStatusId()).get().getDefectStatusName()
				.equalsIgnoreCase("Closed")
				|| defectStatusService.getDefectStatusById(defectDto.getDefectStatusId()).get().getDefectStatusName()
						.equalsIgnoreCase("Reopen")) {
			defectServiceImpl.dataListCall(defectDto);
			Defect defect = mapper.map(defectDto, Defect.class);
			defectService.addDefect(defect);
			return new ResponseEntity<Object>(Constants.UPDATE_DEFECT, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_NOT_EXISTS,
				validationFailureStatusCodes.getDefectStatusNotExist()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.DEFECT_GET_BY_ID)
	public ResponseEntity<Object> getDefectById(@PathVariable Long id) {
		if (!defectService.isDefectExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectNotExist()), HttpStatus.BAD_REQUEST);
		}
		DefectResponseDto defectDto = mapper.map(defectService.findById(id), DefectResponseDto.class);
		return new ResponseEntity<Object>(defectDto, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.UPDATE_DEFECT_STATUS)
	public ResponseEntity<Object> updateDefectStatus(@PathVariable Long id, @PathVariable Long status) {
		if (defectService.isDefectExists(id)) {
			if (!defectStatusRepository.existsById(status)) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_NOT_EXISTS,
						validationFailureStatusCodes.getDefectStatusNotExist()), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS,
					validationFailureStatusCodes.getDefectNotExist()), HttpStatus.BAD_REQUEST);
		}

		Defect defect = defectService.findById(id);
		DefectStatus ds = defectStatusRepository.getOne(status);
		defect.setDefectStatus(ds);
		defectService.addDefect(defect);

		return new ResponseEntity<Object>(Constants.UPDATE_DEFECT, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.GET_DEFECT_BY_ASSIGN_TO_ID)
	public ResponseEntity<Object> getDefByAssignId(@PathVariable Long id) {
		if (!employeeService.isEmployeeExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_EXISTS,
					validationFailureStatusCodes.getEmployeeNotExist()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(defectService.getByEmpIdAndStatus(id), HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.GET_ALL_DEFECT_BY_PROJECT_ID)
	public ResponseEntity<Object> getAllDefectByProId(@PathVariable Long id) {
		if (!projectService.existProject(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_DOES_NOT_EXISTS,
					validationFailureStatusCodes.getProjectNotExist()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(defectService.getAllDefectByProId(id), HttpStatus.OK);
	}
}

package com.defect.tracker.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.dto.Employee_login_ResponseDto;
import com.defect.tracker.data.dto.LoginDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.Login;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.LoginService;
import com.defect.tracker.services.LoginServiceImpl;
import com.defect.tracker.services.MailServiceImpl;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class EmployeeController {
	private static String UPLOADED_FOLDER = "D://DefectNew/defect-tracker-back-end/defect-tracker-server/src/main/resources/";
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	EmployeeService employeeService;

	@Autowired
	MailServiceImpl mailServiceImpl;

	@Autowired
	LoginService loginService;

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee_login_ResponseDto employee_login_ResponseDto,
			HttpServletRequest request) {
		if (employeeService.isEmailAlreadyExist(employee_login_ResponseDto.getEmail())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMAIL_EXISTS,
					validationFailureStatusCodes.getEmailAlreadyExist()), HttpStatus.BAD_REQUEST);
		}
		Employee employee = mapper.map(employee_login_ResponseDto, Employee.class);
		java.sql.Date date = new Date(System.currentTimeMillis());
		employee.setTimeStamp(date);
		employee.setVerification("Not-Verified");
		employee.setToken(loginServiceImpl.generateToken());
		employeeService.createEmployee(employee);

		String link = loginServiceImpl.getSiteURL(request) + "/api/v1/email-verification/email/" + employee.getEmail()
				+ "/token/" + employee.getToken();
		mailServiceImpl.sendVerifyEmail(employee.getEmail(), link);
		LoginDto loginDto = mapper.map(employee_login_ResponseDto, LoginDto.class);
		loginDto.setEmployeeId(employee.getId());
		String encryptedPassword = passwordEncoder.encode(employee_login_ResponseDto.getPassword());
		loginDto.setPassword(encryptedPassword);
		loginDto.setStatus("Inactive");
		Login login = mapper.map(loginDto, Login.class);

		loginService.create(login);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_ADD_SUCCESS + link, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.GET_EMPLOYEE_BY_NAME)
	public ResponseEntity<Object> findEmployeeByName(@PathVariable String firstName) {
		if (!employeeService.ExistByFirstName(firstName)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_EXISTS,
					validationFailureStatusCodes.getEmployeeNotExist()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(employeeService.findByFirstName(firstName), HttpStatus.OK);

	}

	@GetMapping(value = EndpointURI.ACT_EMPLOYEE)
	public ResponseEntity<Object> findEmployeeById(@PathVariable Long id) {
		if (!employeeService.idExist(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_EXISTS,
					validationFailureStatusCodes.getEmployeeNotExist()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(employeeService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> getAllEmp() {
		if (employeeService.getAll().isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMPTY,
					validationFailureStatusCodes.getEmployeeNotFound()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(employeeService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = EndpointURI.ACT_EMPLOYEE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		if (!employeeService.isEmployeeAlreadyExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_EXISTS,
					validationFailureStatusCodes.getEmployeeNotExist()), HttpStatus.BAD_REQUEST);
		}
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_DELETE_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.GET_EMPLOYEE_BY_DESIGNATION)
	public ResponseEntity<Object> findEmployeeByDesignation(@PathVariable Long designationId) {
		if (!employeeService.isEmployeeExists(designationId)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMPTY,
					validationFailureStatusCodes.getEmployeeNotFound()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(mapper.map(employeeService.findByDes(designationId), EmployeeDto.class),
				HttpStatus.OK);

	}

	@PutMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> UpdateEmployee(@RequestBody EmployeeDto employeeDto) {
		if (employeeService.isEmailAlreadyExist(employeeDto.getEmail())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMAIL_EXISTS,
					validationFailureStatusCodes.getEmailAlreadyExist()), HttpStatus.BAD_REQUEST);
		}
		java.sql.Date date = new Date(System.currentTimeMillis());
		employeeDto.setTimeStamp(date);
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeService.createEmployee(employee);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_UPDATE_SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping(value = EndpointURI.EMPLOYEE_PHOTO)
	public ResponseEntity<Object> DeleteEmployeePhotoById(@PathVariable Long id) {

		Employee employee = employeeService.findById(id).get();
		EmployeeDto employeedto = mapper.map(employee, EmployeeDto.class);
		employeedto.setImage(null);
		employee = mapper.map(employeedto, Employee.class);
		employeeService.createEmployee(employee);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_PHOTO_DELETE_SUCCESS, HttpStatus.OK);

	}

	@PostMapping(value = EndpointURI.EMPLOYEE_PHOTO)
	public ResponseEntity<Object> AddEmployeePhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {

		if (file.isEmpty()) {
			return new ResponseEntity<Object>(ValidationConstance.EMPLOYEE_PHOTO_EMPTY, HttpStatus.BAD_REQUEST);

		}

		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);

		Path path1 = Paths.get(file.getOriginalFilename());
		Employee employee = employeeService.findById(id).get();
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
		employeeDto.setImage(path1.toString());
		employee = mapper.map(employeeDto, Employee.class);
		employeeService.createEmployee(employee);

		return new ResponseEntity<Object>(Constants.ADD_EMPLOYEE_PHOTO_SUCCESS, HttpStatus.OK);

	}

	@PutMapping(value = EndpointURI.EMPLOYEE_PHOTO)
	public ResponseEntity<Object> updateEmployeePhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {

		if (!employeeService.isEmployeeAlreadyExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_EXISTS,
					validationFailureStatusCodes.getEmployeeNotExist()), HttpStatus.BAD_REQUEST);
		}

		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);

		Path path1 = Paths.get(file.getOriginalFilename());
		Employee employee = employeeService.findById(id).get();
		EmployeeDto employeedto = mapper.map(employee, EmployeeDto.class);
		employeedto.setImage(path1.toString());
		employee = mapper.map(employeedto, Employee.class);
		employeeService.createEmployee(employee);

		return new ResponseEntity<Object>(Constants.EMPLOYEE_PHOTO_UPDATE_SUCCESS, HttpStatus.OK);

	}

}
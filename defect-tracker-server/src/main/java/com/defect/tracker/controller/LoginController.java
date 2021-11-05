package com.defect.tracker.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.LoginResDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.Login;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.EmployeeRepository;
import com.defect.tracker.data.repositories.LoginRepository;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.LoginService;
import com.defect.tracker.services.LoginServiceImpl;
import com.defect.tracker.services.MailServiceImpl;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	MailServiceImpl mailServiceImpl;

	@Autowired
	LoginServiceImpl loginServiceImpl;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@Autowired
	private Mapper mapper;

	@PutMapping(value = EndpointURI.UPDATE_EMPLOYEE_STATUS)
	public ResponseEntity<Object> updateEmployeeStatus(@PathVariable String email, @PathVariable String status) {

		if (!loginService.isEmailAlreadyExist(email)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMAIL_NOT_EXISTS,
					validationFailureStatusCodes.getEmailNotExist()), HttpStatus.BAD_REQUEST);
		}
		String employee = loginRepository.findByEmail(email).get().getUserName();
		mailServiceImpl.sendApprovalEmail(email, employee, status);
		loginService.updateEmployeeStatus(email, status);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_STATUS_UPDATED, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.LOGINSTATUS)
	public List<LoginResDto> GetEmpId(@RequestParam String status) {
		return mapper.map(loginService.getLoginByStatus(status), LoginResDto.class);
	}

	@GetMapping(value = EndpointURI.LOGIN)
	public ResponseEntity<Object> login(@RequestParam String userName1, String password2, String email) {

		String userName = loginService.getUserName(email);
		String password = loginService.getUserPassword(email);

		if (userName1.equals(userName) && passwordEncoder.matches(password2, password)) {
			return new ResponseEntity<Object>(Constants.LOGIN_SUCCESS, HttpStatus.OK);

		}

		else if (!userName1.equals(userName) && passwordEncoder.matches(password2, password)) {
			return new ResponseEntity<Object>(Constants.WRONG_USER_NAME, HttpStatus.BAD_REQUEST);
		}

		else if (userName1.equals(userName) && !passwordEncoder.matches(password2, password)) {
			return new ResponseEntity<Object>(Constants.WRONG_PASSWORD, HttpStatus.BAD_REQUEST);
		}

		else if (userName1.isBlank() || (password2.isBlank())) {
			return new ResponseEntity<Object>(Constants.USER_NAME_OR_PASSWORD_EMPTY, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(Constants.LOGIN_FAILED, HttpStatus.BAD_REQUEST);

	}

	@PostMapping(value = EndpointURI.FORGOT_PASSWORD)
	public ResponseEntity<Object> forgotPassword(@PathVariable String email) {
		if (!loginRepository.existsByEmail(email)) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.INVALID_EMAIL,
					validationFailureStatusCodes.getEmailInvalid()), HttpStatus.BAD_REQUEST);
		}
		String response = loginService.forgotPassword(email);
		return new ResponseEntity<Object>(Constants.SENT_SUCCESS + "\n" + response, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.RESET_PASSWORD)
	public ResponseEntity<Object> resetPassword(@PathVariable String token, @PathVariable String password) {
		Optional<Login> loginOptional = Optional.ofNullable(loginRepository.findByToken(token));
		if (!loginOptional.isPresent()) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.INVALID_TOKEN,
					validationFailureStatusCodes.getTokenInvalid()), HttpStatus.BAD_REQUEST);
		}
		LocalDateTime tokenCreationDate = loginOptional.get().getTokenCreationDate();
		if (loginServiceImpl.isTokenExpired(tokenCreationDate)) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.TOKEN_EXPIRED,
					validationFailureStatusCodes.getTokenExpired()), HttpStatus.BAD_REQUEST);

		}
		String encryptedPassword = passwordEncoder.encode(password);
		loginService.resetPassword(token, encryptedPassword);
		return new ResponseEntity<Object>(Constants.CHANGED_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.EMAIL_VERIFICATION)
	public ResponseEntity<Object> emailVerification(@PathVariable String token, @PathVariable String email) {
		Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
		Employee employee = employeeOptional.get();
		if (!employeeRepository.existsByEmail(email)) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.INVALID_EMAIL,
					validationFailureStatusCodes.getEmailInvalid()), HttpStatus.BAD_REQUEST);
		}
		if (!employee.getToken().equals(token)) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.INVALID_TOKEN,
					validationFailureStatusCodes.getTokenInvalid()), HttpStatus.BAD_REQUEST);
		}
		loginService.emailVerification(token, email);
		return new ResponseEntity<Object>(Constants.VERIFIED, HttpStatus.OK);
	}
}

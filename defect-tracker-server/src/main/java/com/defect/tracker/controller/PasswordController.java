package com.defect.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.PasswordService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class PasswordController {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	PasswordService passwordService;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@PutMapping(value = EndpointURI.PASSWORD)
	public ResponseEntity<Object> changePassword(@RequestParam String oldPassword, String newPassword, String email) {
		String password = passwordService.getPassword(email);
		if (bCryptPasswordEncoder.matches(oldPassword, password)) {
			String code = bCryptPasswordEncoder.encode(newPassword);
			passwordService.changePassword(code, email);
			return new ResponseEntity<Object>(Constants.PASSWORD_CHANGED_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.PASSWORD_DO_NOT_MATCH,
				validationFailureStatusCodes.getPasswordNotMatch()), HttpStatus.BAD_REQUEST);
	}
}

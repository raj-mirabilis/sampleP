package com.defect.tracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DesignationService;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DesignationController {
	@Autowired
	private DesignationService designationService;
	
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	
	@GetMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> getAllDesignation(){
		if (designationService.getAlldesignation().isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_EXIST,
					validationFailureStatusCodes.getDesignationNotExist()),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(designationService.getAlldesignation(),HttpStatus.OK);
	}
}

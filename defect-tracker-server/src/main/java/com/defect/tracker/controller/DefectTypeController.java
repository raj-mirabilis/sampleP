package com.defect.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.DefectTypeDto;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DefectTypeService;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectTypeController {
	@Autowired
	DefectTypeService defectTypeService;
	
	@Autowired ValidationFailureStatusCodes validationFailureStatusCodes;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(value=EndpointURI.DEFECTTYPE)
	public ResponseEntity<Object>getAllDefectType(){
		if (defectTypeService.getAllDefectType().isEmpty()) {
			return new ResponseEntity<> (new ValidationFailureResponse(ValidationConstance.DEFECT_EMPTY,
					validationFailureStatusCodes.getDefectTypeNotFound()),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(mapper.map(defectTypeService.getAllDefectType(), DefectTypeDto.class),HttpStatus.OK);
	}
	

}


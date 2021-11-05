package com.defect.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.entities.DefectStatus;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DefectStatusService;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectStatusController {

	@Autowired
	private DefectStatusService defectStatusService;

	@Autowired
	Mapper mapper;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;

	@GetMapping(value = EndpointURI.DEFECTSTATUS)
	public ResponseEntity<Object> getAllDefectStatus() {
		if (defectStatusService.getAllDefectStatus().isEmpty()) {
			return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_EMPTY,
					validationFailureStatusCodes.getDefectNotExist()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(mapper.map(defectStatusService.getAllDefectStatus(), DefectStatus.class),
				HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.DEFECT_STATUS)
	public ResponseEntity<Object> getDefectStatusById(@PathVariable Long id) {
		List<DefectStatus> defectStatusList = new ArrayList<>();
		if (!defectStatusService.getDefectStatusById(id).isEmpty()) {
			if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName().equalsIgnoreCase("Open")) {
				DefectStatus defectStatus1 = defectStatusService.getDefectStatusByName("Fixed");
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reject");
				defectStatusList.add(defectStatus1);
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			} else if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName()
					.equalsIgnoreCase("New")) {
				DefectStatus defectStatus1 = defectStatusService.getDefectStatusByName("Open");
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reject");
				defectStatusList.add(defectStatus1);
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			} else if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName()
					.equalsIgnoreCase("Reopen")) {
				DefectStatus defectStatus1 = defectStatusService.getDefectStatusByName("Open");
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reject");
				defectStatusList.add(defectStatus1);
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			} else if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName()
					.equalsIgnoreCase("Fixed")) {
				DefectStatus defectStatus1 = defectStatusService.getDefectStatusByName("Closed");
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reopen");
				defectStatusList.add(defectStatus1);
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			} else if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName()
					.equalsIgnoreCase("Closed")) {
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reopen");
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			} else if (defectStatusService.getDefectStatusById(id).get().getDefectStatusName()
					.equalsIgnoreCase("Reject")) {
				DefectStatus defectStatus2 = defectStatusService.getDefectStatusByName("Reopen");
				defectStatusList.add(defectStatus2);
				return new ResponseEntity<Object>(defectStatusList, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_NOT_EXISTS,
				validationFailureStatusCodes.getDefectStatusNotExist()), HttpStatus.BAD_REQUEST);

	}

}

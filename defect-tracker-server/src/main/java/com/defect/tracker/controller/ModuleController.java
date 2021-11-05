package com.defect.tracker.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.defect.tracker.data.dto.ModuleDto;
import com.defect.tracker.data.entities.Module;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.ModuleRepository;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@Controller
public class ModuleController {

	@Autowired
	ModuleService moduleService;
	
	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	
	@Autowired
	private Mapper mapper;

	
	
	@PostMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> addModule(@Valid @RequestBody ModuleDto moduleDto) {
		 if(moduleRepository.existsByModuleNameAndProjectId(moduleDto.getModuleName(), moduleDto.getProjectId())) { 
					  return new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.MODULE_ALREADY_EXIST,
							  validationFailureStatusCodes.getProjectModuleAlreadyExist()), HttpStatus.BAD_REQUEST);
				  }
		Module module = mapper.map(moduleDto, Module.class);
		moduleService.addModule(module);
		return new ResponseEntity<Object>(Constants.MODULE_ADD_SUCCESS, HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping(value= EndpointURI.GET_MODULE_BY_PROJECT )
	public ResponseEntity<Object> findModuleByProject(@PathVariable Long projectId){
		if (!moduleService.isModuleExistsByProjectId(projectId)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_EMPTY,
					validationFailureStatusCodes.getModuleNotExist()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(mapper.map(moduleService.findByProject(projectId), ModuleDto.class), HttpStatus.OK);
	} 
	
	
	@GetMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> findAllModule(){
		if(moduleService.findAll().isEmpty()) {
			return  new ResponseEntity<Object>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS, 
					validationFailureStatusCodes.getModuleNotExist()), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(mapper.map(moduleService.findAll(), ModuleDto.class), HttpStatus.OK);
		
	}
	
	
	
	@PutMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> updateModule(@Valid @RequestBody ModuleDto moduleDto) {
		if (!moduleService.isModuleExists(moduleDto.getId())) {
			return new ResponseEntity<> (new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS,
					validationFailureStatusCodes.getModuleNotExist()), HttpStatus.BAD_REQUEST);
		}
		Module module = mapper.map(moduleDto, Module.class);
		moduleService.addModule(module);
		return new ResponseEntity<Object>(Constants.MODULE_UPDATE_SUCCESS, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping(value = EndpointURI.MODULE_DELETE)
	public ResponseEntity<Object> deleteModule(@PathVariable Long id) {
		if (!moduleService.isModuleExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS,
					validationFailureStatusCodes.getModuleNotExist()), HttpStatus.BAD_REQUEST);
		}
		moduleService.deleteModule(id);
		return new ResponseEntity<Object>(Constants.MODULE_DELETE_SUCCESS, HttpStatus.OK);
	}
	
	
}


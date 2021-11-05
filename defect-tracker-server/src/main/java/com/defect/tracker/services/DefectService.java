package com.defect.tracker.services;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.defect.tracker.data.dto.DefectByEmployeeIdDto;
import com.defect.tracker.data.dto.DefectByProjectIdDto;
import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Defect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface DefectService {
	public List<Defect> getAllDefect();

	boolean isDefectAlreadyExist(Long id);

	public void addDefect(Defect defect);

	public boolean isDefectExists(Long id);

	public Defect findById(Long id);

	public List<DefectByEmployeeIdDto> getByEmpIdAndStatus(Long id);

	public DefectByProjectIdDto getAllDefectByProId(Long id);

	public String fileUpload(MultipartFile file) throws IOException;

	public DefectDto getJson(String Defect, MultipartFile file) throws JsonMappingException, JsonProcessingException;
}

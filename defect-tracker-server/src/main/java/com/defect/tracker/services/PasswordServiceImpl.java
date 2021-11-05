package com.defect.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.dto.LoginDto;
import com.defect.tracker.data.entities.Login;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.LoginRepository;

@Service
public class PasswordServiceImpl implements PasswordService {
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	Mapper mapper;

	@Override
	public String getPassword(String email) {
		return loginRepository.findByEmail(email).get().getPassword();
	}

	@Override
	public void changePassword(String newPassword, String email) {
		Login login = loginRepository.findByEmail(email).get();
		LoginDto loginDto = mapper.map(login, LoginDto.class);
		loginDto.setPassword(newPassword);
		login = mapper.map(loginDto, Login.class);
		loginRepository.save(login);
	}

}

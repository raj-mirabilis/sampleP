package com.defect.tracker.services;

import java.util.List;

import com.defect.tracker.data.entities.Login;

public interface LoginService {

	public List<Login> getEmployee(String status);

	public String forgotPassword(String email);

	public void resetPassword(String token, String password);

	public List<Login> getLoginByStatus(String status);

	public void create(Login login);

	public void updateEmployeeStatus(String email, String status);

	public boolean isEmailAlreadyExist(String email);

	public void emailVerification(String token, String email);

	public String getUserName(String email);

	public String getUserPassword(String email);

}

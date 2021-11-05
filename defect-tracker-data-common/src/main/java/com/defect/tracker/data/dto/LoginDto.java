package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginDto {

	@NotBlank(message = "{loginDto.loginEmail.Blank}")
	@NotNull(message = "{loginDto.loginEmail.Null}")
	private String email;
	@NotBlank(message = "{loginDto.loginUserName.Blank}")
	@NotNull(message = "{loginDto.loginUserName.Null}")
	private String userName;
	@NotBlank(message = "{loginDto.loginPassword.Blank}")
	@NotNull(message = "{loginDto.loginPassword.Null}")
	private String password;
	private String status;
	private Long employeeId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}

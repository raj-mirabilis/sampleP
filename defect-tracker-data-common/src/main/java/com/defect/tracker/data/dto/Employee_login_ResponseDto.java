package com.defect.tracker.data.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Employee_login_ResponseDto {

	private Long id;
	@NotEmpty(message = "{employeeDto.FirstName.null}")
	@NotNull(message = "{employeeDto.FirstName.empty}")
	@NotBlank(message = "{employeeDto.FirstName.blank}")
	private String firstName;
	@NotEmpty(message = "{employeeDto.lastName.null}")
	@NotNull(message = "{employeeDto.lastName.empty}")
	@NotBlank(message = "{employeeDto.lastName.blank}")
	private String lastName;
	private Long designationId;
	@NotEmpty(message = "{employeeDto.email.null}")
	@NotNull(message = "{employeeDto.email.empty}")
	@NotBlank(message = "{employeeDto.email.blank}")
	private String email;
	@NotEmpty(message = "{employeeDto.address.null}")
	@NotNull(message = "{employeeDto.address.empty}")
	@NotBlank(message = "{employeeDto.address.blank}")
	private String address;
	@NotEmpty(message = "{employeeDto.contactNumber.null}")
	@NotNull(message = "{employeeDto.contactNumber.empty}")
	@NotBlank(message = "{employeeDto.contactNumber.blank}")
	private String contactNumber;
	@NotEmpty(message = "{employeeDto.nic.null}")
	@NotNull(message = "{employeeDto.nic.empty}")
	@NotBlank(message = "{employeeDto.nic.blank}")
	private String nic;
	private String image;
	private Date timeStamp;
	@NotEmpty(message = "{employeeDto.gender.null}")
	@NotNull(message = "{employeeDto.gender.empty}")
	@NotBlank(message = "{employeeDto.gender.blank}")
	private String gender;

	@NotEmpty(message = "{loginDto.userName.null}")
	@NotNull(message = "{loginDto.userName.empty}")
	@NotBlank(message = "{loginDto.userName.blank}")
	private String userName;
	@NotEmpty(message = "{loginDto.password.null}")
	@NotNull(message = "{loginDto.password.empty}")
	@NotBlank(message = "{loginDto.password.blank}")
	private String password;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

}

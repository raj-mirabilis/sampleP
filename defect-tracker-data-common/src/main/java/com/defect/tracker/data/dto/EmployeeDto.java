package com.defect.tracker.data.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {

	private Long id;
	@NotNull(message = "{employeeDto.FirstName.empty}")
	@NotBlank(message = "{employeeDto.FirstName.blank}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "No Special Charcter Accepeted")
	private String firstName;
	@NotNull(message = "{employeeDto.lastName.empty}")
	@NotBlank(message = "{employeeDto.lastName.blank}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "No Special Charcter Accepeted")
	private String lastName;
	private Long designationId;

	@Pattern(regexp = " Pattern.compile(\"@[.]\"", message = "Please Put Valid Characters For Email Ex- abc@yahoo.com")
	@NotNull(message = "{employeeDto.email.empty}")
	@NotBlank(message = "{employeeDto.email.blank}")
	private String email;

	@NotNull(message = "{employeeDto.address.empty}")
	@NotBlank(message = "{employeeDto.address.blank}")
	private String address;
	@NotNull(message = "{employeeDto.contactNumber.empty}")
	@NotBlank(message = "{employeeDto.contactNumber.blank}")
	private String contactNumber;

	@NotNull(message = "{employeeDto.nic.empty}")
	@NotBlank(message = "{employeeDto.nic.blank}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "No Special Charcter Accepeted")
	private String nic;
	private String image;
	private Date timeStamp;
	@NotNull(message = "{employeeDto.gender.empty}")
	@NotBlank(message = "{employeeDto.gender.blank}")
	private String gender;
	private String verification;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

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

}

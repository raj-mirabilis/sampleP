package com.defect.tracker.services;

public interface PasswordService {
	String getPassword(String email);

	void changePassword(String newPassword, String email);
}

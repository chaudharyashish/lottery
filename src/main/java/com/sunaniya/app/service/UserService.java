package com.sunaniya.app.service;

import com.sunaniya.app.model.User;

public interface UserService {

	User save(User user);
	User findByEmailId(String email);
	User findByMobileNumber(Long mobileNumber);
}

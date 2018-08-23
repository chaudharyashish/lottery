package com.sunaniya.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunaniya.app.model.User;
import com.sunaniya.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmailId(String emailId) {
        return userRepository.findByEmailId(emailId);
    }

	@Override
	public User findByMobileNumber(Long mobileNumber) {
		return userRepository.findByMobileNumber(mobileNumber);
	}
}
package com.sunaniya.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunaniya.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByMobileNumber(Long mobileNumber);

	User findByEmailId(String emaiId);

}
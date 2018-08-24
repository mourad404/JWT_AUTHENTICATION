package com.jwt.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.sec.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
}

package com.jwt.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.sec.model.AppRole;

public interface RoleRepo extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName(String roleName);
}

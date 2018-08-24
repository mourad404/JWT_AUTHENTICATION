package com.jwt.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.sec.metier.abst.CompteMetier;
import com.jwt.sec.model.AppRole;
import com.jwt.sec.model.AppUser;

@RestController
public class UserController {

	@Autowired
	private CompteMetier cm;

	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/appusers")
	public AppUser ajtUser(AppUser u) {
		return cm.ajtUser(u);
	}

	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/approles")
	public AppRole ajtRole(AppRole r) {
		return cm.ajtRole(r);
	}

	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/roletouser")
	public void roleToUser(@RequestParam String username, @RequestParam String roleName) {
		cm.roleToUser(username, roleName);
	}

	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/one-user")
	public AppUser findOne(@RequestParam String username) {
		return cm.findByUsername(username);
	}
}

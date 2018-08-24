package com.jwt.sec.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jwt.sec.metier.abst.CompteMetier;
import com.jwt.sec.model.AppRole;
import com.jwt.sec.model.AppUser;
import com.jwt.sec.repo.RoleRepo;
import com.jwt.sec.repo.UserRepo;

@Service
@Transactional
public class CompteMetierImpl implements CompteMetier {

	@Autowired
	private UserRepo ur;

	@Autowired
	private RoleRepo rr;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser ajtUser(@RequestBody AppUser u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		return ur.save(u);
	}

	@Override
	public AppRole ajtRole(@RequestBody AppRole r) {
		return rr.save(r);
	}

	@Override
	public void roleToUser(@RequestParam String username, @RequestParam String roleName) {
		AppUser u = ur.findByUsername(username);
		AppRole r = rr.findByRoleName(roleName);
		u.getRoles().add(r);
	}

	@Override
	public AppUser findByUsername(String username) {
		return ur.findByUsername(username);
	}
}

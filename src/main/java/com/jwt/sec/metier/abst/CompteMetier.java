package com.jwt.sec.metier.abst;

import com.jwt.sec.model.AppRole;
import com.jwt.sec.model.AppUser;

public interface CompteMetier {

	public AppUser ajtUser(AppUser u);

	public AppRole ajtRole(AppRole r);

	public void roleToUser(String username, String roleName);

	public AppUser findByUsername(String username);
}

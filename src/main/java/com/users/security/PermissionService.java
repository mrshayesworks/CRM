package com.users.security;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import static com.users.security.Role.ROLE_ADMIN;
import static com.users.security.Role.ROLE_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.beans.User;
import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;
//This imports the enum info over. to declare any user and admin info//
//This particular part makes you authenticate yourself before giving you access//

//Service imports the spring framework//
@Service
public class PermissionService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ContactRepository contactRepo;

	private AbstractAuthenticationToken getToken() {
		return (AbstractAuthenticationToken) getContext().getAuthentication();
	}
//This is saying if I have a certain Role, I will have authority to access. If I don't have the access, it won`t let me access//
	public boolean hasRole(Role role) {
		for (GrantedAuthority ga : getToken().getAuthorities()) {
			if (role.toString().equals(ga.getAuthority())) {
				return true;
			}
		}
		return false;
	}


//This is showing us that an Admin can edit info on a user//


	public boolean canAccessUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}

	public boolean canEditContact(long contactId) {
		return hasRole(ROLE_USER)
				&& contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}
//TODO What is this doing?//
	public long findCurrentUserId() {
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0).getId() : -1;
	}
	//TODO Explain this. What is this method doing//
}

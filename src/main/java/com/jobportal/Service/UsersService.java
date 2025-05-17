package com.jobportal.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Entities.Role;
import com.jobportal.Entities.Users;
import com.jobportal.Repositories.UsersRepo;

@Service
public class UsersService {

	@Autowired
	private UsersRepo urepo;
	
	public Users registerUser(String name, String email, String password, Role role) {
		if (urepo.findByEmail(email).isPresent()) {
			throw new IllegalArgumentException("Email already in use");
		}

		if (role != Role.ROLE_CANDIDATE && role != Role.ROLE_RECRUITER) {
			throw new IllegalArgumentException("Invalid role provided");
		}

		Users users = new Users();
		users.setUserName(name);
		users.setEmail(email);
		users.setPassword(password);
		users.setRole(Set.of(role));

		return urepo.save(users);
	}

	public boolean checkPassword(String password, String encodedPassword) {
		return password.equals(encodedPassword);
	}

	public Optional<Users> findByEmail(String email) {
		return urepo.findByEmail(email);
	}

	public Optional<Users> findById(long id) {
		return urepo.findById(id);
	}

	public void deleteUserAccount(Long userId) {
		urepo.deleteById(userId);
	}

	public Users updateUser(Long userId, String name, String email) {
		@SuppressWarnings("deprecation")
		Users users = urepo.getById(userId);
		users.setUserName(name);
		users.setEmail(email);
		return urepo.save(users);
	}

	public List<Users> getAllUsers() {
		return urepo.findAll();
	}
}

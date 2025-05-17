package com.jobportal.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.Entities.Job;
import com.jobportal.Entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long>{

	Optional<Users> findByEmail(String email);

	Optional<Users> findByUserName(String userName);
}

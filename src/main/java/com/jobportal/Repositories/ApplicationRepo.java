package com.jobportal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.Entities.Application;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Users;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long>{

	List<Application> findByJob(Job job);

	List<Application> findByUsers(Users users);

}

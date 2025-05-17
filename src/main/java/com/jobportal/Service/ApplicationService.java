package com.jobportal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Entities.Application;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Users;
import com.jobportal.Repositories.ApplicationRepo;
import com.jobportal.Repositories.JobRepo;
import com.jobportal.Repositories.UsersRepo;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepo arepo;
	
	@Autowired
	private JobRepo jrepo;
	
	@Autowired
	private UsersRepo urepo;
	
	
	public Application applyToJob(Long jobId, Long userId, String resume)
	{
		Job job = jrepo.findById(jobId).orElseThrow(()-> new RuntimeException("Job not found"));
		Users users = urepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
		
		Application apply = new Application();
		apply.setJob(job);
		apply.setUsers(users);
		apply.setResume(resume);
		apply.setAppliedAt(java.time.LocalDateTime.now());
		return arepo.save(apply);	
	}
	
	public List<Application> getApplicationsByJob(Long jobId)
	{
		Job job = jrepo.findById(jobId).orElseThrow(() -> new RuntimeException("applications not found"));
		return arepo.findByJob(job);
	}
	
	public List<Application> getApplicationsByUsers(Long usersId)
	{
		Users users = urepo.findById(usersId).orElseThrow(() -> new RuntimeException("applications not found"));
		return arepo.findByUsers(users);
	}
	
	public void cancelApplication(Long appId) {
	    arepo.deleteById(appId);
	  }

}

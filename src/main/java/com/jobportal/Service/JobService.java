package com.jobportal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.Entities.Job;
import com.jobportal.Entities.Users;
import com.jobportal.Repositories.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo jrepo;
	
	@Autowired
	private UsersService uservice;
	
	public void addJob(String jobTitle, String jobDesc, String jobLoc, String jobCompany, String jobPostedBy)
	{
		Job job = new Job();
		job.setJobTitle(jobTitle);
		job.setJobDesc(jobDesc);
		job.setJobLoc(jobLoc);
		job.setJobCompany(jobCompany);
		job.setJobPostedBy(jobPostedBy);
		job.setJobPosted(java.time.LocalDateTime.now());
		
		jrepo.save(job);	
	}
	
	public List<Job> getAllJobs()
	{
		return jrepo.findAll();
	}
	
	public Optional<Job> getJobByTitle(String jobTitle)
	{
		return jrepo.findByJobTitle(jobTitle);
	}
	
	public void updateJob(Long jobId, String jobTitle, String jobDesc, String jobLoc, String jobCompany, String jobPostedBy)
	{
		Job job = jrepo.findById(jobId).orElseThrow(()-> new RuntimeException("Job not found"));
		job.setJobTitle(jobTitle);
		job.setJobDesc(jobDesc);
		job.setJobLoc(jobLoc);
		job.setJobCompany(jobCompany);
		job.setJobPostedBy(jobPostedBy);
		job.setJobPosted(java.time.LocalDateTime.now());
		
		jrepo.save(job);	
	}
	
	public void deleteJob(Long jobId)
	{
		Job job = jrepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
		jrepo.deleteById(jobId);
	}

	public Job getJobById(Long jobId) {
	    return jrepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
	}

	public List<Job> getJobsByRecruiter(String username) {
	    return jrepo.findByJobPostedBy(username);
	}
	
}

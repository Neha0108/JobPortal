package com.jobportal.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobportal.Entities.Application;
import com.jobportal.Entities.Job;
import com.jobportal.Entities.Role;
import com.jobportal.Entities.Users;
import com.jobportal.Service.ApplicationService;
import com.jobportal.Service.JobService;
import com.jobportal.Service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	
	@Autowired
	private JobService jservice;
	
	@Autowired
	private UsersService uservice;
	
	@Autowired
	private ApplicationService aservice;
	
	@GetMapping("/rdashboard")
	public String recruiterDashboard(HttpSession session, Model model) {
	    Users currentUser = (Users) session.getAttribute("currentUser");

	    
	    String recruiter = currentUser.getUserName();
	    List<Job> jobs = jservice.getJobsByRecruiter(recruiter);
	    
	    List<Users> allUsers = uservice.getAllUsers();
	    List<Users> candidates = allUsers.stream()
	        .filter(user -> user.getRole().contains(Role.ROLE_CANDIDATE))
	        .toList();
	    
	    model.addAttribute("jobs", jobs);
	    model.addAttribute("candidates",candidates);
	    return "r-dashboard";
	}

	
	@PostMapping("/addjob")
	public String addJob(@RequestParam String jobTitle,@RequestParam String jobDesc,@RequestParam String jobLoc,@RequestParam String jobCompany,@RequestParam String jobPostedBy, Model model)
	{
		jservice.addJob(jobTitle, jobDesc, jobLoc, jobCompany, jobPostedBy);
		model.addAttribute("sucess","job added sucessfully");
		return "redirect:/recruiter/rdashboard";	
	}
	
	@GetMapping("/editjob")
	public String showEditForm(@RequestParam Long jobId, Model model) {
	    Job job = jservice.getJobById(jobId);
	    model.addAttribute("job", job);
	    return "edit-job";
	}

	@PostMapping("/updatejob")
	public String updateJob(@RequestParam Long jobId, @RequestParam String jobTitle,@RequestParam String jobDesc,@RequestParam String jobLoc,@RequestParam String jobCompany,@RequestParam String jobPostedBy,Model model)
	{
		jservice.updateJob(jobId, jobTitle, jobDesc, jobLoc, jobCompany, jobPostedBy);
		model.addAttribute("success","job updated successfully");
		return "redirect:/recruiter/rdashboard";
	}
	
}

package com.jobportal.Entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobId;
	private String jobTitle;
	private String jobDesc;
	private String jobLoc;
	private String jobCompany;
	private String jobPostedBy;
	private LocalDateTime jobPosted;
}

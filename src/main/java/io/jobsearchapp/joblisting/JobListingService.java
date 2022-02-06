package io.jobsearchapp.joblisting;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobListingService {
	
	
	@Autowired
	private JobListingRepository jlRepository;
	
	
	/* METHODS */
	
	public List<JobListing> getAllJobListings() {
		List<JobListing> jobListings = new ArrayList<>();
		jlRepository.findAll().forEach(jobListings::add);
		return jobListings;
	}

	public JobListing getJobListingById(int id) {
		return jlRepository.findById(id).orElse(null);
	}
	
	public List<JobListing> getJobListingByJobTitle(String jobTitle) {
		return jlRepository.findByJobTitle(jobTitle);
	}
	
	public List<JobListing> getJobListingsByCompany(String companyName) {
		return jlRepository.findByCompany(companyName);
	
	}
	
	public List<JobListing> getJobListingBySite(String siteName) {
		return jlRepository.findBySite(siteName);
	}

	public void addJobListing(JobListing jobListing) {
		jlRepository.save(jobListing);
	}
	
	public void updateJobListing(JobListing jobListing) {
		jlRepository.save(jobListing);
	}
	
	public void deleteJobListing(int id) {
		jlRepository.deleteById(id);
	}

	
	
	
	
	 
			
		
//	public List<JobListing> getNewJobListings(SiteName[] siteNames, String keyword) {
//		List<JobListing> latestJobs = new ArrayList<>();
//		JobSiteScraper scraper;
//		
//		for (SiteName siteName : siteNames) {
//			scraper = scrapers.get(siteName);
//			latestJobs.addAll(scraper.findJobListings(keyword));
//		}
//		
//		// TO DELETE
//		System.out.println(latestJobs);
//		
//		return latestJobs;
//	}
//	

	
	

}

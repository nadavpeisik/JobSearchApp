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
		return jlRepository.findByCompanyName(companyName);
	
	}
	
	public List<JobListing> getJobListingBySiteName(String siteName) {
		return jlRepository.findBySiteName(siteName);
	}

	public void addJobListing(JobListing jobListing) {
		jlRepository.save(jobListing);
	}
	
	public void updateJobListing(JobListing jobListing) {
		jlRepository.save(jobListing);
	}
	
	public void deleteJobListing(JobListing jobListing) {
		jlRepository.delete(jobListing);
	}
	
	public void deleteJobListingById(int id) {
		jlRepository.deleteById(id);
	}
	
//	public void deleteAll() {
//		jlRepository.deleteAll();
//		
//	}
			
		
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

}

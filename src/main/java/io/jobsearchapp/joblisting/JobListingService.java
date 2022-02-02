package io.jobsearchapp.joblisting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JobListingService {
	
	
	// ######## LINKS ########
	private static final String linkedInURL = "https://www.linkedin.com/jobs/search?keywords=%s"
			+ "&location=Israel&locationId=&geoId=101620260&f_TPR=r86400&position=1&pageNum=0";
	
	// Map from links to corresponding scrapers
	private static final Map<SiteName, JobSiteScraper> scrapers = Map.of(
			SiteName.LinkedIn, new LinkedInScraper(linkedInURL)
			);
	
	// Current list of job openings
	private List<JobListing> jobListings;
	
	
	// ############### METHODS ###############
	
	public List<JobListing> getJobListings() {
		return jobListings;
	}
			
		
	public List<JobListing> getNewJobListings(SiteName[] siteNames, String keyword) {
		List<JobListing> latestJobs = new ArrayList<>();
		JobSiteScraper scraper;
		
		for (SiteName siteName : siteNames) {
			scraper = scrapers.get(siteName);
			latestJobs.addAll(scraper.findJobListings(keyword));
		}
		
		System.out.println(latestJobs);
		
		return latestJobs;
	}
	
	public List<JobListing> getJobListingsByCompany(String companyName) {
		return jobListings.stream().filter(j -> j.getCompanyName().equals(companyName)).toList();
	}
	
	public List<JobListing> getJobListingByJobTitle(String jobTitle) {
		return jobListings.stream().filter(j -> j.getJobTitle().equals(jobTitle)).toList();
	}
	
	

}

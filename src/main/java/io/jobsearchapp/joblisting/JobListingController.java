package io.jobsearchapp.joblisting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobListingController {
	
	@Autowired
	private JobListingService jobListingService;
	
	
	@RequestMapping("/joblistings")
	public List<JobListing> getSavedJobListings () {
		return jobListingService.getJobListings();
	}
	
	@RequestMapping("/joblistings/{sites}/{keyword}")
	public List<JobListing> getNewJobListings(
			@PathVariable(value="sites", required=true) SiteName[] sites, 
			@PathVariable(value="keyword", required=true) String keyword) {
		// In the future will receive array of sites and keyword from front-end
		return jobListingService.getNewJobListings(new SiteName[]{SiteName.LinkedIn}, "junior");
		//return jobListingService.getNewJobListings(sites, keyword);
	}
	
	@RequestMapping("/joblistings/{company}")
	public List<JobListing> getJobListingsByCompany(@PathVariable(value="company", required=true) String companyName) {
		return jobListingService.getJobListingsByCompany(companyName);
	}
	
	@RequestMapping("/joblistings/{jobtitle}")
	public List<JobListing> getJobListingsByJobTitle (@PathVariable(value="jobtitle", required=true) String jobTitle) {
		return jobListingService.getJobListingByJobTitle(jobTitle);
		
	}

}

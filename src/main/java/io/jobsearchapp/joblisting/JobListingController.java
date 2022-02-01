package io.jobsearchapp.joblisting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobListingController {
	
	@Autowired
	private JobListingService jobListingService;
	
	
	@RequestMapping("/oeh") 
	public String kek() {
		return "oeh";
	}
	
	@RequestMapping("/joblistings")
	public List<JobListing> getSavedJobListings () {
		return jobListingService.getJobListings();
	}
	
	@RequestMapping("/joblistings/new")
	public List<JobListing> getNewJobListings() {
		// In the future will receive array of sites and keyword from front-end
		return jobListingService.getLatestJobs(new SiteName[]{SiteName.LinkedIn}, "junior");
	}

}

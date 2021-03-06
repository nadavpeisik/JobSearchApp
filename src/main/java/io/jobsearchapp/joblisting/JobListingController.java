package io.jobsearchapp.joblisting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin 
@RestController
class JobListingController {
	
	@Autowired
	private JobListingService jobListingService;
	
	/* GET Methods */
	
	@GetMapping("/joblistings")
	public List<JobListing> getAllJobListings () {
		return jobListingService.getAllJobListings();
	}
	
	@GetMapping("/joblistings/{id}")
	public JobListing getJobListingById(@PathVariable(required=true) int id) {
		return jobListingService.getJobListingById(id);
	}
	
	@GetMapping("/joblistings/{jobtitle}")
	public List<JobListing> getJobListingsByJobTitle (@PathVariable(value="jobtitle", required=true) String jobTitle) {
		return jobListingService.getJobListingByJobTitle(jobTitle);
	}
	
	@GetMapping("/joblistings/{company}")
	public List<JobListing> getJobListingsByCompany(@PathVariable(value="company", required=true) String companyName) {
		return jobListingService.getJobListingsByCompany(companyName);
	}
	
	@GetMapping("/joblistings/{site}")
	public List<JobListing> getJobListingsBySite (@PathVariable(value="site", required=true) String siteName) {
		return jobListingService.getJobListingBySiteName(siteName);
	}
	
	/* POST Methods */
	
	@PostMapping("/joblistings")
	public void addJobListing(@RequestBody JobListing jobListing) {
		jobListingService.addJobListing(jobListing);
	}
	
	/* UPDATE Methods */
	
	@PutMapping("/joblistings/{id}")
	public void updateJobListing(@RequestBody JobListing jobListing, @PathVariable int id) {
		jobListingService.updateJobListing(jobListing);
	}
	
	/* DELETE Methods */
	
	@DeleteMapping("/joblistings")
	public void deleteJobListing(@RequestBody JobListing jobListing) {
		jobListingService.deleteJobListing(jobListing);
	}
	
	@DeleteMapping("/joblistings/{id}")
	public void deleteJobListingById(@PathVariable int id) {
		jobListingService.deleteJobListingById(id);
	}
	
//	@DeleteMapping("/joblistings")
//	public void deleteAll() {
//		jobListingService.deleteAll();
//	}
	
	
//	@RequestMapping("/joblistings/{sites}/{keyword}")
//	public List<JobListing> getNewJobListings(
//			@PathVariable(value="sites", required=true) SiteName[] sites, 
//			@PathVariable(value="keyword", required=true) String keyword) {
//		//return jobListingService.getNewJobListings(new SiteName[]{SiteName.LinkedIn}, "junior");
//		return jobListingService.getNewJobListings(sites, keyword);
//	}
//	

	

	
	

}

package io.jobsearchapp.scrapers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.jobsearchapp.SiteName;
import io.jobsearchapp.joblisting.JobListing;

@CrossOrigin 
@RestController
public class ScrapingController {
	
	@Autowired
	private ScrapingService scrapingService;
	
	@GetMapping("/joblistings/new/{sites}/{keyword}")
	public List<JobListing> getNewJobListings(
			@PathVariable(required=true) String sites, 
			@PathVariable(required=true) String keyword) {
		//return scrapingService.getNewJobListings(new SiteName[]{SiteName.LinkedIn}, "junior");
		System.out.println(sites);
		return scrapingService.getNewJobListings(sites, keyword);
	}

}

package io.jobsearchapp.scrapers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.jobsearchapp.SiteName;
import io.jobsearchapp.joblisting.JobListing;



public class ScrapingService {
	// LINKS 
	private static final String linkedInURL = "https://www.linkedin.com/jobs/search?keywords=%s"
			+"&location=Israel&locationId=&geoId=101620260&f_TPR=r86400&position=1&pageNum=0";
		
	// Map from links to corresponding scrapers
	private static final Map<SiteName, JobSiteScraper> scrapers = Map.of(
			SiteName.LINKEDIN, new LinkedInScraper(linkedInURL)
				);
	

	
	public List<JobListing> scrape(SiteName[] siteNames, String keyword) {
		List<JobListing> latestJobs = new ArrayList<>();
		JobSiteScraper scraper;
		
		for (SiteName siteName : siteNames) {
			scraper = scrapers.get(siteName);
			latestJobs.addAll(scraper.findJobListings(keyword));
		}
		
		return latestJobs;
	}
	

}

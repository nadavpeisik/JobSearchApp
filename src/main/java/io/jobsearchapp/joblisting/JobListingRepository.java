package io.jobsearchapp.joblisting;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobListingRepository extends CrudRepository<JobListing, Integer> {
	
	List<JobListing> findByJobTitle(String jobTitle);
	
	List<JobListing> findByCompanyName(String companyName);
	
	List<JobListing> findBySiteName(String siteName);
	
}

package io.jobsearchapp.joblisting;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobListingRepository extends CrudRepository<JobListing, Integer> {
	
	List<JobListing> findByJobTitle(String jobTitle);
	
	List<JobListing> findByCompany(String companyName);
	
	List<JobListing> findBySite(String siteName);
	
	

}

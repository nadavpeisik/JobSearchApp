package io.jobsearchapp.joblisting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.jobsearchapp.SiteName;

@Entity
public class JobListing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobTitle;
    private String companyName;
    private String link;
    private SiteName siteName;
    
    
    public JobListing() {}

    public JobListing(String jobTitle, String companyName, String link, SiteName siteName) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.link = link;
        this.siteName = siteName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public String getCompanyName() {
    	return this.companyName;
    }
    
    public String getSiteName() {
    	return siteName.toString();
    }

    @Override
    public String toString() {
        return "Job Title: " + jobTitle + ", Company: " + companyName + System.lineSeparator() + 
        	siteName.toString() + " link: " + link;
    }
	

}

package io.jobsearchapp.joblisting;

public class JobListing {
	private String jobTitle;
    private String company;
    private String link;

    public JobListing(String jobTitle, String companyName, String link) {
        this.jobTitle = jobTitle;
        this.company = companyName;
        this.link = link;
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
    	return this.company;
    }

    @Override
    public String toString() {
        return "Job Title: " + jobTitle + ", Company: " + company + System.lineSeparator() + "Link: " + link;
    }
	

}

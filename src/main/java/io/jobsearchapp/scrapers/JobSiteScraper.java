package io.jobsearchapp.scrapers;

import java.util.ArrayList;

import io.jobsearchapp.joblisting.JobListing;

abstract class JobSiteScraper {
    private String baseUrl;

    protected JobSiteScraper(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected final String getBaseUrl() {
        return baseUrl;
    }

    protected final void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected abstract ArrayList<JobListing> findJobListings(String keyword);

}
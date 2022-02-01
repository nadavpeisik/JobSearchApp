package io.jobsearchapp.joblisting;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LinkedInScraper extends JobSiteScraper {

    private WebClient client;

    public LinkedInScraper(String baseUrl) {
        super(baseUrl);

        this.client = new WebClient();
        this.client.getOptions().setJavaScriptEnabled(false);
        this.client.getOptions().setCssEnabled(false);
    }

    public LinkedInScraper(String baseUrl, boolean jsEnabled, boolean cssEnabled) {
        super(baseUrl);

        this.client = new WebClient();
        this.client.getOptions().setJavaScriptEnabled(jsEnabled);
        this.client.getOptions().setCssEnabled(cssEnabled);
    }

    @Override
    public ArrayList<JobListing> findJobListings(String keyword) {
        ArrayList<JobListing> jobListings = new ArrayList<>();

        try {
            String linkedInURL = String.format(getBaseUrl(), keyword);

            HtmlPage searchPage = client.getPage(linkedInURL);
            List<HtmlAnchor> searchResults = searchPage.getByXPath("//a[@class='base-card__full-link']");
            List<HtmlAnchor> companies = searchPage.getByXPath("//a[@class='hidden-nested-link']");

            //for (HtmlAnchor searchResult : searchResults) {
            for (int i = 0; i < searchResults.size(); i++) {
                // Extract job title
                String jobTitle = searchResults.get(i).asNormalizedText();

                if (jobTitle.toLowerCase().contains(keyword.toLowerCase())) {
                    // Extract job listing link
                    String jobLink = searchResults.get(i).getHrefAttribute();

                    // Extract company
                    String companyName = companies.get(i).asNormalizedText();
                    // THIS IS THE OLD WAY (REQUIRES LOGGING IN WHICH DOESN'T WORK DUE TO JS BUGS)
                    // Go to link
//                    HtmlPage jobPage = client.getPage(jobLink);
//                    HtmlAnchor companyAnchor = jobPage.getFirstByXPath("//a[@class='sub-nav-cta__optional-url']");
//                    String companyName = companyAnchor.asNormalizedText();
//                    String companyPage = companyAnchor.getHrefAttribute();

                    jobListings.add(new JobListing(jobTitle, companyName, jobLink));
                }

                /// JOB DESCRIPTION (MAYBE IMPLEMENT LATER)
//               HtmlDivision desc = jobPage.getFirstByXPath("//div[@class='decorated-job-posting__details']");
//               System.out.println(desc.asNormalizedText());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobListings;
    }
}

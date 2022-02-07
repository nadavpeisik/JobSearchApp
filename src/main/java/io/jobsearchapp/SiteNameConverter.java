package io.jobsearchapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SiteNameConverter {
    
	public static List<SiteName> getSiteList(String input) {
		List<SiteName> siteNames = new ArrayList<>();
		
		Arrays.stream(parseSiteNames(input)).forEach(s -> siteNames.add(convertToSiteName(s)));
		
		return siteNames;
	}
	
	private static SiteName convertToSiteName(String text) {
		return SiteName.valueOf(text.toUpperCase());
	}
	
	private static String[] parseSiteNames(String input) {
		return input.split(",");
	}
    
}


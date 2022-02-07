package io.jobsearchapp;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SiteName {
	LINKEDIN("LinkedIn"),
	DRUSHIM("Drushim"),
	ETHOSIA("Ethosia"),
	SQLINK("SQLink"),
	GOTFRIENDS("GotFriends");
	
	private final String siteName;
	
	private SiteName(String siteName) {
		this.siteName = siteName;
	}
	
	private boolean equalsName(String otherName) {
		return this.siteName.toLowerCase().equals(otherName.toLowerCase());
	}
	
	@JsonCreator
	public static SiteName fromText(String text){
        for(SiteName siteName : SiteName.values()){
            if(siteName.equalsName(text)){
                return siteName;
            }
        }
        throw new IllegalArgumentException();
    }
	
	@Override
	public String toString() {
		return this.siteName;
	}
	
}

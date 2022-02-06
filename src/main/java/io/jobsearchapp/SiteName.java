package io.jobsearchapp;

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
	
	public boolean equalsName(String otherName) {
		return this.siteName.equals(otherName);
	}
	
	public String toString() {
		return this.siteName;
	}
	
}

package io.java.coronavirusdatatracker.models;

public class DataModel {
	
	private String state;
	private String country;
	private int latestTotalCase;
	private int preTotalCase;
	
	public int getPreTotalCase() {
		return preTotalCase;
	}
	public void setPreTotalCase(int preTotalCase) {
		this.preTotalCase = preTotalCase;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalCase() {
		return latestTotalCase;
	}
	public void setLatestTotalCase(int latestTotalCase) {
		this.latestTotalCase = latestTotalCase;
	}
	@Override
	public String toString() {
		return "DataModel [state=" + state + ", country=" + country + ", latestTotalCase=" + latestTotalCase + "]";
	}
	
	

}

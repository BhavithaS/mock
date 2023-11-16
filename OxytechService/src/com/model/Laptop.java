//Do not add or edit the code. Model class is provided as part of the code skeleton
package com.model;

import java.util.Date;

public class Laptop {
	private String hardwareId;
	private String laptopName;
	private Date receivedDate;
	private String rootIssue;
	private String issueIntensity;
	private double billAmount;

	public Laptop() {

	}

	public Laptop(String hardwareId, String laptopName, Date receivedDate, String rootIssue, String issueIntensity,
			double billAmount) {
		super();
		this.hardwareId = hardwareId;
		this.laptopName = laptopName;
		this.receivedDate = receivedDate;
		this.rootIssue = rootIssue;
		this.issueIntensity = issueIntensity;
		this.billAmount = billAmount;
	}

	public String getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}

	public String getLaptopName() {	 	  	  		    	  	      	      	 	
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getRootIssue() {
		return rootIssue;
	}

	public void setRootIssue(String rootIssue) {
		this.rootIssue = rootIssue;
	}

	public String getIssueIntensity() {
		return issueIntensity;
	}

	public void setIssueIntensity(String issueIntensity) {
		this.issueIntensity = issueIntensity;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {	 	  	  		    	  	      	      	 	
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Laptop [hardwareId=" + hardwareId + ", laptopName=" + laptopName + ", receivedDate=" + receivedDate
				+ ", rootIssue=" + rootIssue + ", issueIntensity=" + issueIntensity + ", billAmount=" + billAmount
				+ "]";
	}
}

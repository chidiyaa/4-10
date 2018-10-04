package com.cg.rms.beans;

public class PlacedCandidate {
	
	private String month;
	private String companyId;
	private String candidateId;
	private String designation;
	public PlacedCandidate() {
		super();
	}
	@Override
	public String toString() {
		return "PlacedCandidate [month=" + month + ", companyId=" + companyId
				+ ", candidateId=" + candidateId + ", designation="
				+ designation + "]";
	}
	public PlacedCandidate(String month, String companyId, String candidateId,
			String designation) {
		super();
		this.month = month;
		this.companyId = companyId;
		this.candidateId = candidateId;
		this.designation = designation;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}

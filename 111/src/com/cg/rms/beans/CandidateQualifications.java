package com.cg.rms.beans;

public class CandidateQualifications {
	private String qualificationId;
	private String qualificationName;
	private String specializationArea;
	private String collegeName;
	private String universityName;
	private String yearOfpassing;
	private double percentage;
	public CandidateQualifications(String qualificationId,
			String qualificationName, String specializationArea,
			String collegeName, String universityName, String yearOfpassing,
			double percentage, String candidateId) {
		super();
		this.qualificationId = qualificationId;
		this.qualificationName = qualificationName;
		this.specializationArea = specializationArea;
		this.collegeName = collegeName;
		this.universityName = universityName;
		this.yearOfpassing = yearOfpassing;
		this.percentage = percentage;
		this.candidateId = candidateId;
	}
	private String candidateId;
	public CandidateQualifications() {
		super();
	}
	@Override
	public String toString() {
		return "CandidateQualifications [qualificationId=" + qualificationId
				+ ", qualificatioName=" + qualificationName
				+ ", specializationArea=" + specializationArea
				+ ", collegeName=" + collegeName + ", universityName="
				+ universityName + ", yearOfpassing=" + yearOfpassing
				+ ", percentage=" + percentage + ", candidateId=" + candidateId
				+ "]";
	}
	public String getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificatioName) {
		this.qualificationName = qualificatioName;
	}
	public String getSpecializationArea() {
		return specializationArea;
	}
	public void setSpecializationArea(String specializationArea) {
		this.specializationArea = specializationArea;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getYearOfpassing() {
		return yearOfpassing;
	}
	public void setYearOfpassing(String yearOfpassing) {
		this.yearOfpassing = yearOfpassing;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	
	

}

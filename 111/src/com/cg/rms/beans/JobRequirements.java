package com.cg.rms.beans;

public class JobRequirements {
private String jobId;
private String companyId;
private String positionRequired;
private int numbersRequired;
private int experienceRequired;
private String qualificationRequired;
private String jobLocation;
private String jobDescription;
public String getJobId() {
    return jobId;
}
public void setJobId(String jobId) {
    this.jobId = jobId;
}
public String getCompanyId() {
    return companyId;
}
public void setCompanyId(String companyId) {
    this.companyId = companyId;
}
public String getPositionRequired() {
    return positionRequired;
}
public void setPositionRequired(String positionRequired) {
    this.positionRequired = positionRequired;
}
public int getNumbersRequired() {
    return numbersRequired;
}
public void setNumbersRequired(int numbersRequired) {
    this.numbersRequired = numbersRequired;
}
public int getExperienceRequired() {
    return experienceRequired;
}
public void setExperienceRequired(int experienceRequired) {
    this.experienceRequired = experienceRequired;
}
public String getQualificationRequired() {
    return qualificationRequired;
}
public void setQualificationRequired(String qualificationRequired) {
    this.qualificationRequired = qualificationRequired;
}
public String getJobLocation() {
    return jobLocation;
}
public void setJobLocation(String jobLocation) {
    this.jobLocation = jobLocation;
}
public String getJobDescription() {
    return jobDescription;
}
public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
}
public JobRequirements() {
    super();
    // TODO Auto-generated constructor stub
}
public JobRequirements(String jobId, String companyId, String positionRequired,
        int numbersRequired, int experienceRequired,
        String qualificationRequired, String jobLocation, String jobDescription) {
    super();
    this.jobId = jobId;
    this.companyId = companyId;
    this.positionRequired = positionRequired;
    this.numbersRequired = numbersRequired;
    this.experienceRequired = experienceRequired;
    this.qualificationRequired = qualificationRequired;
    this.jobLocation = jobLocation;
    this.jobDescription = jobDescription;
}
@Override
public String toString() {
    return "JobRequirements [jobId=" + jobId + ", companyId=" + companyId
            + ", positionRequired=" + positionRequired + ", numbersRequired="
            + numbersRequired + ", experienceRequired=" + experienceRequired
            + ", qualificationRequired=" + qualificationRequired
            + ", jobLocation=" + jobLocation + ", jobDescription="
            + jobDescription + "]";
}


}



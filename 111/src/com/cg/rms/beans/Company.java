package com.cg.rms.beans;

public class Company {

    CompanyMaster companyMaster;
    JobRequirements jobRequirements;
    public CompanyMaster getCompanyMaster() {
        return companyMaster;
    }
    public void setCompanyMaster(CompanyMaster companyMaster) {
        this.companyMaster = companyMaster;
    }
    public JobRequirements getJobRequirements() {
        return jobRequirements;
    }
    public void setJobRequirements(JobRequirements jobRequirements) {
        this.jobRequirements = jobRequirements;
    }
    public Company() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Company [companyMaster=" + companyMaster + ", jobRequirements="
                + jobRequirements + "]";
    }
    public Company(CompanyMaster companyMaster, JobRequirements jobRequirements) {
        super();
        this.companyMaster = companyMaster;
        this.jobRequirements = jobRequirements;
    }
    
}

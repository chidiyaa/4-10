package com.cg.rms.dao;

import java.util.ArrayList;

import com.cg.rms.beans.Company;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.beans.Candidate;
import com.cg.rms.exception.RecruitmentException;

public interface CompanyUserDAO {
    String registerCompany(CompanyMaster companyMaster) throws RecruitmentException;
    String postJobRequirement(JobRequirements jobRequirement) throws RecruitmentException;
    ArrayList<CompanyMaster> getCompanyDetails() throws RecruitmentException;
    public ArrayList<Candidate> listAllCandidate() throws RecruitmentException;
}

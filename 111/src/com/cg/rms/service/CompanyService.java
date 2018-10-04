package com.cg.rms.service;

import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.exception.RecruitmentException;

public interface CompanyService {
	
	public ArrayList <CandidatePersonal> SearchByCompany
	(String position,Integer experience,String qualification) throws RecruitmentException;
	String registerCompany(CompanyMaster companyMaster) throws RecruitmentException;
    String postJobRequirement(JobRequirements jobRequirement) throws RecruitmentException;
    ArrayList<CompanyMaster> getCompanyDetails() throws RecruitmentException;
    public ArrayList<Candidate> listAllCandidate() throws RecruitmentException;
}

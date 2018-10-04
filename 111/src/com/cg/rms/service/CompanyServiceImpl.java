package com.cg.rms.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.dao.CandidateDAO;
import com.cg.rms.dao.CandidateDAOImpl;
import com.cg.rms.dao.CompanyUserDAO;
import com.cg.rms.dao.CompanyUserDAOImpl;
import com.cg.rms.exception.RecruitmentException;
public class CompanyServiceImpl implements CompanyService {
	
	
	CandidateDAO cdao=new CandidateDAOImpl();
	CompanyUserDAO cudao=new CompanyUserDAOImpl();

    @Override
    public ArrayList<CandidatePersonal> SearchByCompany(String position,
            Integer experience, String qualification) throws RecruitmentException {
        
         ArrayList<CandidateWorkHistory> jobReq=cdao.viewResume2();
         ArrayList<CandidateQualifications> jobReq1=cdao.viewResume1();
         ArrayList<CandidatePersonal> jobReq2=cdao.viewResume();
         ArrayList<CandidatePersonal> jobReq3=new ArrayList<CandidatePersonal>();
         for(CandidateWorkHistory job1:jobReq)
         {
             LocalDate dur1=job1.getEmploymentFrom();
             LocalDate dur2=job1.getEmploymentTo();
             
             Integer workExp1=dur2.getYear()-dur1.getYear();
            
             
             if(dur2.getMonthValue()<dur1.getMonthValue())
             {
                 workExp1=dur2.getYear()-dur1.getYear()-1;
             }
             else
                 workExp1=dur2.getYear()-dur1.getYear();
             
             String pos=job1.getPositionHeld();
             
             for(CandidateQualifications job2:jobReq1)
             {
                 for(CandidatePersonal job:jobReq2)
                 {
                     String qual=job2.getQualificationName();
                     if(pos.equals(position) && qual.contains(qualification)  && (workExp1==experience) &&(job1.getCandidateId().equals(job2.getCandidateId())) && (job2.getCandidateId().equals(job.getCandidateId()) ))
                     {
                          jobReq3.add(job);
                     }
                 }
             }
             
             
         }
         return jobReq3;
         
     }

	@Override
	public String registerCompany(CompanyMaster companyMaster)
			throws RecruitmentException {
		// TODO Auto-generated method stub
	
		return cudao.registerCompany(companyMaster);
	}

	@Override
	public String postJobRequirement(JobRequirements jobRequirement)
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cudao.postJobRequirement(jobRequirement);
	}

	@Override
	public ArrayList<CompanyMaster> getCompanyDetails()
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cudao.getCompanyDetails();
	}

	@Override
	public ArrayList<Candidate> listAllCandidate() throws RecruitmentException {
		// TODO Auto-generated method stub
		return cudao.listAllCandidate();
	}


	}
	

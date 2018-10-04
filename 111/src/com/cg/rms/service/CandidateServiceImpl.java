package com.cg.rms.service;

import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.dao.CandidateDAO;
import com.cg.rms.dao.CandidateDAOImpl;
import com.cg.rms.exception.RecruitmentException;

public class CandidateServiceImpl implements CandidateService {
	
	CandidateDAO cdao=new CandidateDAOImpl();
	@Override
	public ArrayList<JobRequirements> search(String qualification,
			String position, int experience,String location) throws RecruitmentException {
		
            ArrayList<JobRequirements> jobReq=cdao.getJobRequirements();
            ArrayList<JobRequirements> jobReq1=new ArrayList<JobRequirements>();
            for(JobRequirements job:jobReq)
            {
            	String qual=job.getQualificationRequired();
                Integer exp=job.getExperienceRequired();
                String loc=job.getJobLocation();
                String pos=job.getPositionRequired();
                if(pos.equalsIgnoreCase(position) && loc.equalsIgnoreCase(location) && exp==experience && qual.contains(qualification)){
                    jobReq1.add(job);
                    
                }
                
            }
            return jobReq1;
            
       
	}
	@Override
	public int addResume(Candidate candidate) throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.addResume(candidate);
	}
	@Override
	public int modifyResume(Candidate candidate,String candidateId) throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.modifyResume(candidate,candidateId);
	}
	@Override
	public int applyForJob(String jobId, String candidateId)
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.applyForJob(jobId,candidateId);
	}
	@Override
	public ArrayList<CandidateQualifications> viewResume1()
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.viewResume1();
	}
	@Override
	public ArrayList<CandidatePersonal> viewResume()
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.viewResume();
	}
	@Override
	public ArrayList<CandidateWorkHistory> viewResume2()
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.viewResume2();
	}
	@Override
	public ArrayList<JobRequirements> getJobRequirements()
			throws RecruitmentException {
		// TODO Auto-generated method stub
		return cdao.getJobRequirements();
	}
	

}

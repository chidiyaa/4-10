package com.cg.rms.dao;

import java.util.ArrayList;

import com.cg.rms.beans.*;
import com.cg.rms.exception.RecruitmentException;

public interface CandidateDAO {

    int addResume(Candidate candidate) throws RecruitmentException;
    int modifyResume(Candidate candidate,String candidateId)throws RecruitmentException;
  //  ArrayList<Candidate> viewResume(int candidateId)throws RecruitmentException;
    int applyForJob(String jobId,String candidateId)throws RecruitmentException;
	ArrayList<CandidateQualifications> viewResume1()
			throws RecruitmentException;
	ArrayList<CandidatePersonal> viewResume() throws RecruitmentException;
	ArrayList<CandidateWorkHistory> viewResume2() throws RecruitmentException;
	//ArrayList<Candidate> viewResum(int candidateId) throws RecruitmentException;
	ArrayList<JobRequirements> getJobRequirements() throws RecruitmentException;

}
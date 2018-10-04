package com.cg.rms.dao;

import com.cg.rms.exception.RecruitmentException;

import java.util.ArrayList;

import com.cg.rms.beans.*;

public interface PlacedCandidateDAO {
	public ArrayList<PlacedCandidate> searchPlaced()throws RecruitmentException;
	public ArrayList<Candidate> listAllCandidate() throws RecruitmentException;
	public ArrayList<CompanyMaster> getAllCompanies() throws RecruitmentException;

}

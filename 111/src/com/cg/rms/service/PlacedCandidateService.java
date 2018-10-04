package com.cg.rms.service;

import java.util.ArrayList;

import com.cg.rms.beans.PlacedCandidate;
import com.cg.rms.exception.RecruitmentException;

public interface PlacedCandidateService {
	public ArrayList<String> pCountMonth(String month) throws RecruitmentException;
	public ArrayList<String> pCountCompany(String Company) throws RecruitmentException;
	public ArrayList<String> pCountDesignation(String designation) throws RecruitmentException;
	
}

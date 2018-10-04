package com.cg.rms.ui;

import java.text.ParseException;

import com.cg.rms.exception.RecruitmentException;

public interface CandidateUI {
	public void applyJobs(String id) throws RecruitmentException;
	public  void searchJobs() throws RecruitmentException;
	public  void modifyResume(String id) throws ParseException, RecruitmentException ;
	//public void addResume() throws RecruitmentException, ParseException;
	public void showCandidateMenu(String id) throws RecruitmentException, ParseException;
	void addResume(String id) throws RecruitmentException, ParseException;
}

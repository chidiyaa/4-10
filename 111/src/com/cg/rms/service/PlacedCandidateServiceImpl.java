package com.cg.rms.service;

import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.Company;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.CompanyUser;
import com.cg.rms.beans.PlacedCandidate;
import com.cg.rms.dao.CompanyUserDAO;
import com.cg.rms.dao.CompanyUserDAOImpl;
import com.cg.rms.dao.PlacedCandidateDAO;
import com.cg.rms.dao.PlacedCandidateImpl;
import com.cg.rms.exception.RecruitmentException;

public class PlacedCandidateServiceImpl implements PlacedCandidateService {

	PlacedCandidateDAO pcdao=new PlacedCandidateImpl();
	CompanyUserDAO cudao=new CompanyUserDAOImpl() ;
	@Override
	public ArrayList<String> pCountMonth(String month) throws RecruitmentException {
		ArrayList<PlacedCandidate> placedCandidateList=pcdao.searchPlaced();
		ArrayList<Candidate>  candidateList=pcdao.listAllCandidate();
		ArrayList<String> placedCandidatesName=new ArrayList<>();


		for(PlacedCandidate placedCandidate:placedCandidateList)
		{
			if(month.equalsIgnoreCase(placedCandidate.getMonth()))
			{
				for(Candidate candidate:candidateList)
				{
					if(candidate.getCandidatePersonal().getCandidateId().equals(placedCandidate.getCandidateId()))
					{
						placedCandidatesName.add(candidate.getCandidatePersonal().getCandidateName());
					}
				}



			}

		}
		return placedCandidatesName;
	}

	@Override
	public ArrayList<String> pCountCompany(String company) throws RecruitmentException {
		ArrayList<PlacedCandidate> placedCandidateList=pcdao.searchPlaced();
		ArrayList<CompanyMaster> allCompanies=pcdao.getAllCompanies();
		ArrayList<String> placedCandidatesName=new ArrayList<>();
		ArrayList<Candidate>  candidateList=pcdao.listAllCandidate();
		for(CompanyMaster companySearch:allCompanies)
		{
			String companyId;
			if(companySearch.getCompanyName().equalsIgnoreCase(company))
			{
				companyId=companySearch.getCompanyId();
				for(PlacedCandidate placedCandidate:placedCandidateList)
				{
					//here
					if(companyId.equals(placedCandidate.getCompanyId()))
					{
						for(Candidate candidate:candidateList)
						{
							if(candidate.getCandidatePersonal().getCandidateId().equals(placedCandidate.getCandidateId()))
							{
								placedCandidatesName.add(candidate.getCandidatePersonal().getCandidateName());
							}
						}

					}


				}
			}
		}
		return placedCandidatesName;
	}

	@Override
	public ArrayList<String> pCountDesignation(String designation)
			throws RecruitmentException {

		ArrayList<PlacedCandidate> placedCandidateList=pcdao.searchPlaced();
		ArrayList<String> placedCandidatesName=new ArrayList<>();
		ArrayList<Candidate>  candidateList=pcdao.listAllCandidate();
		for(PlacedCandidate placedCandidate:placedCandidateList)
		{
			String candidateId;
			if(placedCandidate.getDesignation().equalsIgnoreCase(designation))
			{
				candidateId=placedCandidate.getCandidateId();
				for(Candidate candidate:candidateList)
				{
					if(candidate.getCandidatePersonal().getCandidateId().equals(candidateId))
					{
						placedCandidatesName.add(candidate.getCandidatePersonal().getCandidateName());
					}
				}
			}
		}

		return placedCandidatesName;
	}
}

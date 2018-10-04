package com.cg.rms.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.Company;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.util.DBUtil;

public class CompanyUserDAOImpl implements CompanyUserDAO {
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	@Override
	public String registerCompany(CompanyMaster companyMaster)
			throws RecruitmentException {
		
		try {
			con=DBUtil.getConn();
			
			String query="insert into Company_Master values (?,?,?,?,?,?)";
			pst=con.prepareStatement(query);
			pst.setString(1,companyMaster.getCompanyId());
			pst.setString(2,companyMaster.getCompanyName());
			pst.setString(3,companyMaster.getCompanyAddress());
			pst.setString(4,companyMaster.getContactPerson());
			pst.setString(5,companyMaster.getEmailId());
			pst.setString(6,companyMaster.getContactNumber());
			
			int status=pst.executeUpdate();
			if(status==1)
			{
				return companyMaster.getCompanyId();
			}
			else
			{
				return "Not Inserted";
			}	
		} catch (Exception e) {
			throw new RecruitmentException(e.getMessage());
		}
		finally 
		{
			try {
				con.close();
				//rs.close();
				pst.close();
			}
			catch (Exception e)
			{
				throw new RecruitmentException(e.getMessage());
			}
		}
	}

	@Override
	public String postJobRequirement(JobRequirements jobRequirement)
			throws RecruitmentException {
		try {
			con=DBUtil.getConn();
			
			String query="insert into Job_Requirements into (job_id,Company_id,Position_required,Numbers_required,Experience_required,Qualification_required,Job_location,Job_description)values (job_id.nextVAl,?,?,?,?,?,?,?)";//sequence for job id
			pst=con.prepareStatement(query);
			pst.setString(1,jobRequirement.getCompanyId());
			pst.setString(2,jobRequirement.getPositionRequired());
			pst.setInt(3,jobRequirement.getNumbersRequired());
			pst.setInt(4,jobRequirement.getExperienceRequired());
			pst.setString(5,jobRequirement.getQualificationRequired());
			pst.setString(6,jobRequirement.getJobLocation());
			pst.setString(7,jobRequirement.getJobDescription());
			
			int status=pst.executeUpdate();
			if(status==1)
			{
				return "1";
			}
			else
			{
				return "Not Inserted";
			}	
		} catch (Exception e) {
			throw new RecruitmentException(e.getMessage());
		}
		finally 
		{
			try {
				con.close();
				rs.close();
				pst.close();
			}
			catch (Exception e)
			{
				throw new RecruitmentException(e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<CompanyMaster> getCompanyDetails() throws RecruitmentException {
		ArrayList<CompanyMaster> companyList=new ArrayList<CompanyMaster>();
		CompanyMaster company=new CompanyMaster();
		
			try {
				con=DBUtil.getConn();
				String selectqry1="SELECT *FROM Company_master";
				st=con.createStatement();
				rs=st.executeQuery(selectqry1);
				while(rs.next())
				{
					company=new CompanyMaster(rs.getString(1),rs.getString(2),
							rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6));
					companyList.add(company);
							
				}
			
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return companyList;
	}



	@Override
	public ArrayList<Candidate> listAllCandidate() throws RecruitmentException {
		ArrayList<Candidate> candidateList=new ArrayList<>();
		try {			
			con=DBUtil.getConn();
			//conditions
			st=con.createStatement();
			String query1="select * from candidate_personal";
			rs1=st.executeQuery(query1);
			st=con.createStatement();
			String query2="select * from candidate_qualifications";
			rs2=st.executeQuery(query2);
			st=con.createStatement();
			String query3="select * from candidate_work_history";
			rs3=st.executeQuery(query3);
			while(rs1.next())
			{
				Candidate candidate=new Candidate();
				candidate.setCandidatePersonal( new CandidatePersonal(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4).toLocalDate(),rs1.getString(5),rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9)));
				while(rs2.next())
				{
					if(candidate.getCandidatePersonal().getCandidateId().equalsIgnoreCase(rs2.getString(8)))
					{
						candidate.setCandidateQualifications(new CandidateQualifications(rs2.getString(1), rs2.getString(2),rs2.getString(3),rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getDouble(7),rs2.getString(8)));
						break;
					}
				}
				while(rs3.next())
				{
					if(candidate.getCandidatePersonal().getCandidateId().equalsIgnoreCase(rs3.getString(2)))
					{
						candidate.setCandidateWorkHistory(new CandidateWorkHistory(rs3.getString(1),
								rs3.getString(2),rs3.getString(3),rs3.getString(4),rs3.getString(5),
								rs3.getString(6), rs3.getDate(7).toLocalDate(),rs3.getDate(8).toLocalDate(),
								rs3.getString(9),rs3.getString(10), rs3.getString(11), rs3.getString(12)));
						break;
					}
				}
				candidateList.add(candidate);
			}	
			return candidateList;	
	
		} catch (Exception e) {
			throw new RecruitmentException(e.getMessage());
		}
		finally 
		{
			try {
				con.close();
				rs1.close();
				rs2.close();
				rs3.close();
				st.close();
			}
			catch (Exception e)
			{
				throw new RecruitmentException(e.getMessage());
			}
		}
	}
	
	

}

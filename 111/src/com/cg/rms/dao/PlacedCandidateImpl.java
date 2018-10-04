package com.cg.rms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.PlacedCandidate;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.util.DBUtil;

public class PlacedCandidateImpl implements PlacedCandidateDAO {
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	@Override
	public ArrayList<PlacedCandidate> searchPlaced() throws RecruitmentException
	{	
		ArrayList<PlacedCandidate> candidateList=new ArrayList<PlacedCandidate>();
		try{
			con=DBUtil.getConn();
		st=con.createStatement();
		String query1="select * from placed_candidate";
		rs=st.executeQuery(query1);
		while(rs.next())
		{
			PlacedCandidate candidate=new PlacedCandidate(rs.getString(1),
					rs.getString(2),
					rs.getString(3)
					,rs.getString(4));
			candidateList.add(candidate);
		
		}
	}
		
	 catch (Exception e)
		{
		throw new RecruitmentException(e.getMessage());
		}
	finally 
			{
			try {
				con.close();
				rs.close();
				st.close();
				}
				catch (Exception e)
				{
						throw new RecruitmentException(e.getMessage());
				}
			}
		return candidateList;
 		}
	
	
	@Override
	public ArrayList<Candidate> listAllCandidate() throws RecruitmentException {
		ArrayList<Candidate> candidateList=new ArrayList<>();
		try {			
			con=DBUtil.getConn();
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
	
	@Override
	public ArrayList<CompanyMaster> getAllCompanies() throws RecruitmentException {
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

}

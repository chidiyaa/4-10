package com.cg.rms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.Company;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.util.DBUtil;

public class CandidateDAOImpl implements CandidateDAO {
	
	
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	ResultSet rs3=null;

	@Override
	public int addResume(Candidate candidate) throws RecruitmentException {
		
		int data1;
		int data2,data3;
		try {
			con=DBUtil.getConn();
			String insertQuery="INSERT INTO CANDIDATE_PERSONAL VALUES(?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertQuery);
			pst.setString(1,candidate.getCandidatePersonal().getCandidateId());
			pst.setString(2,candidate.getCandidatePersonal().getCandidateName());
			pst.setString(3,candidate.getCandidatePersonal().getAddress());
			pst.setDate(4, java.sql.Date.valueOf( candidate.getCandidatePersonal().getDob()));
			pst.setString(5,candidate.getCandidatePersonal().getEmailId());
			pst.setString(6,candidate.getCandidatePersonal().getContactNumber());
			pst.setString(7,candidate.getCandidatePersonal().getMaritalStatus());
			pst.setString(8,candidate.getCandidatePersonal().getGender());
			pst.setString(9,candidate.getCandidatePersonal().getPassportNumber());
			data1=pst.executeUpdate();
			
			String insertQuery1="INSERT INTO CANDIDATE_QUALIFICATIONS VALUES(?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertQuery1);
			pst.setString(1,candidate.getCandidateQualifications().getQualificationId());
			pst.setString(2,candidate.getCandidateQualifications().getQualificationName());
			pst.setString(3,candidate.getCandidateQualifications().getSpecializationArea());
			pst.setString(4, candidate.getCandidateQualifications().getCollegeName());
			pst.setString(5,candidate.getCandidateQualifications().getUniversityName());
			pst.setString(6,candidate.getCandidateQualifications().getYearOfpassing());
			pst.setDouble(7,candidate.getCandidateQualifications().getPercentage());
			pst.setString(8,candidate.getCandidateQualifications().getCandidateId());
			data2=pst.executeUpdate();
			String insertQuery3="INSERT INTO CANDIDATE_WORK_HISTORY VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertQuery3);
			pst.setString(1,candidate.getCandidateWorkHistory().getWorkId());
			pst.setString(2,candidate.getCandidateQualifications().getCandidateId());
			pst.setString(3,candidate.getCandidateWorkHistory().getWhichEmployer());
			pst.setString(4, candidate.getCandidateWorkHistory().getContactPerson());
			pst.setString(5,candidate.getCandidateWorkHistory().getPositionHeld());
			pst.setString(6,candidate.getCandidateWorkHistory().getCompanyName());
			pst.setDate(7, java.sql.Date.valueOf(candidate.getCandidateWorkHistory().getEmploymentFrom()));
			pst.setDate(8,java.sql.Date.valueOf(candidate.getCandidateWorkHistory().getEmploymentTo()));
			pst.setString(9,candidate.getCandidateWorkHistory().getReasonForLeaving());
			pst.setString(10,candidate.getCandidateWorkHistory().getResponsibilities());
			pst.setString(11,candidate.getCandidateWorkHistory().getHrRepName());
			pst.setString(12,candidate.getCandidateWorkHistory().getHrRepContactNum());
			
			data3=pst.executeUpdate();
			return data1+data2+data3;//remove this
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
			throw new RecruitmentException(e.getMessage());
		}

		
		
		
	}

	@Override
	public int modifyResume(Candidate candidate,String candidateId) throws RecruitmentException {
		
		int data1;
		int data2,data3;
		try {
			con=DBUtil.getConn();
			String updateQuery="UPDATE CANDIDATE_PERSONAL SET"
					+ "candidate_name=?,"
					+ "address=?,dob=?,email_id=?,contact_number=?,"
					+ "Marital_status=?,Gender=?,Passport_number=?,WHERE candidate_id="+candidateId;
			pst=con.prepareStatement(updateQuery);
		//	pst.setString(,candidate.getCandidateQualifications().getCandidateId());
			pst.setString(1,candidate.getCandidatePersonal().getCandidateName());
			pst.setString(2,candidate.getCandidatePersonal().getAddress());
			pst.setDate(3, java.sql.Date.valueOf (candidate.getCandidatePersonal().getDob()));
			pst.setString(4,candidate.getCandidatePersonal().getEmailId());
			pst.setString(5,candidate.getCandidatePersonal().getContactNumber());
			pst.setString(6,candidate.getCandidatePersonal().getMaritalStatus());
			pst.setString(7,candidate.getCandidatePersonal().getGender());
			pst.setString(8,candidate.getCandidatePersonal().getPassportNumber());
			data1=pst.executeUpdate();
			String updateQuery1="UPDATE CANDIDATE_QUALIFICATIONS SET qualification_id=?,"
					+ "qualification_name=?,"
					+ "specialization_area=?,college_name=?,university_name=?,"
					+ "year_of_passing=?,percentage=?,WHERE candidate_id="+candidateId;
			pst=con.prepareStatement(updateQuery1);
			pst.setString(1,candidate.getCandidateQualifications().getQualificationId());
			pst.setString(2,candidate.getCandidateQualifications().getQualificationName());
			pst.setString(3,candidate.getCandidateQualifications().getSpecializationArea());
			pst.setString(4, candidate.getCandidateQualifications().getCollegeName());
			pst.setString(5,candidate.getCandidateQualifications().getUniversityName());
			pst.setString(6,candidate.getCandidateQualifications().getYearOfpassing());
			pst.setDouble(7,candidate.getCandidateQualifications().getPercentage());
			//pst.setString(8,candidate.getCandidateQualifications().getCandidateId());
			data2=pst.executeUpdate();
			String updateQuery3="UPDATE CANDIDATE_WORK_HISTORY SET "
					+ "work_id =?,candidate_id=?,Which_employer=?,contact_person=?,"
					+ "Position_held=?,Company_name=?,Employment_from=?,Employment_to=?,"
					+ "Reason_For_leaving=?,Responsibilities=?,Hr_rep_name=?,"
					+ "Hr_rep_contact_num=?,WHERE candidate_id="+candidateId;
			pst=con.prepareStatement(updateQuery3);
			pst.setString(1,candidate.getCandidateWorkHistory().getWorkId());
			//pst.setString(2,candidate.getCandidateQualifications().getCandidateId());
			pst.setString(2,candidate.getCandidateWorkHistory().getWhichEmployer());
			pst.setString(3, candidate.getCandidateWorkHistory().getContactPerson());
			pst.setString(4,candidate.getCandidateWorkHistory().getPositionHeld());
			pst.setString(5,candidate.getCandidateWorkHistory().getCompanyName());
			pst.setDate(6,java.sql.Date.valueOf(candidate.getCandidateWorkHistory().getEmploymentFrom()));
			pst.setDate(7,java.sql.Date.valueOf(candidate.getCandidateWorkHistory().getEmploymentTo()));
			pst.setString(8,candidate.getCandidateWorkHistory().getReasonForLeaving());
			pst.setString(9,candidate.getCandidateWorkHistory().getResponsibilities());
			pst.setString(10,candidate.getCandidateWorkHistory().getHrRepName());
			pst.setString(11,candidate.getCandidateWorkHistory().getHrRepContactNum());
			
			data3=pst.executeUpdate();
			return data1+data2+data3;//remove this
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
			throw new RecruitmentException(e.getMessage());
		}

	}

	/*@Override
	public ArrayList<Candidate> viewResum(int candidateId) throws RecruitmentException {
		ArrayList<Candidate> candidateList=new ArrayList<Candidate>();
		Candidate candidate=new Candidate();
		try
		{
			con=DBUtil.getConn();
			String selectqry1="SELECT *FROM CANDIDATE_PERSONAL WHERE  candidate_id= candidateId";
			st=con.createStatement();
			rs=st.executeQuery(selectqry1);
			while(rs.next())
			{
				candidate.setCandidatePersonal(new CandidatePersonal(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getDate(4),
						rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9)));
				candidateList.add(candidate);
						
			}
			String selectqry2="SELECT *FROM CANDIDATE_QUALIFICATIONS WHERE  candidate_id= candidateId";
			//st=con.createStatement();
			rs2=st.executeQuery(selectqry2);
			while(rs2.next())
			{
				candidate.setCandidateQualifications(new CandidateQualifications(rs2.getString(1),rs2.getString(2),
						rs2.getString(3),rs2.getString(4),
						rs2.getString(5),rs2.getString(6),rs2.getDouble(7),
						rs2.getString(8)));
				candidateList.add(candidate);
				
						
			}
			String selectqry3="SELECT *FROM CANDIDATE_WORK_HISTORY WHERE  candidate_id= candidateId";
			rs3=st.executeQuery(selectqry3);
			while(rs3.next())
			{
				candidate.setCandidateWorkHistory(new CandidateWorkHistory(rs3.getString(1),rs3.getString(2),
						rs3.getString(3),rs3.getString(4),
						rs3.getString(5),rs3.getString(6),rs3.getDate(7).toLocalDate(),
						rs3.getDate(8).toLocalDate(),rs3.getString(9),rs3.getString(10),rs3.getString(11),rs3.getString(12)));
						
				candidateList.add(candidate);
			
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw new RecruitmentException(e.getMessage());
		}
		finally
		{
			try {
				st.close();
				rs.close();
				con.close();
			}
			catch (SQLException e) {

				throw new RecruitmentException(e.getMessage());
			}

		}
		
		
		return candidateList;
		
		
	
	}
	*/
	@Override
	public int applyForJob(String jobId,String candidateId )
			throws RecruitmentException {
		int data=0;
		try {
			con=DBUtil.getConn();
			String insertQuery="INSERT INTO JOB_APPLIED VALUES(?,?)";
			pst.setString(1, jobId);
			pst.setString(2,candidateId);
			pst=con.prepareStatement(insertQuery);
			data=pst.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		return data;
	}
	@Override
	public ArrayList<JobRequirements> getJobRequirements() throws RecruitmentException
	{
		ArrayList<JobRequirements> jobReqList=new ArrayList<JobRequirements>();
		//JobRequirements company=new JobRequirements();
		try
		{
			con=DBUtil.getConn();
			String selectqry1="SELECT *FROM Job_Requirements ";
			st=con.createStatement();
			rs=st.executeQuery(selectqry1);
			while(rs.next())
			{
				JobRequirements company=new JobRequirements(rs.getString(1),rs.getString(2),
					rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
				
						
				jobReqList.add(company);
			}
	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw new RecruitmentException(e.getMessage());
		}
		finally
		{
			try {
				st.close();
				rs.close();
				con.close();
			}
			catch (SQLException e) {

				throw new RecruitmentException(e.getMessage());
			}
	}
		
		return jobReqList;
}
	@Override
    public ArrayList<CandidatePersonal> viewResume() throws RecruitmentException {
        ArrayList<CandidatePersonal> candidateList=new ArrayList<CandidatePersonal>();
        //CandidatePersonal candidate1=new CandidatePersonal();
        try
        {
            con=DBUtil.getConn();
            String selectqry1="SELECT *FROM CANDIDATE_PERSONAL";
            st=con.createStatement();
            rs=st.executeQuery(selectqry1);
            while(rs.next())
            {
                CandidatePersonal candidate1=new CandidatePersonal(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getDate(4).toLocalDate(),
                        rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9));
                candidateList.add(candidate1);
            }

        }   catch(Exception e)
        {

            e.printStackTrace();
            throw new RecruitmentException(e.getMessage());
        }
        finally
        {
            try {
                st.close();
                rs.close();
                con.close();
            }
            catch (SQLException e) {

                throw new RecruitmentException(e.getMessage());
            }

        }


        return candidateList;



    }
    @Override
    public ArrayList<CandidateQualifications> viewResume1() throws RecruitmentException {
        ArrayList<CandidateQualifications> candidateList=new ArrayList<CandidateQualifications>();
        //CandidatePersonal candidate1=new CandidatePersonal();
        try
        {
            con=DBUtil.getConn();
            st=con.createStatement();
            
            
    String selectqry2="SELECT *FROM CANDIDATE_QUALIFICATIONS";
    //st=con.createStatement();
    rs2=st.executeQuery(selectqry2);
    while(rs2.next())
    {
        CandidateQualifications candidate=new CandidateQualifications(rs2.getString(1),rs2.getString(2),
                rs2.getString(3),rs2.getString(4),
                rs2.getString(5),rs2.getString(6),rs2.getDouble(7),
                rs2.getString(8));
        candidateList.add(candidate);

    }
        }

        catch(Exception e)
    {

        e.printStackTrace();
        throw new RecruitmentException(e.getMessage());
    }
    


    return candidateList;



}
    @Override
    public ArrayList<CandidateWorkHistory> viewResume2() throws RecruitmentException {
        ArrayList<CandidateWorkHistory> candidateList=new ArrayList<CandidateWorkHistory>();
        //CandidatePersonal candidate1=new CandidatePersonal();
        try
        {
            con=DBUtil.getConn();
            st=con.createStatement();
            
    String selectqry3="SELECT *FROM CANDIDATE_WORK_HISTORY";
    rs3=st.executeQuery(selectqry3);
    while(rs3.next())
    {
        CandidateWorkHistory candidate=new CandidateWorkHistory(rs3.getString(1),rs3.getString(2),
                rs3.getString(3),rs3.getString(4),
                rs3.getString(5),rs3.getString(6),rs3.getDate(7).toLocalDate(),
                rs3.getDate(8).toLocalDate(),rs3.getString(9),rs3.getString(10),rs3.getString(11),rs3.getString(12));
                candidateList.add(candidate);   
    }
}
catch(Exception e)
{

    e.printStackTrace();
    throw new RecruitmentException(e.getMessage());
}



return candidateList;
}		
}
	



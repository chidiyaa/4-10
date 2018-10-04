package com.cg.rms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.rms.beans.User;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.util.DBUtil;

public class LoginDAOImpl implements LoginDAO {

	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public String signUp(User user) throws RecruitmentException{ //Insert New User
		try {
			con=DBUtil.getConn();
			
			
			String query="insert into users (username,password,usertype,id) values (?,?,?,idseq.nextval)";   // Sequence Generation for column no. 4 ID
			pst=con.prepareStatement(query);
			
			pst.setString(1,user.getUserName());
			pst.setString(2,user.getPassword());
			pst.setString(3,user.getTypeUser());
			System.out.println("sadadsa");
			int status=pst.executeUpdate();
			System.out.println("truyrytrytry");
			if(status==1)
			{
				System.out.println("dddddd");
				return "1";//return current value
			}
			else
			{
				System.out.println("pppp");
				return "Problem with registering account";
			}	
			
		} catch ( SQLException | IOException e) {
			// TODO Auto-generated catch block
			throw new RecruitmentException(e.getMessage());
		}
		finally 
		{
			try {
				con.close();
				pst.close();
			}
			catch (Exception e)
			{
				throw new RecruitmentException(e.getMessage());
			}
		}
		
		
		
		
		
	}

	@Override
	public User login(String userName, String password) throws RecruitmentException{   //Search User
		try {
			con=DBUtil.getConn();
			
			
			String query="select * from users where username=? and password=?";
			pst=con.prepareStatement(query);
			pst.setString(1,userName);
			pst.setString(2,password);
			
			rs=pst.executeQuery();
			rs.next();
			if(rs==null)
			{
				return null;
			}
			else
			{
			User user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			return user;
			}
			
		} catch ( SQLException | IOException e) {
			// TODO Auto-generated catch block
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

}

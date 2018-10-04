package com.cg.rms.util;
import java.sql.*;
import java.io.*;
import java.util.*;
public class DBUtil {
	static String driver=null;
	static String url=null;
	static String unm=null;
	static String pwd=null;
	
	
	public static Connection getConn() throws SQLException,IOException
	{
		Properties myProps=loadDBInfo();
		driver=myProps.getProperty("dbDriver");
		url=myProps.getProperty("dbUrl");
		unm=myProps.getProperty("dbUser");
		pwd=myProps.getProperty("dbPassword");
		Connection con=null;
		if(con==null)
		{
			con=DriverManager.getConnection(url,unm,pwd);
			return con;
		}
		else
		{
			return con;
		}
	}
	public static Properties loadDBInfo() throws IOException
	{
		FileReader fr=new FileReader("dbInfo.properties");
		Properties dbProps=new Properties();
		dbProps.load(fr);
		return dbProps;
		
	}

}

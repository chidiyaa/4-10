package com.cg.rms.ui;

import java.text.ParseException;
import java.util.Scanner;

import com.cg.rms.beans.User;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.service.CandidateServiceImpl;
import com.cg.rms.service.CompanyServiceImpl;
import com.cg.rms.service.LoginService;
import com.cg.rms.service.LoginServiceImpl;
import com.cg.rms.service.PlacedCandidateServiceImpl;

public class LoginUIImpl implements LoginUI {

	Scanner sc = new Scanner(System.in);
	static int loginAttempt=3;
	static LoginService loginService=new LoginServiceImpl();
	static CandidateUIImpl candidateUI=new CandidateUIImpl();
	static AdminUIImpl adminUI=new AdminUIImpl();
	static CompanyUIImpl companyUI=new CompanyUIImpl();


	@Override
	public void login() throws ParseException {
		System.out.println("-------Login Here------");
		System.out.println("Enter userID");
		String userName = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();	
		try {
			User user = loginService.login(userName, password);//    Service Layer Call
			if(user==null)
			{
				System.out.println("ID Password Does Not Match");
				loginAttempt--;
				if(loginAttempt > 0)
				{
					System.out.println("You Have "+loginAttempt+" Login Attempts Left");
					login();//stack
				}
				else
				{
					System.out.println("You Are Being Taken Back To Main Menu");
					loginAttempt=3;
					showMenu();
				}
			}
			else
			{
				System.out.println("Successfully Logged In");   // to be removed
				if(user.getTypeUser().equals("candidate"))
				{
					candidateUI.showCandidateMenu(user.getId());
				}
				else if(user.getTypeUser().equals("company"))
				{
					companyUI.showCompanyMenu(user.getId());
				}
				else
				{
					adminUI.showAdminMenu(user.getId());
				}
			}


		}

		catch (RecruitmentException e) {
			e.printStackTrace();
		}




	}

	@Override
	public void showMenu()  {
		// TODO Auto-generated method stub

		System.out.println("Welcome To Recruitment  Management System");
		System.out.println("Please Choose Any Option");
		System.out.println("1. Login");
		System.out.println("2. Signup");
		System.out.println("3. Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			try {
				login();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			signUp();
			break;
		case 3:
			System.out.println("You Selected Exit, Program Will Terminate Bye");
			System.exit(0);
			break;

		default:
			System.out.println("Invalid Choice! Please Try Again");
			break;
		}






	}

	@Override
	public void signUp()   {
		System.out.println("-----Sign Up here-----");
		System.out.println("User Name");
		String userName=sc.next();
		System.out.println("Enter Password ");
		String password=sc.next();
		System.out.println("Enter User Type ");
		String userType=sc.next();
		try
		{
			User user=new User(userName,password,userType);
			String userId=loginService.signUp(user);
			User user1=loginService.login(userName, password);
			System.out.println("You have successfully Registered and your ID is "+userId);
			if(user.getTypeUser().equals("candidate"))
			{
				candidateUI.showCandidateMenu(user1.getId());
				
			}
			else if(user.getTypeUser().equals("company"))
			{
				companyUI.showCompanyMenu(user1.getId());
			}
			else
			{
				adminUI.showAdminMenu(user1.getId());
			}	
		}
		catch(RecruitmentException e)
		{
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}

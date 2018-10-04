package com.cg.rms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.service.PlacedCandidateService;
import com.cg.rms.service.PlacedCandidateServiceImpl;
//import com.cg.rms.service.ValidationService;
public class AdminUIImpl implements AdminUI{
    static PlacedCandidateService pcService=null;
    @Override
    public void countpcposition(String designation) {
        ArrayList<String> placedCandidatenames=new ArrayList<String>();
        int i=0;
        try {
        	placedCandidatenames=pcService.pCountDesignation(designation);
        	System.out.println("Total Candidates Placed as designation are:\n");
           for(String names:placedCandidatenames)
           {
        	   i++;
        	   System.out.println(i+"."+names);
           }
           
           } catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    @Override
    public void countpccompany(String Company) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> placedCandidatenames=new ArrayList<String>();
        int i=0;
        try {
        	placedCandidatenames=pcService.pCountCompany(Company);
        	System.out.println("Total Candidates Placed in Month are:\n");
            for(String names:placedCandidatenames)
            {
         	   i++;
         	   System.out.println(i+"."+names);
            }
        } catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public void countpcmonth(String month) {
        ArrayList<String> placedCandidatenames=new ArrayList<String>();
       int i=0;
        try {
           
        	placedCandidatenames=pcService.pCountMonth(month);
        	System.out.println("Total Candidates Placed in Month are:\n");
           for(String names:placedCandidatenames)
           {
        	   i++;
        	   System.out.println(i+"."+names);
           }
        } catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public void showAdminMenu(String id) throws RecruitmentException
    {
    	System.out.println("1.Count of individuals  placed in a particular month\n"
        		+"2.Count of individuals  placed in a particular company\n"
        		+"3.Count of individuals placed in a particular position(designation)\n"
        		+"4.Exit"); 
    	Scanner sc=new Scanner(System.in);
    	int choice=0;
    	choice=sc.nextInt();
    	PlacedCandidateServiceImpl placedcandidateService=new PlacedCandidateServiceImpl();
		switch(choice)
		{
		case 1: System.out.println("Enter month");
		String month =sc.next();
		placedcandidateService.pCountMonth(month);break;
		case 2: System.out.println("Enter company");
		String company =sc.next();
		placedcandidateService.pCountCompany(company);break;
		case 3:System.out.println("Enter designation");
		String designation =sc.next();
			placedcandidateService.pCountDesignation(designation);break;
		case 4:System.exit(0); break;
		default:System.out.println("Invalid input");
		}
		showAdminMenu(id);
    	}
    
    }

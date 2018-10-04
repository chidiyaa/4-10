package com.cg.rms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.Company;
import com.cg.rms.beans.CompanyMaster;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.service.CompanyService;
import com.cg.rms.service.CompanyServiceImpl;
//import com.cg.rms.service.ValidationService;

public class CompanyUIImpl implements CompanyUI{
    static CompanyService cService=new CompanyServiceImpl() ;
   /* public static void main(String[] args) throws RecruitmentException{
        String uname;
        String password;
        System.out.println("****Enter Company Username*****");
        Scanner sc=new Scanner(System.in);
        uname=sc.next();
        System.out.println("****Enter Company Password*****");
        password=sc.next();
        ValidationService vService=new ValidationService();
        boolean validatelogin=vService.validateAdmin(uname,password);//rename method
        while(true){
            System.out.println("Welcome.....");
            System.out.println("What do you want to do?");
            System.out.println(" 1:Register  company details  \n "
                    + "2:Post job requirements \n "
                    + "3:Search candidates based on qualification, position,years of experience\n"+
                     " 4:Exit");
            System.out.println("Enter ur choice");
            int choice=0;
            choice=sc.nextInt();
            cService=new CompanyServiceImpl();
            switch(choice)
            {
            case 1:regCompDetails(); break;
            case 2:postJobReq();break;
            case 3:searchCandidate();break;
            case 4:System.exit(0);
default:System.out.println("Invalid input");

            }
            }
        
    }*/
    @Override
    public void regCompDetails(String id) {
        Scanner sc=new Scanner(System.in);
         String companyName;
        String companyAddress;
         String contactPerson;
     String emailId;
         String contactNumber;
         Company company=new Company();

        try {
           
             System.out.println("Enter company name");
             companyName =sc.next();
             System.out.println("Enter company address");
             companyAddress =sc.next();
             System.out.println("Enter  contact person");
             contactPerson=sc.next();
             System.out.println("Enter  company email-id");
             emailId=sc.next();
             System.out.println("Enter  contact number");
             contactNumber=sc.next();
             CompanyMaster com=new CompanyMaster(id,companyName,companyAddress,contactPerson,emailId,contactNumber);
             company.setCompanyMaster(com);
            String c= cService.registerCompany(com);
             
            System.out.println("Successfully registered....Your Company ID is"+c);
        } catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public void postJobReq(String id) {
        Scanner sc=new Scanner(System.in);
         String jobId;
        String positionRequired;
        int numbersRequired;
        int experienceRequired;
        String qualificationRequired;
        String jobLocation;
         String jobDescription;
         Company company=new Company();
        try {
           
             System.out.println("Enter position required");
             positionRequired =sc.next();
             System.out.println("Enter  vacancies");
             numbersRequired=sc.nextInt();
             System.out.println("Enter experience required");
             experienceRequired=sc.nextInt();
             System.out.println("Enter qualification required");
             qualificationRequired=sc.nextLine();
             System.out.println("Enter job location");
             jobLocation=sc.next();
             System.out.println("Enter job description");
             jobDescription=sc.nextLine();
             JobRequirements jobreq=new JobRequirements("jobId",id,positionRequired,numbersRequired,experienceRequired,qualificationRequired,jobLocation,jobDescription);
             company.setJobRequirements(jobreq);
             String s=cService.postJobRequirement(jobreq);
 
            System.out.println("Successfully  Job requirements are added...."+s);
        } catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public void searchCandidate() {
        Scanner sc=new Scanner(System.in);
        ArrayList<CandidatePersonal> cList;
        int experienceRequired;
        String qualificationRequired;
        String positionRequired;
        try {
        System.out.println("Enter experience required");
         experienceRequired=sc.nextInt();
         System.out.println("Enter qualification required");
         qualificationRequired=sc.nextLine();
         System.out.println("Enter position required");
         positionRequired =sc.next();
         cList=cService.SearchByCompany(positionRequired, experienceRequired, qualificationRequired);
         System.out.println("\t CandidateId  \t candidateName  \t emailId \t contactNumber \t gender ");
            for(CandidatePersonal cc:cList)
            {
                System.out.println("\t"+cc.getCandidateId()+"\t"+cc.getCandidateName()+"\t"+cc.getEmailId()+"\t"+cc.getContactNumber()+"\t"+cc.getGender());
            }
        }
         catch (RecruitmentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
    @Override
    public void showCompanyMenu(String id)
    {
    	
    	System.out.println("1.Register Compnay Details\n"
    			+ "2.PostJobRequirements\n"
    			+ "3.Search Candidate based on Experience Required,"
    			+ "Qualification required,Position Required\n"
    			+ "4.Exit.");
    	Scanner sc=new Scanner(System.in);
    	int choice=0;
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:regCompDetails(id);break;
		case 2:postJobReq(id);break;
		case 3:searchCandidate();break;
		case 4:System.exit(0); break;
		default:System.out.println("Invalid input");
		}
		showCompanyMenu(id);
    }
}
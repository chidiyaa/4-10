package com.cg.rms.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.cg.rms.beans.Candidate;
import com.cg.rms.beans.CandidatePersonal;
import com.cg.rms.beans.CandidateQualifications;
import com.cg.rms.beans.CandidateWorkHistory;
import com.cg.rms.beans.JobRequirements;
import com.cg.rms.beans.User;
import com.cg.rms.exception.RecruitmentException;
import com.cg.rms.service.CandidateService;
import com.cg.rms.service.CandidateServiceImpl;
import com.cg.rms.service.CompanyService;
import com.cg.rms.service.CompanyServiceImpl;
//import com.cg.rms.service.ValidationService;

public class CandidateUIImpl implements CandidateUI{
    Candidate candidate=new Candidate();
    static CandidateService candidateService=null;
    LoginUI loginUI=new LoginUIImpl();
    
    @Override
    public void applyJobs(String candidateId) throws RecruitmentException {
        // TODO Auto-generated method stub
        String jobId;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter jobid of job you want to apply");
        jobId=sc.next();
        int data=candidateService.applyForJob(jobId, candidateId);
        if(data==1){System.out.println("You have successfully applied ...");}
        else{System.out.println("Unsuccesfull...try again");}

    }
    @Override
    public  void searchJobs() throws RecruitmentException {
        // TODO Auto-generated method stub
        String qualification;
        String position;
        int experience;
        String location;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your qualification ");
        qualification=sc.next();
        System.out.println("Enter positon to search");
        position=sc.next();
        System.out.println("Enter your experience");
        experience=sc.nextInt();
        System.out.println("Enter prefered location");
        location=sc.next();
        ArrayList<JobRequirements> jobReq=new ArrayList<JobRequirements>();
        jobReq=candidateService.search(qualification, position, experience, location);
        System.out.println("\t jobId  \t companyId  \t positionRequired \t numbersRequired \t experienceRequired \t qualificationRequired \t jobLocation \tjobDescription");
           for(JobRequirements cc:jobReq)
           {
               System.out.println("\t"+cc.getJobId()+"\t"+cc.getCompanyId()+"\t"+cc.getPositionRequired()+"\t"+cc.getExperienceRequired()+"\t"+cc.getQualificationRequired()+"\t"+cc.getJobLocation()+"\t"+cc.getJobDescription());
           }
    }
    @Override
    public  void modifyResume(String id) throws ParseException, RecruitmentException {
        // TODO Auto-generated method stub
    
        Scanner sc=new Scanner(System.in);
        
        //String candidateId;
        String candidateName;
        String address;
        LocalDate dob;
        String emailId;
        String contactNumber;
        String maritalStatus;
        String gender;
        String passportNumber;

        String qualificationId;
        String qualificationName;
        String specializationArea;
        String collegeName;
        String universityName;
        String yearOfpassing;
        double percentage;

        String workId;
        String whichEmployer;
        String contactPerson;
        String positionHeld;
        String companyName;
        LocalDate employmentFrom;
        LocalDate employmentTo;
        String reasonForLeaving;
        String responsibilities;
        String hrRepName;
        String hrRepContactNum;
        System.out.println("Enter the details to modify");
        System.out.println("Enter your personal details....");
        System.out.println("Enter candidate name");
        candidateName=sc.next();
        System.out.println("Enter address");
        address=sc.next();
        System.out.println("Enter date of birth");
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter date in dd/MM/yyyy format:");
		String input=scanner.nextLine();
		dob=LocalDate.parse(input,formatter);
        System.out.println("Enter email id");
        emailId=sc.next();
        System.out.println("Enter contact number");
        contactNumber=sc.next();
        System.out.println("Enter marital status");
        maritalStatus=sc.next();
        System.out.println("Enter gender");
        gender=sc.next();
        System.out.println("Enter passport number");
        passportNumber=sc.next();
        
        CandidatePersonal personal=new CandidatePersonal(id,candidateName,address,dob,emailId,contactNumber,maritalStatus,gender,passportNumber);
        // candidate.setCandidatePersonal(new CandidatePersonal(candidateName,address,dob1,emailId,contactNumber,maritalStatus,gender,passportNumber));
        
        System.out.println("Enter your educational qualifications....");
        System.out.println("Enter qualification Id");
        qualificationId=sc.next();
        System.out.println("Enter qualificaion name");
        qualificationName=sc.nextLine();
        System.out.println("Enter Specialization Area");
        specializationArea=sc.nextLine();
        System.out.println("Enter College name");
        collegeName=sc.nextLine();
        System.out.println("Enter university name");
        universityName=sc.nextLine();
        System.out.println("Enter year of passing");
        yearOfpassing=sc.next();
        System.out.println("Enter percentage");
        percentage=sc.nextDouble();
        //candidate.setCandidateQualifications(new CandidateQualifications(qualificationId,qualificationName,specializationArea,collegeName,universityName,yearOfpassing,percentage));
        CandidateQualifications qualifications=new CandidateQualifications(qualificationId,qualificationName,specializationArea,collegeName,universityName,yearOfpassing,percentage,id);
        
        System.out.println("Enter work experience details....");
        System.out.println("Enter work ID");
        workId=sc.next();
        System.out.println("Enter Employer name");
        whichEmployer=sc.next();
        System.out.println("Enter contact person");
        contactPerson=sc.next();
        System.out.println("Enter position held");
        positionHeld=sc.next();
        System.out.println("Enter company name");
        companyName=sc.next();
        System.out.println("Enter employment from in dd/mm/yyyy pattern");
        String empFrom=sc.next();
        DateTimeFormatter format1= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        employmentFrom=LocalDate.parse(empFrom,format1);
        System.out.println("Enter empoyment to in dd/mm/yyyy pattern");
        String empTo=sc.next();
        DateTimeFormatter format2= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        employmentTo=LocalDate.parse(empFrom,format2);
        System.out.println("Enter reason for leaving");
        reasonForLeaving=sc.next();
        System.out.println("Enter responsibilities");
        responsibilities=sc.next();
        System.out.println("Enter hr representative name");
        hrRepName=sc.next();
        System.out.println("Enter hr representative contact number");
        hrRepContactNum=sc.next();
        
        //candidate.setCandidateWorkHistory(new CandidateWorkHistory(workId,whichEmployer,contactPerson,positionHeld,companyName,employmentFrom,employmentTo,reasonForLeaving,responsibilities,hrRepName,hrRepContactNum));
        CandidateWorkHistory workHistory=new CandidateWorkHistory(workId,id,whichEmployer,contactPerson,positionHeld,companyName,employmentFrom,employmentTo,reasonForLeaving,responsibilities,hrRepName,hrRepContactNum);
        Candidate candidate=new Candidate(personal,qualifications,workHistory);
        
        int data=candidateService.modifyResume(candidate,id);
        if(data==3){
            System.out.println("Resume Modified.....");
        }else{
            System.out.println("Resume  could not be Modified.....");
        }


    }
    @Override
    public void addResume(String id) throws RecruitmentException, ParseException {
        Scanner sc=new Scanner(System.in);
        String candidateName;
        String address;
        LocalDate dob;
        String emailId;
        String contactNumber;
        String maritalStatus;
        String gender;
        String passportNumber;

        String qualificationId;
        String qualificationName;
        String specializationArea;
        String collegeName;
        String universityName;
        String yearOfpassing;
        double percentage;

        String workId;
        String whichEmployer;
        String contactPerson;
        String positionHeld;
        String companyName;
        LocalDate employmentFrom;
        LocalDate employmentTo;
        String reasonForLeaving;
        String responsibilities;
        String hrRepName;
        String hrRepContactNum;
        //Candidate candidate=new Candidate();
        try{
            System.out.println("Enter your personal details....");
            System.out.println("Enter candidate name");
            candidateName=sc.next();
            System.out.println("Enter address");
            address=sc.next();
            System.out.println("Enter date of birth");
       			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    			Scanner scanner=new Scanner(System.in);
    			System.out.println("Enter date in dd/MM/yyyy format:");
    			String input=scanner.nextLine();
    			dob=LocalDate.parse(input,formatter);
    			//System.out.println("Entered Date:"+ enteredDate);
    			//scanner.close();
    		
            System.out.println("Enter email id");
            emailId=sc.next();
            System.out.println("Enter contact number");
            contactNumber=sc.next();
            System.out.println("Enter marital status");
            maritalStatus=sc.next();
            System.out.println("Enter gender");
            gender=sc.next();
            System.out.println("Enter passport number");
            passportNumber=sc.next();
            
            
            //personal information retrieve successfully
            
            
            
            CandidatePersonal personal=new CandidatePersonal(id,candidateName,address,dob,emailId,contactNumber,maritalStatus,gender,passportNumber);
            System.out.println(personal);
            System.out.println("Enter your educational qualifications....");
            System.out.println("Enter qualification Id");
            qualificationId=sc.next();
            System.out.println("Enter qualificaion name");
            qualificationName=sc.next();
            System.out.println("Enter Specialization Area");
            specializationArea=sc.next();
            System.out.println("Enter College name");
            collegeName=sc.next();
            System.out.println("Enter university name");
            universityName=sc.next();
            System.out.println("Enter year of passing");
            yearOfpassing=sc.next();
            System.out.println("Enter percentage");
            percentage=sc.nextDouble();
            //candidate.setCandidateQualifications(new CandidateQualifications(qualificationId,qualificationName,specializationArea,collegeName,universityName,yearOfpassing,percentage));
            
            CandidateQualifications qualifications=new CandidateQualifications(qualificationId,qualificationName,specializationArea,collegeName,universityName,yearOfpassing,percentage,id);
            System.out.println("Are you fresher? Enter Yes/No");
            String expChoice=sc.next();
            if(expChoice.equals("No"))
            {
            System.out.println("Enter work experience details....");
            System.out.println("Enter work ID");
            workId=sc.next();
            System.out.println("Enter Employer name");
            whichEmployer=sc.next();
            System.out.println("Enter contact person");
            contactPerson=sc.next();
            System.out.println("Enter position held");
            positionHeld=sc.next();
            System.out.println("Enter company name");
            companyName=sc.next();
            System.out.println("Enter employment from in dd/mm/yyyy pattern");
            String empFrom=sc.next();
            DateTimeFormatter format1= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            employmentFrom=LocalDate.parse(empFrom,format1);
            System.out.println("Enter empoyment to in dd/mm/yyyy pattern");
            String empTo=sc.next();
            DateTimeFormatter format2= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            employmentTo=LocalDate.parse(empFrom,format2);
            System.out.println("Enter reason for leaving");
            reasonForLeaving=sc.next();
            System.out.println("Enter responsibilities");
            responsibilities=sc.next();
            System.out.println("Enter hr representative name");
            hrRepName=sc.next();
            System.out.println("Enter hr representative contact number");
            hrRepContactNum=sc.next();
            //candidate.setCandidateWorkHistory(new CandidateWorkHistory(workId,whichEmployer,contactPerson,positionHeld,companyName,employmentFrom,employmentTo,reasonForLeaving,responsibilities,hrRepName,hrRepContactNum));
            CandidateWorkHistory workHistory=new CandidateWorkHistory(workId,id,whichEmployer,contactPerson,positionHeld,companyName,employmentFrom,employmentTo,reasonForLeaving,responsibilities,hrRepName,hrRepContactNum);
            Candidate candidate=new Candidate(personal,qualifications,workHistory);
            System.out.println(candidate);
            }
            else{
                CandidateWorkHistory workHistory=new CandidateWorkHistory();
                workHistory=null;
                Candidate candidate=new Candidate(personal,qualifications,workHistory);
            }
            
            int data=candidateService.addResume(candidate);
            if(data==3){
            System.out.println("Resume added.....");
        }else{
            System.out.println("Resume  could not be added.....");
        }
        }
        
        catch (RecruitmentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @Override
    public  void showCandidateMenu(String id) throws RecruitmentException, ParseException
    {
        
        System.out.println(" 1:Add resume  \n "
                + "2:Modify resume \n "
                + "3:Search for jobs based on qualification, position, years of experience,location\n"+
                "4:Apply for jobs\n" +" 5:Logout");
        System.out.println("Enter ur choice");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch(ch){
        
        case 1:addResume(id);break;
        case 2:modifyResume(id);break;
        case 4:applyJobs(id);break;
        case 3:searchJobs();break;
        case 5:loginUI.showMenu();break;
    default:System.out.println("Invalid choice");

        }
        showCandidateMenu(id);
        
    }

}
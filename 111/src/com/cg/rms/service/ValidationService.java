/*package com.cg.rms.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.rms.beans.CandidateLogin;
import com.cg.rms.beans.CompanyUser;
import com.cg.rms.dao.LoginDAO;
import com.cg.rms.dao.LoginDAOImpl;
import com.cg.rms.exception.RecruitmentException;



public class ValidationService {
    
 
LoginDAO ldao =new LoginDAOImpl() ;
  
    public boolean validateUserName(String user)throws RecruitmentException {
        
         
        String namePattern="[ 0-9A-Za-z]{5,30}";
        if(Pattern.matches(namePattern,user))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("User name must contain only Alphanumeric and betwenn 5 to 30  characters  " );
        }
        
    }
    
    public boolean validatePassword(String password)throws RecruitmentException {
        
        String namePattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if(Pattern.matches(namePattern,password))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Password must contain \n ** At least 8 chars Contains \n ** "
                    + " at least one digit \n ** Contains at least one lower alpha char and one upper alpha char \n "
                    + "** Contains at least one char within a set of special chars (@#%$^ etc.) \n"
                    + " ** Does not contain space, tab, etc." );
        }
        
    }
    
    
    
    public boolean validateCompany(String userId,String password) throws RecruitmentException {
     
         ArrayList<CompanyUser> login=ldao.getCompanyLogin();
            boolean flag=false;
        //  rs= //function from dao
      
            for(CompanyUser l:login)
                {
                    String username = l.getUserName();Same as atble names
                    String pwd = l.getPassword();

                    if((username==userId)&&(pwd==password))
                    { flag=true;
                        return true;
                    
                        
                    }
                      
                  }
        
             if(flag==false)
                   
                {   throw new RecruitmentException("Invalid  Companies Username and password") ;}
            
      return true;
      
    }
    
    public boolean validateUser(String userId,String password) throws RecruitmentException {
         ArrayList<CandidateLogin> login1=ldao.getCandidateLogin();
         boolean flag=false;
        //  rs= //function from dao
   
            for(CandidateLogin l:login1)
                {
                    String username = l.getUserName();Same as atble names
                    String pwd = l.getPassword();

                    if((username==userId)&&(pwd==password))
                    { flag=true;
                        return true;
                    
                        
                    }
                      
                  }
        
          if(flag==false)
                
             {   throw new RecruitmentException("Invalid Company name and password") ;}
         
   return true;      
    }
    public boolean validateAdmin(String userId,String password) throws RecruitmentException {
        // TODO Auto-generated method stub
    
        String username="Admin";
        String pwd="Admin";
        boolean flag = false;
        
                
                if((username.equalsIgnoreCase(userId))&&(pwd.equalsIgnoreCase(password)))
                { flag=true;
                    return true;
                
                    
                }
                  
                
                else                   
                {   throw new RecruitmentException("Invalid  Admin Username and password") ;}
      
    }
  //company_id,candidate_id,qualification_id ,work_id,job_id  
    //@Override
    public boolean validateId(String Id,String name1) throws RecruitmentException
    {
        String namePattern="[0-9]{1,5}";
        if(Pattern.matches(namePattern,Id))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    
    //company_name,specialization_area,university_name
    //@Override
    public boolean validateName(String name,String name1) throws RecruitmentException
    {
        String namePattern="[ A-Za-z,]{2,30}";
        if(Pattern.matches(namePattern,name))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    //qualification_name
    //@Override
    public boolean validateQualification_name(String name,String name1) throws RecruitmentException
    {
        String namePattern="[1-9A-Za-z][-.,0-9A-Za-z]{2,30}";
        if(Pattern.matches(namePattern,name))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid " +name1);
        }
    }
    //company_address,Job_description,address,Reason_For_leaving
    //@Override
    public boolean validateAddress(String address,String name1) throws RecruitmentException
    {
        String namePattern="[ ()A-Za-z0-9/,-]{2,100}";
        if(Pattern.matches(namePattern,address))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    //job location
    //@Override
        public boolean validateLocation(String address,String name1) throws RecruitmentException
        {
            String namePattern="[ ()A-Za-z0-9/,-]{2,25}";
            if(Pattern.matches(namePattern,address))
            {
                return true;
            }
            else
            {
                throw new RecruitmentException("Invalid "+name1);
            }
        }
    //contact_person,college_name
    //@Override
    public boolean validateContact(String contact,String name1) throws RecruitmentException
    {
        String namePattern="[A-Z][ ,A-Za-z.-]{2,24}";
        if(Pattern.matches(namePattern,contact))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    //email_id,
    //@Override
    public boolean validateEmail(String email,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        if(email.length()<=30)
        {
            String namePattern="^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
            if(Pattern.matches(namePattern,email))
            {
                return true;
            }
            else
            {
                throw new RecruitmentException("Invalid Email ID");
            }
        }
        else
        {
            throw new RecruitmentException("Invalid Email ID... Length should be less than 30");
        }
        
    }
    //contact_number,Hr_rep_contact_num
    //@Override
    public boolean validatePhone(String cPhone,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        String namePattern="[6-9][0-9]{9}";
        if(Pattern.matches(namePattern,cPhone))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    //marital_status
    //@Override
    public boolean validateMaritalStatus(String status,String name1) throws RecruitmentException
    {
        String namePattern="[-A-Za-z]{1,14}";
        if(Pattern.matches(namePattern,status))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid Marital Status");
        }
    }
    //Gender
    //@Override
    public boolean validateGender(String gender,String name1) throws RecruitmentException
    {
        String namePattern="[A-Za-z]{1,10}";
        if(Pattern.matches(namePattern,gender))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid gender");
        }
    }
    //Passport_number
    //@Override
    public boolean validatePassport(String passport,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        String namePattern="[a-zA-Z]{2}[0-9]{7}";
        if(Pattern.matches(namePattern,passport))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid passport no.");
        }
    }
    //year_of_passing
    //@Override
    public boolean validatePassingYear(String passingYear,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        String namePattern="[1|2][0-9]{3}";
        if(Pattern.matches(namePattern,passingYear))
        {
            LocalDate dt=LocalDate.now();
            int y=dt.getYear();
            if(Integer.parseInt(passingYear)<=y)
            return true;
            else
            {
                throw new RecruitmentException("Invalid passing year !!! As passing year should not be greater than current year");
            }

        }
        else
        {
            throw new RecruitmentException("Invalid passing year");
        }
    }
    //Percentage
    //@Override
    public boolean validatePercent(double percent,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        
        if(percent<=100 && percent>0)
        {
            String namePattern="[1-9]{0,3}[.]*[0-9]{0,2}";
            String d=percent+"";
            if(Pattern.matches(namePattern,d))
            {
                return true;
            }
            else
            {
                throw new RecruitmentException("Invalid Percent");
            }
        }
        else
        {
            throw new RecruitmentException("Invalid percent Range !! Percent should be between 0 and 100");
        }
        
        
    }
    //Which_employer
    //@Override
    public boolean validatewhichEmployer(String prevWork,String name1) throws RecruitmentException
    {
        String namePattern="[- A-Za-z]{2,10}";
        if(Pattern.matches(namePattern,prevWork))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid company Name");
        }
    }
    //candidate_name,Position_held,CompanyName from candidate_work_history,Hr_rep_name , Position_required,Qualification_required

    //@Override
    public boolean validatePosition(String position,String name1) throws RecruitmentException   
    {
        String namePattern="[- A-Za-z]{2,20}";
        if(Pattern.matches(namePattern,position))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid "+name1);
        }
    }
    
    //Responsibilities
    //@Override
    public boolean validateResponsibilities(String responsibilities,String name1) throws RecruitmentException
    {
        String namePattern="[ A-Za-z,.-]{2,150}";
        if(Pattern.matches(namePattern,responsibilities))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid responsibilities");
        }
    }


    //Numbers_required 
    //@Override
    public boolean validatenumberRequired(String cPhone,String name1) throws RecruitmentException {
        // TODO Auto-generated method stub
        String namePattern="[1-9][0-9]{0,1}";
        if(Pattern.matches(namePattern,cPhone))
        {
            return true;
        }
        else
        {
            throw new RecruitmentException("Invalid number required");
        }
    }
    //Experience_required 
        //@Override
        public boolean validateExperience(String cPhone,String name1) throws RecruitmentException {
            // TODO Auto-generated method stub
            String namePattern="[0-9]{0,2}";
            if(Pattern.matches(namePattern,cPhone))
            {
                return true;
            }
            else
            {
                throw new RecruitmentException("Invalid Experience");
            }
        }
}*/
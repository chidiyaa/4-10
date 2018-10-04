package com.cg.rms.beans;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;


public class CandidatePersonal {

    private String candidateId;
    private String candidateName;
    private String address;
    private LocalDate dob;
    private String emailId;
    private String contactNumber;
    private String maritalStatus;
    private String gender;
    private String passportNumber;

    
    public CandidatePersonal() {
        super();
        
    }
    
    public CandidatePersonal(String candidateId, String candidateName,
            String address, LocalDate dob, String emailId, String contactNumber,
            String maritalStatus, String gender, String passportNumber) {
        super();
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.address = address;
        this.dob = dob;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.passportNumber = passportNumber;
       
    }

    public String getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

  
    @Override
    public String toString() {
        return "Candidate_Personal [candidateId=" + candidateId
                + ", candidateName=" + candidateName + ", address=" + address
                + ", dob=" + dob + ", emailId=" + emailId + ", contactNumber="
                + contactNumber + ", maritalStatus=" + maritalStatus
                + ", gender=" + gender + ", passportNumber=" + passportNumber
                +  "]";
    }
    
    
    
}

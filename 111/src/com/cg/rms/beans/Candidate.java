package com.cg.rms.beans;

public class Candidate {

    CandidatePersonal candidatePersonal;
    CandidateQualifications candidateQualifications;
    CandidateWorkHistory candidateWorkHistory;
    public CandidatePersonal getCandidatePersonal() {
        return candidatePersonal;
    }
    public void setCandidatePersonal(CandidatePersonal candidatePersonal) {
        this.candidatePersonal = candidatePersonal;
    }
    public CandidateQualifications getCandidateQualifications() {
        return candidateQualifications;
    }
    public void setCandidateQualifications(
            CandidateQualifications candidateQualifications) {
        this.candidateQualifications = candidateQualifications;
    }
    public CandidateWorkHistory getCandidateWorkHistory() {
        return candidateWorkHistory;
    }
    public void setCandidateWorkHistory(CandidateWorkHistory candidateWorkHistory) {
        this.candidateWorkHistory = candidateWorkHistory;
    }
    public Candidate() {
        // TODO Auto-generated constructor stub
    }
    public Candidate(CandidatePersonal candidatePersonal,
            CandidateQualifications candidateQualifications,
            CandidateWorkHistory candidateWorkHistory) {
        super();
        this.candidatePersonal = candidatePersonal;
        this.candidateQualifications = candidateQualifications;
        this.candidateWorkHistory = candidateWorkHistory;
    }
    @Override
    public String toString() {
        return "Candidate [candidatePersonal=" + candidatePersonal
                + ", candidateQualifications=" + candidateQualifications
                + ", candidateWorkHistory=" + candidateWorkHistory + "]";
    }
}









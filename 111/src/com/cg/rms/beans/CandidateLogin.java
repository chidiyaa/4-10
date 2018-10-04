package com.cg.rms.beans;

public class CandidateLogin {
	private String userName;
	private String password;
	private String candidateId;
	public CandidateLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateLogin(String userName, String password, String candidateId) {
		super();
		this.userName = userName;
		this.password = password;
		this.candidateId = candidateId;
	}
	@Override
	public String toString() {
		return "CandidateLogin [userName=" + userName + ", password="
				+ password + ", candidateId=" + candidateId + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcandidateId() {
		return candidateId;
	}
	public void setcandidateId(String candidateId) {
		this.candidateId= candidateId;
	}
}

package com.cg.rms.beans;

public class CompanyUser {
	private String userName;
	private String password;
	private String companyId;
	public CompanyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyUser(String userName, String password, String companyId) {
		super();
		this.userName = userName;
		this.password = password;
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "CompanyUser [userName=" + userName + ", password=" + password
				+ ", companyId=" + companyId + "]";
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

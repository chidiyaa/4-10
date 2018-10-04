package com.cg.rms.beans;

public class CompanyMaster {
		private String companyId;
		private String companyName;
		private String companyAddress;
		private String contactPerson;
		private String emailId;
		private String contactNumber;
		public CompanyMaster() {
			super();
		}
		public CompanyMaster(String companyId, String companyName,
				String companyAddress, String contactPerson, String emailId,
				String contactNumber) {
			super();
			this.companyId = companyId;
			this.companyName = companyName;
			this.companyAddress = companyAddress;
			this.contactPerson = contactPerson;
			this.emailId = emailId;
			this.contactNumber = contactNumber;
		}
		@Override
		public String toString() {
			return "CompanyMaster [companyId=" + companyId + ", companyName="
					+ companyName + ", companyAddress=" + companyAddress
					+ ", contactPerson=" + contactPerson + ", emailId="
					+ emailId + ", contactNumber=" + contactNumber + "]";
		}
		public String getCompanyId() {
			return companyId;
		}
		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyAddress() {
			return companyAddress;
		}
		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}
		public String getContactPerson() {
			return contactPerson;
		}
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
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
}

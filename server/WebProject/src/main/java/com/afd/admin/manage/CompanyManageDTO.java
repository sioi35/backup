package com.afd.admin.manage;

public class CompanyManageDTO {
	
	private String companySeq;
	private String name;
	private String id;
	private String registrationNumber;
	private String companyTel;
	private String managerName;
	private String managerEmail;
	private String companyURL;
	
	public String getCompanySeq() {
		return companySeq;
	}
	public void setCompanySeq(String companySeq) {
		this.companySeq = companySeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getCompanyURL() {
		return companyURL;
	}
	public void setCompanyURL(String companyURL) {
		this.companyURL = companyURL;
	}
	
	@Override
	public String toString() {
		return "CompanyManageDTO [companySeq=" + companySeq + ", name=" + name + ", id=" + id + ", registrationNumber="
				+ registrationNumber + ", companyTel=" + companyTel + ", managerName=" + managerName + ", managerEmail="
				+ managerEmail + ", companyURL=" + companyURL + "]";
	}
	
}

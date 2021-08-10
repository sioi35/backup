package com.afd.company;

/**
 * 회사 정보와 회사가 올린 공고의 정보를 담고있는 변수와
 * Getter, Setter
 * @author 3조
 *
 */
public class CompanyDTO {
   
   //회사정보
   private String companySeq;
   private String name;
   private String id;
   private String pw;
   private String registrationNumber;
   private String companyTel;
   private String managerName;
   private String managerEmail;
   private String companyURL;
   
   //공고정보
   private String jobPostSeq;
   private String postName;
   private String regdate;
   private String jobGroup;
   private String career;
   private String educationLevel;
   private String jobType;
   private String salary;
   private String attachedFile;
   private String postContent;
   private String startDate;
   private String endDate;

   
   //공고 위치
   private String city;
   private String gu;
   private String dong;
   private String address;
   private String latitude;
   private String longitude;
   
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
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
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
   public String getJobPostSeq() {
      return jobPostSeq;
   }
   public void setJobPostSeq(String jobPostSeq) {
      this.jobPostSeq = jobPostSeq;
   }
   public String getPostName() {
      return postName;
   }
   public void setPostName(String postName) {
      this.postName = postName;
   }
   public String getRegdate() {
      return regdate;
   }
   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }
   public String getJobGroup() {
      return jobGroup;
   }
   public void setJobGroup(String jobGroup) {
      this.jobGroup = jobGroup;
   }
   public String getCareer() {
      return career;
   }
   public void setCareer(String career) {
      this.career = career;
   }
   public String getEducationLevel() {
      return educationLevel;
   }
   public void setEducationLevel(String educationLevel) {
      this.educationLevel = educationLevel;
   }
   public String getJobType() {
      return jobType;
   }
   public void setJobType(String jobType) {
      this.jobType = jobType;
   }
   public String getSalary() {
      return salary;
   }
   public void setSalary(String salary) {
      this.salary = salary;
   }
   public String getAttachedFile() {
      return attachedFile;
   }
   public void setAttachedFile(String attachedFile) {
      this.attachedFile = attachedFile;
   }
   public String getPostContent() {
      return postContent;
   }
   public void setPostContent(String postContent) {
      this.postContent = postContent;
   }
   public String getStartDate() {
      return startDate;
   }
   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }
   public String getEndDate() {
      return endDate;
   }
   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getGu() {
      return gu;
   }
   public void setGu(String gu) {
      this.gu = gu;
   }
   public String getDong() {
      return dong;
   }
   public void setDong(String dong) {
      this.dong = dong;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getLatitude() {
      return latitude;
   }
   public void setLatitude(String latitude) {
      this.latitude = latitude;
   }
   public String getLongitude() {
      return longitude;
   }
   public void setLongitude(String longitude) {
      this.longitude = longitude;
   }
   
   
   


}
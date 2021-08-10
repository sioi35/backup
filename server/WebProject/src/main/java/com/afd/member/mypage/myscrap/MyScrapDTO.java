package com.afd.member.mypage.myscrap;

public class MyScrapDTO {
	
	private String techQnaSeq;
	private String memberSeq;
	private String title;
	private String content;
	private String regdate;
	private String readCount;
	private String nickName;
	private String ccnt;
	private String recommendCount;
	private String decommendCount;
	private String name;
	private String id;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	private String communityScrapCount;
	private String qnaScrapCount;
	private String studyScrapCount;
	private String jobPostScrapCount;
	private String spaceScrapCount;
	
	public String getCommunityScrapCount() {
		return communityScrapCount;
	}
	public void setCommunityScrapCount(String communityScrapCount) {
		this.communityScrapCount = communityScrapCount;
	}
	public String getQnaScrapCount() {
		return qnaScrapCount;
	}
	public void setQnaScrapCount(String qnaScrapCount) {
		this.qnaScrapCount = qnaScrapCount;
	}
	public String getStudyScrapCount() {
		return studyScrapCount;
	}
	public void setStudyScrapCount(String studyScrapCount) {
		this.studyScrapCount = studyScrapCount;
	}
	public String getJobPostScrapCount() {
		return jobPostScrapCount;
	}
	public void setJobPostScrapCount(String jobPostScrapCount) {
		this.jobPostScrapCount = jobPostScrapCount;
	}
	public String getSpaceScrapCount() {
		return spaceScrapCount;
	}
	public void setSpaceScrapCount(String spaceScrapCount) {
		this.spaceScrapCount = spaceScrapCount;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTechQnaSeq() {
		return techQnaSeq;
	}
	public void setTechQnaSeq(String techQnaSeq) {
		this.techQnaSeq = techQnaSeq;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCcnt() {
		return ccnt;
	}
	public void setCcnt(String ccnt) {
		this.ccnt = ccnt;
	}
	public String getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}
	public String getDecommendCount() {
		return decommendCount;
	}
	public void setDecommendCount(String decommendCount) {
		this.decommendCount = decommendCount;
	}
	
	@Override
	public String toString() {
		return "MyScrapDTO [techQnaSeq=" + techQnaSeq + ", memberSeq=" + memberSeq + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", readCount=" + readCount + ", nickName=" + nickName + ", ccnt="
				+ ccnt + ", recommendCount=" + recommendCount + ", decommendCount=" + decommendCount + ", name=" + name
				+ ", id=" + id + ", registrationNumber=" + registrationNumber + ", tel=" + tel + ", address=" + address
				+ ", email=" + email + "]";
	}
	
}

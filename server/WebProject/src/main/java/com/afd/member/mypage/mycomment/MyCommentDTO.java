package com.afd.member.mypage.mycomment;

public class MyCommentDTO {
	
	private String techQnaSeq;
	private String memberSeq;
	private String title;
	private String content;
	private String regdate;
	private String readCount;
	private String image;
	private String nickName;
	private String id;
	private String isNew;
	private String ccnt;
	private String recommendCount;
	private String decommendCount;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}

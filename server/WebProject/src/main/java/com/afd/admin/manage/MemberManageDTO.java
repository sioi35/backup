package com.afd.admin.manage;

public class MemberManageDTO {
	
	private String memberSeq;
	private String name;
	private String id;
	private String nickName;
	private String registrationNumber;
	private String tel;
	private String address;
	private String email;
	private String score;
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	
	@Override
	public String toString() {
		return "MemberManageDTO [memberSeq=" + memberSeq + ", name=" + name + ", id=" + id + ", nickName=" + nickName
				+ ", registrationNumber=" + registrationNumber + ", tel=" + tel + ", address=" + address + ", email="
				+ email + ", score=" + score + "]";
	}
	
}

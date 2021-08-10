package com.afd.member.job;

/**
 * 채용공고 지원자 정보 차트에 들어갈 변수들의 Getter, Setter
 * @author 3조
 *
 */
public class CountDTO {

	private int man = 0;
	private int woman = 0;
	
	private String career;
	private int career1 = 0; //신입
	private int career2 = 0; //1년미만
	private int career3 = 0; //1~3년
	private int career4 = 0; //3~5년
	private int career5 = 0; //5년이상
	
	private int total = 0;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getCareer1() {
		return career1;
	}
	public void setCareer1(int career1) {
		this.career1 = career1;
	}
	public int getCareer2() {
		return career2;
	}
	public void setCareer2(int career2) {
		this.career2 = career2;
	}
	public int getCareer3() {
		return career3;
	}
	public void setCareer3(int career3) {
		this.career3 = career3;
	}
	public int getCareer4() {
		return career4;
	}
	public void setCareer4(int career4) {
		this.career4 = career4;
	}
	public int getCareer5() {
		return career5;
	}
	public void setCareer5(int career5) {
		this.career5 = career5;
	}
	public int getMan() {
		return man;
	}
	public void setMan(int man) {
		this.man = man;
	}
	public int getWoman() {
		return woman;
	}
	public void setWoman(int woman) {
		this.woman = woman;
	}
	
	
	
	
}

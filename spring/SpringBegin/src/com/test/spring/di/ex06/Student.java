package com.test.spring.di.ex06;

public class Student {

	private String name;
	private String school;
	
	public Student() {
		this("", "");
	}
	
	public Student(String name, String school) {
		this.name = name;
		this.school = school;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return String.format("%s-%s", this.name, this.school);
	}
	
}

package com.test.java.file;

public class Memo {
	
	//1,홍길동,2021-03-25 12:30:00,B
	//메모 테스트입니다.

	private String seq;  
	private String name;
	private String regdate;
	private String priority;
	private String content;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	   public String toString() {
	      return "Memo [seq=" + seq + ", name=" + name + ", regdate=" + regdate + ", priority=" + priority +  ", content=" + content + "]";
	   }
	
}//Memo

package practice;

import java.io.BufferedReader;
import java.io.FileReader;

public class Practice {

	private final static String DATA;

	static {
		DATA = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\출결.dat";
	}
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Employee e = new Employee();
				
				e.setDate(temp[0]);
				e.setName(temp[1]);
				
				
				//check(e);
				
				//System.out.printf("%s\t%s\t%s\n", e.getName(), e.getGoTime(), e.getLeaveTime());
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
		
	}//main

	private static void check(Employee e) {
		
		
	}
	
}

class Employee{
	
	String date;
	String name;
	String goTime;
	String leaveTime;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoTime() {
		return goTime;
	}
	public void setGoTime(String goTime) {
		this.goTime = goTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	

	
}

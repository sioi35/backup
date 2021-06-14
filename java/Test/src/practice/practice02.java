package practice;

import java.io.File;
import java.util.Calendar;

public class practice02 {

	public static void main(String[] args) {
		
		m1();
		m2();
		
	}

	private static void m2() {
		// TODO Auto-generated method stub
		
	}

	private static void m1() {

		String path = "C:\\class\\java\\m1.txt";
		
		File file = new File(path); //path가 실제로 존재or 존재하지 않더라도 무조건 참조 객체 생성 
		
		System.out.println(file.exists());
		
		if(file.exists()) {
			
			System.out.println("파일이 존재");
			System.out.println();
			
			System.out.println(file.lastModified());
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(1619499978860l);
			System.out.printf("%tF %tT", c, c);
			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		
		
		
	}
	
}

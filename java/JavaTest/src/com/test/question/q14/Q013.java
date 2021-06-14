package com.test.question.q14;

public class Q013 {

	public static void main(String[] args) {

		String txt = "안녕녕하하하하세요....홍홍홍홍길동입입니다다다다다..";
		System.out.print("원본: " + txt + "\n");
		
		int count = 0;
		
		System.out.println(txt.length());
		for(int i=1; i<txt.length(); i++) {
			
			if(txt.charAt(i-1) == txt.charAt(i)) {
				count++;
				if(i == txt.length()-1) {
					count++;
					System.out.printf("%c: 발견횟수 %d회\n", txt.charAt(i-1), count);
				}
			}else {
				count++;
				System.out.printf("%c: 발견횟수 %d회\n", txt.charAt(i-1), count);
				count = 0;//출력했으면 그 뒤로 같은 글자가 아님.
			}//if-else문	
		}//for문
		
	}//main
	
}//Q013

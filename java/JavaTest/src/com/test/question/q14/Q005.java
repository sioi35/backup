package com.test.question.q14;

public class Q005 {

	public static void main(String[] args) {
		

		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int index = 0 ;
		int count=0;
		
		while(true) {
			
			index = content.indexOf(word, index); // 길동이 발견되는 index를 저장
			
			if(index == -1) { // 더이상 길동이 없으면 종료
				System.out.printf("'%s'을 총 %d회 발견했습니다.",word, count);
				break;
			}
					
			index += word.length();
			count++;
			
		}
		
	}//main
	
}//Q005

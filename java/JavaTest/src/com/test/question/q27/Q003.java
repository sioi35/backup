package com.test.question.q27;

import java.io.File;
import java.util.Scanner;

public class Q003 {

	public static void main(String[] args) {

		// C:\class\java\file\AAA\m4.txt
		// C:\class\java\file\AAA\GGG\m4.txt
		//이동할 파일 참조 객체
		System.out.print("이동할 파일 경로: ");
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		
		//이동이 끝난 뒤에 모습을 참조할 객체
		System.out.print("이동될 파일 경로: ");
		scan = new Scanner(System.in);
		String path2 = scan.nextLine();
		
		File file = new File(path);
		File file2 = new File(path2);
		
		String answer="";  // 이동할지 그만둘지 답변받는 변수
		
		if(file.exists()){
		
			System.out.println("파일 이동을 실행합니다.");
			
			if(file2.exists()) { // 동일한 파일이 존재할 때.
				
				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n): ");
				scan = new Scanner(System.in);
				answer = scan.nextLine();
				
				if(answer.toLowerCase().equals("y")){//Y. 덮어쓰기 : 기존 파일 삭제 -> 이동하기
					file2.delete();
					file.renameTo(file2);
					System.out.println("y.파일을 덮어썼습니다.");
					
				}else {//N. 그만두기 : X
					System.out.println("n.작업을 취소합니다.");
				}
				
			}else {
				// 이동될 경로에 동일한 파일이 없을 시 바로 이동하기
				boolean result = file.renameTo(file2);
				System.out.println(result);
			}
			
		}else {
			//이동할 경로에 파일이 존재하는지
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		System.out.println("완료");
		
	}//main
	
}//Q003

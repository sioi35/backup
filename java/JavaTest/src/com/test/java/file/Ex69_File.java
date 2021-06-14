package com.test.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import com.test.util.MyFile;

public class Ex69_File {

	private static int count = 0;
	private static int dcount = 0;
	private static long size = 0;
	
	public static void main(String[] args) {
		
		//파일 & 디렉토리 조작
		
		//m1();
		//m2();	
		//m3();
		//m4();
		//m5();
		
		//m6();
		//m7();
		//m8();
		
		//m9();
		//m10();
		
		//m11();
		//m12();
		m13();
		
		
	}//main

	private static void m13() {
		
		// - 크기 : 711MB (746,154,477 바이트)
		// - 내용: 파일 11,329, 폴더 2,287
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if(dir.exists()) {
			countFile(dir);
		}

		System.out.printf("총 파일 개수: %,d개\n", count);
		System.out.printf("총 폴더 개수: %,d개\n", dcount);
		System.out.printf("폴더 크기: %,.0fMB\n", (double)size / 1024 / 1024);
		
		
	}//m13

	private static void countFile(File dir) {
		File[] list = dir.listFiles();
		
		for(File sub : list) {
			if(sub.isFile()) {
				count++;
				size += sub.length();
			}
		}
		
		for(File sub: list) {
			if(sub.isDirectory()) {
				//***
				countFile(sub); // 재귀 호출
			}
		}
		
		dcount++; //이 메소드 호출이 곧 폴더 1개가 존재한다.
		
	}//countFile

	private static void m12() {

		// 재귀 메소드
		// - 팩토리얼
		// - 디렉토리 구조(***)
		
		// 특정 폴더에 들어있는 파일의 개수?
		// - 크기 : 711MB (746,154,477 바이트)
		// - 내용: 파일 11,329, 폴더 2,287
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		int count = 0; //누적 변수
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for(File sub: list) {
				if(sub.isFile()) {  //파일 개수 세기
					count++;
				}
			}
			
			for(File sub: list) {
				if(sub.isDirectory()) {//폴더에 들어가서
					File[] sublist = sub.listFiles();
					for(File subsub : sublist) {  //파일 개수 세기
						if(subsub.isFile()) {
							count++;
						}
					}
					
					for(File subsub: sublist) {
						if(subsub.isDirectory()) {
							
							File[] subsublist = subsub.listFiles();
							for(File subsubsub : subsublist) {  //파일 개수 세기
								if(subsubsub.isFile()) {
									count++;
								}
							}
							
						}
					}
					
				}
			}
			
			System.out.printf("총 파일 개수: %,d개\n", count);
		}
		
	}//m12

	private static void m11() {

		// 폴더의 내용보기
		// - 자식 폴더 + 자식 파일 목록
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if(dir.exists()) {
			
//			String [] list = dir.list();
//			
//			for(String name : list) {
//				//System.out.println(name);
//				
//				// 이름 -> 파일 객체 -> 정보 얻어오기
//				File file = new File(path + "\\" + name);
//				
//				//System.out.println(file.getName());
//				//System.out.println(file.isFile());
//				//System.out.println(file.isDirectory());
//				
//				System.out.printf("%s - %s\n", file.getName(), file.isFile() ? "파일" : "폴더");
//				
//			}
			
			File[] list = dir.listFiles(); // 사용 빈도 높음
			
//			for(File file : list) {
//				System.out.printf("%s - %s\n", file.getName(), file.isFile() ? "파일" : "폴더");
//			}
			
			//출력 -> 탐색기처럼 출력
			for(File sub : list) {
				if(sub.isDirectory()) {
					System.out.printf("[%s]\n", sub.getName());
				}
			}
			
			for(File sub : list) {
				if(sub.isFile()) {
					System.out.println(sub.getName());
				}
			}
			
			
		}//if문
		
	}//m11

	private static void m10() {

		//myutil.jar - 라이브러리
		
		MyFile file = new MyFile();
		
		String orgpath = "C:\\class\\java\\file\\JavaTest.zip";
		String copyPath = "C:\\class\\java\\file\\BBB\\JavaTest.zip";
		
		if(file.copy(orgpath, copyPath)) {
			System.out.println("복사 성공");
		}else {
			System.out.println("복사 실패");
		}
		
	}//m10

	private static void m9() {

		// 파일 복사
		// - C:\class\java\file\JavaTest.zip
		// - C:\class\java\file\AAA\JavaTest.zip
		
		File org = new File("C:\\class\\java\\file\\JavaTest.zip");
		File copy = new File("C:\\class\\java\\file\\AAA\\JavaTest.zip");
		
		// 파일 복사 -> 바이트 단위 복사
		// 1. FileInputStream : 파일의 내용을 바이트 단위로 읽기
		// 2. FileOutputStream : 파일의 내용을 바이트 단위로 쓰기
		
		try {
			
			FileInputStream fis = new FileInputStream(org);  //원본 파일
			FileOutputStream fos = new FileOutputStream(copy); //복사 파일
			
			// 버퍼(512KB ~1KB 내외)
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			//복사
			while((length = fis.read(buffer)) > 0) {
				//System.out.println(length);
				fos.write(buffer, 0, length);
			}
			
			System.out.println("파일 복사 완료");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}//m9

	private static void m8() {

		//폴더 삭제하기
		// - 빈폴더만 삭제 가능
		// - 내용물이 있으면.. 개발자가 그안의 모든 내용물을 각각 직접 삭제한 뒤.. 해당 폴더를 빈폴더로 만들고 난 뒤 삭제한다.
		String path = "C:\\class\\java\\file\\member";
		File dir = new File(path);
		
		if(dir.exists()) {
			
			System.out.println(dir.delete());
			
		}
		
		
	}//m8

	private static void m7() {

		// 폴더명 바꾸기 + 폴더 이동하기  == 파일명 바꾸기 + 파일 이동하기
		String path = "C:\\class\\java\\file\\GGG";  //원본
		File dir = new File(path);
		
		String path2 = "C:\\class\\java\\file\\AAA\\GGG";  //결과
		File dir2 = new File(path2);
		
		if(dir.exists()) {
			dir.renameTo(dir2);
			System.out.println("완료");
		}
		
	}//m7

	private static void m6() {

		//폴더 생성
		String path = "C:\\class\\java\\file\\DDD\\EEE\\FFF"; //희망하는 폴더의 경로
		File dir = new File(path);
		
		if(!dir.exists()) {
			//생성
			//System.out.println(dir.mkdir()); //make directory -> path와 동일한 경로에 폴더를 생성한다.
			System.out.println(dir.mkdirs());
			System.out.println("생성 완료");
		}else {
			//이미 있음
			System.out.println("같은 이름의 폴더가 이미 존재합니다.");
		}
		System.out.println();
		
		
		//요구사항] 회원 > 회원별 개인 폴더 작성하기
		// - C:\class\java\file\member\[개인폴더]홍길동
		String[] member = {"홍길동", "아무개", "하하하", "호호호"};
		
		for(String name : member) {
			path= String.format("C:\\class\\java\\file\\member\\[개인폴더]%s", name);
			dir = new File(path);
			System.out.println(dir.mkdirs());
			System.out.println(name + ", 개인폴더 생성완료.");
		}
		System.out.println();
		
		// 요구사항] 2021년 날짜별 폴더 생성
		// - C:\class\java\file\date\2021-01-01
		// - ..
		// - C:\class\java\file\date\2021-12-31
		// - Calendar 사용
		
		
		Calendar c = Calendar.getInstance();
		c.set(2021, 0, 1); // 2021-01-01
		
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for(int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			path = String.format("C:\\class\\java\\file\\date\\%tF", c);
			dir= new File(path);
			if(dir.mkdirs()){
				System.out.printf("%tF\n", c);
			}else {
				System.out.println("failed");
			}
			c.add(Calendar.DATE, 1);
		}
		
		
		
		
	}//m6

	private static void m5() {

		//파일 삭제
		//C:\class\java\file\BBB\m3.txt;
		
		String path="C:\\class\\java\\file\\BBB\\m3.txt";
		File file = new File(path);
		
		if(file.exists()) {
			
			//** 진짜 삭제(휴지통 X)
			// - 복구 불가능
			System.out.println(file.delete());
			
		}
		
		
	}//m5

	private static void m4() {

		//파일 조작
		// - 이름 바꾸기
		
		//C:\class\java\file\AAA\m3.txt
		//m3.txt -> (이름 바꾸기) -> m4.txt
		
		String path="C:\\class\\java\\file\\AAA\\m3.txt";
		File file = new File(path);
		
		String path2 ="C:\\class\\java\\file\\BBB\\m4.txt";
		File file2 = new File(path2);
		
		if(file.exists()) {
			
			//파일명 바꾸기
			file.renameTo(file2);
			
			System.out.println("완료");
			
		}
		
	}//m4

	private static void m3() {
		
		//파일 조작
		// - 생성(X), 이동(O), 이름 바꾸기(O), 복사(X), 삭제(O)
		
		//C:\class\java 폴더 생성
		//C:\class\java\file\AAA\m3.txt 파일 생성
		//C:\class\java\file\BBB 폴더 생성
		
		//파일 이동(m3.txt)
		//AAA -> 이동 -> BBB
		
		//이동할 파일 참조 객체
		String path="C:\\class\\java\\file\\AAA\\m3.txt";
		File file = new File(path);
		
		//이동이 끝난 뒤에 모습을 참조할 객체
		String path2 ="C:\\class\\java\\file\\BBB\\m3.txt";
		File file2 = new File(path2);
		
		if(file.exists()){
		
			//이동하기
			// - true : 성공
			// - false : 실패(같은 파일이 이미 있는 경우)
			
			if(file2.exists()) {
				
				System.out.println("이미 동일한 파일이 존재합니다.");
				
				//추가 업무
				//1. 덮어쓰기 : 기존 파일 삭제 -> 이동하기
				//2. 그만두기 : X
				
			}else {
				// 이동하기
				boolean result = file.renameTo(file2);
				System.out.println(result);
			}
			
			System.out.println("완료");
			
		}//if 파일이 존재하는지
		
		
	}//m3

	private static void m2() {
		
		// 운영체제
		// - 파일, 폴더 = 동일한 객체
		// - 폴더는 파일의 한 종류
		// - 폴더는 공간이 아니다.(***)
		
		
		//특정 폴더 정보 얻어오기
		// -C:\class\java
		
		//경로
		String path = "C:\\class\\java";
		
		//참조 객체 생성
		File dir = new File(path);
		
		if(dir.exists()) {
			
			//*****-------------------------------------------------------------
			System.out.println(dir.getName());		//Java 폴더명(***)
			
			System.out.println(dir.isFile());		//false 파일이니?(***)
			System.out.println(dir.isDirectory());	//true 폴더니?(***)
			System.out.println(dir.getPath());			//경로
			System.out.println(dir.getAbsolutePath());	//경로			
			//------------------------------------------------------------------
			
			//폴더라는 파일의 크기를 물어보는 것.. -> 사용 안함
			//System.out.println(dir.length());		//4096 폴더는 크기가 중요하지 않다.(0B)
		
			System.out.println(dir.lastModified());		//최종 수정 시간(Tick값)1619500162355
			System.out.println(dir.canRead());		//true 
			System.out.println(dir.canWrite());		//true
			System.out.println(dir.isHidden());		//false
		
		}else {
			System.out.println("폴더가 존재하지 않습니다.");
		}		
		
	}//m2

	private static void m1() {

		// 특정 파일 정보 얻어오기
		// - C:\class\java\m1.txt
		
		//외부 파일 접근 > 파일에 대한 참조 객체(대리인) 생성 > 참조 객체 조작 > 외부 파일 조작
		
		String path = "C:\\class\\java\\m1.txt";
		
		//참조 객체 생성
		File file = new File(path);  //path는 실제로 있는 파일? 없는 파일? -> 상관없이 객체가 만들어진다.
		
		System.out.println(file.exists()); //해당 경로의 파일이 실제로 존재합니까?
		
		if(file.exists()) {
			
			System.out.println("파일이 존재합니다.");
			System.out.println();
			
			//업무 진행
			//파일 정보 가져오기
			
			//*****-------------------------------------------------------------
			System.out.println(file.getName());		//m1.txt 파일명(***)
			System.out.println(file.isFile());		//true 파일이니?(***)
			System.out.println(file.isDirectory());	//false 폴더니?(***)
			System.out.println(file.length());		//26 파일 크기 (바이트)
			System.out.println(file.getPath());		//C:\class\java\m1.txt 경로
			System.out.println(file.getAbsolutePath());//C:\class\java\m1.txt 경로			
			//------------------------------------------------------------------

			//Tick -> Calendar
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(1619499978860L);
			System.out.printf("%tF %tT\n", c, c);
			
			System.out.println(file.lastModified());//최종 수정 시간(Tick값)1619499978860
			System.out.println(file.canRead());		//true 
			System.out.println(file.canWrite());	//true
			System.out.println(file.isHidden());	//false
			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}//m1
	
}//File

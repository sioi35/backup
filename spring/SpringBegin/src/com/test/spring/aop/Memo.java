package com.test.spring.aop;

import java.util.Random;

public class Memo {

	/*
	public void add(String memo) {

		//보조 업무 - 인증
		Auth auth = new Auth();
		auth.check();
		
		//1. 주업무 - 메모쓰기
		System.out.printf("메모쓰기: %s\n", memo);
		
		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void edit(int seq, String memo) {

		//보조 업무 - 인증
		Auth auth = new Auth();
		auth.check();
		
		//2. 주업무 - 메모수정
		System.out.printf("메모수정: %d번 메모를 수정했습니다.\n", seq);
	
		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void del(int seq) {
		
		//보조 업무 - 인증
		Auth auth = new Auth();
		auth.check();

		//3. 주업무 - 메모삭제
		System.out.printf("메모삭제: %d번 메모를 삭제했습니다.\n", seq);
		
		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void read(int seq) {
		
		//보조 업무 - 인증
		Auth auth = new Auth();
		auth.check();

		//4. 주업무 - 메모읽기
		System.out.printf("메모읽기: %d번 메모를 읽습니다.\n", seq);
	
		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}
	*/
	
	public void memberadd(String memo) throws Exception{
		
		//1. 주업무 - 메모쓰기
		System.out.printf("메모쓰기: %s\n", memo);

		Random rnd = new Random();
		
		if(rnd.nextInt(10) % 2 == 0) {
			throw new Exception("메모 쓰기 중 에러 발생");
		}
	
		
	}

	public void memberedit(int seq, String memo) {

		//2. 주업무 - 메모수정
		System.out.printf("메모수정: %d번 메모를 수정했습니다.\n", seq);
	
	}

	public void memberdel(int seq) {
		
		//3. 주업무 - 메모삭제
		System.out.printf("메모삭제: %d번 메모를 삭제했습니다.\n", seq);
		
	}

	public void read(int seq) {

		//4. 주업무 - 메모읽기
		System.out.printf("메모읽기: %d번 메모를 읽습니다.\n", seq);
	
	}
	
	
	public int search(String keyword) {
		
		if(keyword.indexOf("길동") > -1) {
			return 5;
		}else if(keyword.indexOf("하하") > -1){
			return 10;
		}
		
		return -1;
	}
	
}

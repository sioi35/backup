

package practice;

public class test {

	public static void main(String[] args) {
		
			/*
		-- 전체과목 
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'JAVA 객체 지향 프로그래밍');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '오라클을 사용한 RDBMS의 SQL과 PL/SQL');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Front-end 클라이언트 화면설계 및 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Web Publishing을 위한 Front-End 설계 및 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '아두이노를 활용한 임베디드 프로그래밍');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '멀티 플랫폼 기반 융합 실무 프로젝트');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '클라우드 개발을 위한 자바 기초 프로그래밍');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '클라우드 시스템 개요 및 AWS 서비스 요소');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'AWS 클라우드 등록 설정 및 구축');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Server Side 프로그래밍'); -- JSP
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '지능형 웹을 위한 애플리케이션 구축');  -- 웹크롤링테크닉
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '콘텐츠 추천 알고리즘 기법');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터 분석기법 및 활용');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '공공 데이터 분석기법을 활용한 데이터 융합 프로젝트');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '임베디드 애플리케이션 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '반응형 웹 개발기법');		
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '애플리케이션 테스트 수행');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '애플리케이션 배포');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Java OpenJDK & 통합 프로젝트');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터베이스 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터 저장을 위한 오라클 데이터베이스');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'NCS 소양교과');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 프로그래밍');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 안드로이드 프로그램 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 활용 안드로이드 모바일 프로젝트 제작');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'UML을 사용한 시스템 분석');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '형상관리');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데스트 탑 UI/UX');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '웹킷 계열 브라우저 반응형 웹 UI/UX설계');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Web Publishing을 위한 Front-End 설계 및 구현');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, '인공지능');
		insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Python');
	*/	
		/*
			System.out.println("[전체교재]");   //교재명, 출판사, 저자, 가격
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'Do it! 자바 프로그래밍 입문','이지스퍼블리싱','박은종', 25000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'Do it! 오라클로 배우는 데이터베이스 입문','이지스퍼블리싱','이지훈', 25000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'HTML5,CSS3,JavaScript,jQuery Mobile 중심의 Front-End 웹프로그래밍','마지원','김형수', 22000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '명품 HTML5 + CSS3 + Javascript 웹 프로그래밍','생능출판사','황기태', 28000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'Do it! 웹 프로그래밍을 위한 자바스크립트 기본 편','이지스퍼블리싱','고경희', 18800);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '한 권으로 끝내는 아두이노 입문 + 실전(종합편)','앤써북','서민우', 20000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '2D/3D 멀티 플랫폼 게임을 위한 유니티','제이펍','박승제', 40000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '클라우드 2nd Edition(그림으로 배우는)','영진닷컴','서재원', 16000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '애플리케이션 프로그래밍 with 자바(아파치 카프카) ','비제이퍼블릭','최원영',32000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'AWS 클라우드 머신러닝','에이콘출판','박정현', 35000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'JSP 웹프로그래밍 가이드','마이트프레스','김재환', 23000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '웹 크롤링 테크닉','제이펍','이동규', 30000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'Do it! 자료구조와 함께 배우는 알고리즘 입문','이지스퍼블리싱','강민', 22000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'ADsP 데이터 분석 준전문가','데이터에듀','윤종식', 28000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'R을 이용한 공공데이터 분석','한나래아카데미','오대영', 28000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, '임베디드 OS 개발 프로젝트','인사이트','이만우', 24000);");
			System.out.println("INSERT INTO tblAllBook VALUES(allBookSeq, 'Do it! 반응형 웹 페이지 만들기','이지스퍼블리싱','김운아', 20000);");
			
			*/	
		
		//6번쌤
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 1, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 19, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 20, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 3, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 15, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 6, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 4, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 2, 6);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 21, 6);");
	
		//7번쌤
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 1, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 2, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 3, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 4, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 11, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 16, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 17, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 18, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 19, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 20, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 29, 7);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 30, 7);");
		
		//8번쌤
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 1, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 2, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 3, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 4, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 6, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 15, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 17, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 18, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 19, 8);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 32, 8);");
	
		//9번쌤
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 1, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 2, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 6, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 7, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 8, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 6, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 11, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 17, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 18, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 23, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 24, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 25, 9);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 27, 9);");
	
	
		//10번쌤
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 1, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 2, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 3, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 4, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 16, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 21, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 26, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 27, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 28, 10);");
		System.out.println("INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq, 29, 10);");
	
				
	
	}
	
}

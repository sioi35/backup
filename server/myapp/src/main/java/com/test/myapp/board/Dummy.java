package com.test.myapp.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.myapp.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		//글쓰기
		String[] id = {"hong", "test", "admin"};
		String[] subject = {"필독]공지사항", 
							"게시판 테스트입니다.", 
							"JSP/Servlet 게시판 만드는 중입니다.", 
							"페이징 구현", 
							"공지사항]비대면 실시", 
							"안녕하세요 ~~", 
							"할일 리스트 만들기", 
							"팀프로젝트 팀원 구해요~", 
							"웹 프로젝트 시작", 
							"자바 복습 어떻게 하나요", 
							"읽기 좋은 책 추천해주세요", 
							"점심 메뉴 추천좀", 
							"회사 신입 꿀팁!", 
							"면접 준비 하실 분 모집합니다.", 
							"자유 게시판", 
							"오늘 점심 먹으실분", 
							"금요일 면접 대비", 
							"자소서/이력서 쓰는 법", 
							"건강 조심하세요 ㅜㅜ", 
							"게시판 복습 꼭 하기", 
							"포트폴리오 마무리하기"};
		String content = "내용입니다.";
		String tag = "n";
		
		Random rnd = new Random();
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			
			String sql = "insert into tblBoard1 (seq, id, subject, content, regdate, readcount, tag, thread, depth)"
					+ "	values(seqBoard.nextVal, ?, ?, ?, default, default, ?, ?, ?)";
			
			conn = DBUtil.open();
			stat = conn.prepareStatement(sql);
			
			int thread = 3000;
			
			for(int i=0; i<50; i++) {
				
				thread += 1000;
				
				stat.setString(1, id[rnd.nextInt(id.length)]);
				stat.setString(2, subject[rnd.nextInt(subject.length)]);
				stat.setString(3, content);
				stat.setString(4, tag);
				stat.setInt(5, thread);
				stat.setInt(6, 0);
				
				stat.executeUpdate();
				
				System.out.println(i+ "번째 게시물");
			}
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Dummy.main()");
			e.printStackTrace();
		}
		
		
	}
	
}

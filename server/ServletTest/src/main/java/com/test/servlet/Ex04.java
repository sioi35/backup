package com.test.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 필요한 HTML 코드를 따로 작성하고(*.html) 파일을 읽어서 사용
		
		// 오라클 -> select -> 홍길동, 20, 학생
		
		HashMap<String,String> data = new HashMap<String,String>();
		
		data.put("name", "아무개");
		data.put("age", "22");
		data.put("job", "학생");
		
		Set<String> keys = data.keySet();
		
		BufferedReader reader = new BufferedReader(new FileReader(req.getRealPath(".\\html\\template.html")));
		
		String source = "";
		String line = "";
		
		while((line = reader.readLine()) != null) {
			
			// 읽은 한줄 -> keys 루프 -> 바꿀 부분이 있는지 검색
			Iterator<String> iter = keys.iterator();
			
			while(iter.hasNext()) {
				String key = iter.next(); //name, age, job
				line = line.replace("#" + key + "#", data.get(key));
			}
			
			source += line + "\n";
			
		}
		
		reader.close();
		
		//System.out.println(source);
		
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(source);
		
		writer.close();
		
		
	}
	
	
}

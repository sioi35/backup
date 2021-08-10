package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ex02_Gugudan.java
public class Ex02_Gugudan extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Random rnd = new Random();
		int dan = rnd.nextInt(8) + 1; //1~9단
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "\r\n"
				+ "        h1{\r\n"
				+ "            border-bottom: 1px dashed #999;\r\n"
				+ "            padding-bottom: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        div{\r\n"
				+ "            font-size: 1.2em;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "            color: #555;\r\n"
				+ "            margin-bottom: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <h1>구구단" + dan + "단</h1>");
		
		for(int i=1; i<=9; i++) {
			writer.printf("<div>%d x %d = %d</div>\n",dan, i, i*dan);
		}
		
		writer.println("</body>\r\n"
				+ "</html>");
		
		writer.close();
		
	}
	
	
}

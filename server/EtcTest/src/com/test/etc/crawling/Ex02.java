package com.test.etc.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
	
	public static void main(String[] args) throws Exception{
		
		//Ex02.java
		System.out.println("[네이버 영화 랭킹]");
		
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.naver";
		
		//doc -> 해당 페이지의 모든 내용을 담고 있는 문서 객체(JavaScript의 document 객체같은 역할)
		Document doc = Jsoup.connect(url).get();
		
		System.out.println(doc.title());
		
		// .title > .tit3 > a
		Elements list = doc.select(".title > .tit3 > a");
		
		System.out.println(list.size());
		
		for(Element item : list) {
			//System.out.println(item);
			System.out.println(item.text()); //PCDATA
			System.out.println(item.attr("href")); //속성
		}
		
	}
	
}

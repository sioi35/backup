package com.test.etc.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.data.Color;
import com.test.data.Data;
import com.test.data.Item;

public class Ex05 {

	public static void main(String[] args) {
		
		
		//스프링 프로젝트 적용
		// -> 노출(X)
		// -> 적용 필수(O) -> 람다식, 자바 스트림 -> 질문
		
		
		//람다식
		// 1. 배열, 컬렉션 > sort()
		// 2. 자바 스트림(******)
		
		
		//자바 스트림
		//1. 입출력 스트림
		// - 파일 입출력, 콘솔 입출력, 네트워크 입출력
		//2. 스트림
		// - Java 8(JDK 1.8)
		// - 배열, 컬렉션의 탐색을 지원(*****)
		
		//스트림
		// - 배열, 컬렉션을 탐색하는 방법
		// - 람다식 사용
		
		//배열, 컬렉션 탐색
		//1. for문
		//2. 향상된 for문
		//3. iterator
		//4. 스트림
		
		//m1();
		//m2();
		//m3();
		
		
		
		//스트림에서 제공하는 기술
		// - 파이프 라인, Pipe Line(=메소드 체인)
		// - 배열 -> 스트림 -> 조작(a) -> 스트림 -> 조작(a) -> 스트림 -> 조작 X 반복
		// a. 중간 처리: 필터링, 매핑, 정렬, 그룹핑 등 
		// b. 최종 처리: 합계, 평균, 카운트, 최댓값, 최솟값, forEach 등
		//m4();
		//m5();
		
		//m6();
		//m7();
		m8();
		
	}//main

	private static void m8() {

		//집계
		// - 통계값 함수
		// - 최종 처리 파이프
		// - 데이터 집합의 요소를 가공해서 축소하는 작업(Reduction)

		System.out.println(Data.getIntList().stream().count());
		System.out.println(Data.getIntList().stream().filter(n -> n% 2 == 1).count());
		System.out.println();
		
		System.out.println(Data.getUserList().stream().count());
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 1).count());
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 2).count());
		
		System.out.println(Data.getItemList().stream().count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.YELLOW).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.RED).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.BLUE).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.GREEN).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.ORANGE).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.WHITE).count());
		System.out.println(Data.getItemList().stream().filter(item -> item.getColor() == Color.BLACK).count());
		System.out.println();
		
		//집계함수
		// - 범용 스트림
		// - 전용 스트림
		
		//Optional 클래스
		// - 기존의 값행에 null을 추가한 자료형
		// - int + null
		System.out.println(Data.getIntList().stream().max((a, b) -> a - b).get());
		System.out.println(Arrays.stream(Data.getIntArray()).max().getAsInt());
	
		System.out.println(Data.getIntList().stream().min((a, b) -> a - b).get());
		System.out.println(Arrays.stream(Data.getIntArray()).min().getAsInt());
		
		System.out.println(Arrays.stream(Data.getIntArray()).sum());
		
		System.out.println(Arrays.stream(Data.getIntArray()).average().getAsDouble());
		
		
		
	}

	private static void m7() {

		//정렬
		// - 배열, 컬렉션
		// - 스트림 정렬

		// - sorted()
		// - 중간 처리 파이프
		// - 요소를 정렬 후 정렬된 스트림을 반환
		
		
		List<Integer> list1 = Data.getIntList(15);
		list1.stream().forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		list1.sort((a, b) -> a - b); //오름차순 정렬
		list1.stream().forEach(n -> System.out.printf("%4d", n));
		System.out.println();

		List<Integer> list2 = Data.getIntList(15);
		
		list2.stream().sorted().forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		Data.getStringList(10).stream().map(str -> str.length()).sorted().forEach(n -> System.out.println(n));
		
		
		List<String> list3 = Data.getStringList(10);
		list3.stream().sorted().forEach(word -> System.out.println(word));
		System.out.println();
		
		List<Integer> list4 = Data.getIntList(15);
		
		//역정렬
		list4.stream().sorted((a, b) -> b - a).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//문자수 정렬
		List<String> list5 = Data.getStringList(10);
		list5.stream().sorted((a, b) -> a.length() - b.length()).forEach(word -> System.out.println(word));
		System.out.println();
		
		//날짜 정렬
		List<Item> list6 = Data.getItemList();
		//System.out.println(list6.get(0));
		
		list6.stream()
			.sorted((a, b) -> a.getName().compareTo(b.getName()))
			.forEach(item -> System.out.println(item));
		System.out.println();
		
		list6.stream()
			.sorted((a, b) -> a.getSize() - b.getSize())
			.forEach(item -> System.out.println(item));
		System.out.println();
		
		list6.stream()
			.sorted((a, b) -> a.getDate().compareTo(b.getDate()))
			.forEach(item -> System.out.println(item));
		System.out.println();
		
	}

	private static void m6() {

		//소스 -> 스트림 -> 중간 처리(파이프) X N -> 최종 처리(파이프)
		//중간 파이프: filter(), distinct()
		//최종 파이프: forEach()
		
		//매핑
		// - mapXXX()
		// - 스트림 요소 -> 다른 형태의 요소(값)으로 변환(*****)해서 반환하는 작업
		// - 중간 파이프
		
		List<String> list = Data.getStringList();
		System.out.println(list);
		System.out.println();
		
		//각 문자열의 길이를 확인? > 문자열(String) ->  매핑(변환) -> 길이(int)
		list.stream().forEach(str -> System.out.printf("%s(%d)\n", str, str.length()));
		
		list.stream().map(word -> word.length()).forEach(n -> System.out.println(n));
		System.out.println();
		
		//데이터 가공(변환)
		Data.getIntList(10)
		.stream()
		.forEach(n -> System.out.println("나이: " + n));
		System.out.println();
		
		Data.getIntList(10)
			.stream()
			.map(n -> (n / 10) * 10) //원본 -> 다른 성격의 데이터
			.forEach(n -> System.out.println("세대: " + n +"대"));
		System.out.println();
		
		List<com.test.data.User> ulist = Data.getUserList();
		
		//System.out.println(ulist.get(0));
		
		//BMI 지수 = 몸무게(kg) / (키(m) * 키(m))
		ulist.stream()
			.filter(user -> user.getGender() == 1)
			//.filter(bmi -> bmi > 25)
			.map(user -> (double)user.getWeight() / (user.getHeight() * user.getHeight()) * 10000)
			//.filter(user -> user.getGender() == 1)
			.filter(bmi -> bmi > 25)
			.forEach(bmi -> System.out.printf("%.1f\n", bmi));
		
	}

	private static void m5() {

		//중복 제거
		// - distinct()
		List<Integer>list = Data.getIntList();
		
		System.out.println(list.size());
		
		//list.stream().distinct().forEach(num -> System.out.println(num));
		//System.out.println();
		
		System.out.println(list.stream().distinct().count());
		System.out.println();
		
		List<String> names = Arrays.asList("홍길동", "아무개", "김훈", "하하하", "홍길동", "호호호", "김훈", "김길동", "아무개", "테스트");
		
		//경우에 따라 중간 파이프의 순서가 결과에 영향을 미치는 경우가 있다.(****주의)
		names.stream()
			.filter(name -> name.length() >= 3)
			.distinct()
			.forEach(name -> System.out.println(name));
		System.out.println();
		
		
	}

	private static void m4() {

		//필터링
		// - filter()
		// - 중간 처리 파이프
		// - 반환값으로 필터링이된 Stream을 반환하기 때문에 계속 이어서 다른 파이프를 연결할 수 있다.(****)
		
		
		List<Integer> list = Data.getIntList(15);
		
		System.out.println(list);
		System.out.println();
		
		//요구사항] 짝수만 출력하세요
		for(int n : list) {
			if(n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		}
		System.out.println();
		
		//스트림 사용
		list.stream().forEach(n -> {
			if(n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		});
		System.out.println();
		
		//스트림 사용 + 권장
		//	 스트림 시작 -> 처리(중간 파이프)  -> 처리(최종 파이프)
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		list.stream().filter(n -> n % 3 == 0).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		list.stream().filter(n -> n > 50).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		list.stream().filter(n -> n < 10).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		Data.getStringList().stream().filter(str -> str.length() >= 5).forEach(str -> System.out.println(str));
		System.out.println();
		
		Data.getStringList().stream().filter(str -> str.startsWith("애")).forEach(str -> System.out.println(str));
		System.out.println();
		
		//System.out.println(Data.getUserList());
		//전체 명단
		Data.getUserList().stream().forEach(user -> System.out.println(user.getName()));
		System.out.println(); 
		
		//남자만
		Data.getUserList().stream()
				.filter(user -> user.getGender() == 1)
				.forEach(user -> System.out.println(user.getName()));
		System.out.println();
		
		//여자만
		Data.getUserList().stream()
				.filter(user -> user.getGender() == 2)
				.forEach(user -> System.out.println(user.getName()));
		System.out.println();
		
		
		//키 170 over + 몸무게 70 over
		Data.getUserList().stream()
				.filter(user -> user.getHeight() > 170 && user.getWeight() > 70)
				.forEach(user -> System.out.println(user));
		System.out.println();
		
		
		//System.out.println(Data.getItemList());
		//노란색 제품만
		Data.getItemList().stream()
			.filter(item -> item.getColor() == Color.YELLOW)
			.forEach(item -> System.out.printf("%s(%s, %d)\n", item.getName(), item.getColor(), item.getSize()));
		System.out.println();
		
		//노란색 제품만 + 조건 추가(size > 30)
		Data.getItemList().stream()
			.filter(item -> item.getColor() == Color.YELLOW && item.getSize() > 30)
			.forEach(item -> System.out.printf("%s(%s, %d)\n", item.getName(), item.getColor(), item.getSize()));
		System.out.println();
		
		Data.getItemList().stream()
			.filter(item -> item.getColor() == Color.YELLOW)//노란색 조건
			.filter(item -> item.getSize() > 30) //사이즈 조건
			.forEach(item -> System.out.printf("%s(%s, %d)\n", item.getName(), item.getColor(), item.getSize()));
		System.out.println();
		
		
	
		
		
	}

	private static void m3() {

		
		//스트림을 얻어오기
		//1. 순수 배열로부터
		//2. 컬렉션으로부터
		//3. 숫자 범위로부터 -> range(1,10)
		//4. 파일로부터
		//5. 디렉토리로부터
		
		//1.
		int[] list1 = {10, 20, 30, 40, 50 };
		Arrays.stream(list1).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//2. 
		List<String> list2 = Arrays.asList("홍길동", "아무개", "하하하"); //읽기 전용
		//list2.add("테스트");
		//System.out.println(list2);
		list2.stream().forEach(name -> System.out.printf("%s ", name));
		System.out.println();
		
		
		//3. 
		IntStream list3 =  IntStream.range(1, 11);
		list3.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		
		try {
			
			//파일, 디렉토리 조작 + 파일 입출력 -> 일부 기능에서 스트림 사용을 제공한다.
			
			//4. 파일 읽기
			BufferedReader reader = new BufferedReader(new FileReader(".\\data\\data.txt"));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			System.out.println();

			
			//Path path = Paths.get(".\\data\\data.txt");
			//Files.lines(path);
			
			Files.lines(Paths.get(".\\data\\data.txt")).forEach(ln -> System.out.println(ln));
			System.out.println();
			
			
			//5.
			//File dir = new File("C:\\class\\server");
			//File[] list = dir.listFiles();
			
			Path workspace = Paths.get("C:\\class\\server"); //현재 폴더
			Files.list(workspace).forEach(path -> System.out.println(path.toString())); //Stream<Path>
			System.out.println();
			
			//JDK 1.8에서 스트림과 람다식이 제공되면서
			//기존에 사용하던 집합을 다루는 기능 중 일부에게
			//스트림과 람다식을 사용할 수 있도록 추가 기능을 제공한다.
			
			
		} catch (Exception e) {
			System.out.println("Ex05.m3()");
			e.printStackTrace();
		}
		
		
		
		
		
	}

	private static void m2() {
		

		/*
		 * int[] nums1 = Data.getIntArray(); System.out.println(nums1.length);
		 * System.out.println(Arrays.toString(nums1));
		 * 
		 * int[] nums2 = Data.getIntArray(10); System.out.println(nums2.length);
		 * System.out.println(Arrays.toString(nums2));
		 * 
		 * List<Integer> nums3 = Data.getIntList(5); System.out.println(nums3);
		 * 
		 * List<String> list = Data.getStringList(10); System.out.println(list);
		 */
		
		Data.getIntList().stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		Data.getStringList(10).stream().forEach(word -> System.out.printf("%s(%d)\n",  word, word.length()));
		
		
	}

	private static void m1() {

		int[] nums = { 1, 8, 2, 3, 9, 4, 7, 5, 6 };
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		//탐색
		//1. for문
		for(int i=0; i< nums.length; i++) {
			System.out.printf("%4d", nums[i]);
			nums2.add(nums[i]);
		}
		System.out.println();
			
		//2. 향상된 for문
		for(int n : nums) {
			System.out.printf("%4d", n);
		}
		System.out.println();
			
		//3. iterator
		// - iterator() 메소드 제공 > Iterator 탐색 가능 
		Iterator<Integer> iter = nums2.iterator();
		
		while(iter.hasNext()) {
			System.out.printf("%4d", iter.next());
		}
		System.out.println();
			
		//4. Stream
		// - stream() 메소드 제공 > Stream 탐색 가능
		// - Arrays.stream(배열)
		// - 컬렉션.stream()
		// - 함수 지향형 프로그래밍 > 메소드 체이닝 형태로 코딩하는 것을 지향한다.
		
		IntStream istream = Arrays.stream(nums);
		Stream<Integer> stream = nums2.stream();
		
		//스트림 지원 메소드 다양
		// - forEach()
		Consumer<Integer> c1 = n -> System.out.println(n);
		//c1.accept(10);
		
		nums2.stream().forEach(c1); //c1를 9번 호출
		System.out.println();
		
		nums2.stream().forEach(new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		});
		
		//최종 형태 > 탐색
		nums2.stream().forEach(n -> System.out.println(n));
		
		
		
		/*
		기시감
		- JavaScript
		
		let list = [ 10, 20, 30, 40, 50 ];
		
		list.forEach(function(index, item){
			//배열의 요소를 하나 넘겨준 뒤 함수 한번 호출 x 5번
		});
		
		//람다식(X) -> 화살표 함수(Arrow Function)
		list.forEach(() => {
		
		});
		
		*/
		
		System.out.println();
		Arrays.stream(nums).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		//이름이 3글자 이상과 미만을 구분해서 출력하세요.
		List<String> names = new ArrayList<String>();
		
		names.add("홍길동");
		names.add("김아무개");
		names.add("정하하호호호");
		names.add("최민");
		names.add("박우하하하호호호하하하하하");
		
		
		//for() {
		//	if()
		//		출력
		//}
		
		//객체 지향 프로그래밍 방식 -> 함수형 프로그래밍 방식
		names.stream().forEach(name -> {
			if(name.length() >= 3) {
				System.out.println("긴이름: " + name);
			}else {
				System.out.println("짧은이름: " + name);
			}
		});
		
		
	}
	
	
}//Ex05

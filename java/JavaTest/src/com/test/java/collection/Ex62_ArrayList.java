package com.test.java.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex62_ArrayList {
	
	// 학생 목록   //멤버변수로 선언. 
	//Student[] list = new Student[5]; //<-배열로 만든다면 
	
	// 학생 수 증가 할 수 있으니까> 배열길이 가변인 ArrayList로 배열 만들기.
	//main메소드에서 사용할 수 있게 static으로 선언. 
	private static ArrayList<Student> list; 
	private static Scanner scan;
	
	//정적 생성자
	static {   //멤버는 생성자를 통해 초기화.
		list = new ArrayList<Student>();
		scan = new Scanner(System.in);
	}
	
	//main 메소드
	public static void main(String[] args) {  //정적(static) 메소드에서는 객체를 볼 수 없음. this.사용불가! 
		
		// ArrayList 사용 -> 데이터 집합 -> 배열 사용 유사
		
		// 배열 vs ArrayList ? 
		// - 길이가 고정인가?
		// - 사용 편의성 -> ArrayList 편함
		
		// 학생 관리
		// - 정원 5명
		// - 추후 증가/감소
		
		// 학생
		// - 이름
		// - 나이
		// - 국어, 영어, 수학 점수
		
		// 학생 정보 관리
		// 메뉴
		// 1. 학생 추가
		// 2. 학생 목록
		// 3. 학생 삭제
		// 4. 학생 검색
		
		
		dummy();  //F3 -> 해당 메소드가 정의된 곳으로 이동하는 단축키
		
		
		System.out.println("[학생 정보 관리]");
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("==================");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 목록");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 학생 검색");
			System.out.println("5. 종료");
			System.out.println("==================");
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			if(sel.equals("1")) {
				add();
			}else if(sel.equals("2")) {
				list();
			}else if(sel.equals("3")) {
				delete();
			}else if(sel.equals("4")) {
				search();
			}else {
				loop = false;
			}
			
		}//while
		System.out.println("프로그램을 종료합니다.");
		
		
	}//main

	
	private static void dummy() {
		
		// 프로그램에서 사용할 임시 데이터 생성 메소드
		Random rnd = new Random();
		 
		String[] name = {"홍길동", "아무개", "고길동", "유재석", "강호동", "이광수", "송지효", "전소민", "양세찬"};
		
		for(int i=0; i<5; i++) {
			
			Student s = new Student();
			
			s.setName(name[rnd.nextInt(name.length)]); //0~8
			s.setAge(rnd.nextInt(5) + 15); // 15~19
			
			Subject subject = new Subject();
			subject.setKor(rnd.nextInt(40)+61); 
			subject.setEng(rnd.nextInt(40)+61); 
			subject.setMath(rnd.nextInt(40)+61); 
			
			s.setSubject(subject);
			
			list.add(s);
			
		}
		
	}//dummy

	private static void add() {
		
		//학생 추가
		System.out.println("[학생 추가]");
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("국어: ");
		int kor = scan.nextInt();
		
		System.out.print("영어: ");
		int eng = scan.nextInt();
		
		System.out.print("수학: ");  //100\r\n
		int math = scan.nextInt();  // 입력값에 포함된 엔터를 버리지 않고 남겨둔다.
		
		scan.skip("\r\n"); //남아있는 엔터가 다음 nextLine()에 영향을 주지 않도록 \r\n을 강제로 버퍼에서 지운다.
		
		//Case A. 
//		Subject subject = new Subject(kor, eng, math);
//		Student s = new Student(name, age, subject);
		
		//Case B.
		Student s = new Student(name, age, kor, eng, math);
		
		//목록에 추가하기
		list.add(s);
		
		System.out.println("학생 추가가 완료되었습니다.");
		
		pause();
		
	}//add
	
	private static void list() {
	
		System.out.println("======================================");
		System.out.println("[이름]\t[나이]\t[국어]\t[영어]\t[수학]");
		System.out.println("======================================");
		
		for(Student s : list) {
			System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\n"
					, s.getName()
					, s.getAge()
					, s.getSubject().getKor()
					, s.getEng()
					, s.getMath());
		}//for
		
		pause();
		
	}//list

	private static void delete() {
		
		System.out.println("[학생 삭제]");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		//indexOf 사용 불가 
		// -> 직접 탐색
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
			
		}
		
		System.out.println("학생 삭제를 완료했습니다.");
		pause();
		
		
	}//delete

	private static void search() {
		
		System.out.println("[학생 검색]");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.println("======================================");
		System.out.println("[이름]\t[나이]\t[국어]\t[영어]\t[수학]");
		System.out.println("======================================");
		
		for(int i=0; i<list.size(); i++) {
			
			//정확한 이름 검색
			//if(list.get(i).getName().equals(name)) {
			
			//부분검색
			//if(list.get(i).getName().indexOf(name) > -1) {
			if(list.get(i).getName().contains(name)) {
				System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\n"
						, list.get(i).getName()
						, list.get(i).getAge()
						, list.get(i).getSubject().getKor()
						, list.get(i).getEng()
						, list.get(i).getMath());
				
			}
			
		}
		
		pause();
		
	}//search
	
	private static void pause() {
		System.out.println("계속 하시려면 엔터를 입력하세요."); //프로그램을 잠깐 멈춤
		scan.nextLine();
	}//pause
	
}//Ex62_ArrayList

class Student{
	
	private String name;
	private int age;
	
//	private int kor;
//	private int eng;
//	private int math;
//	private int[] subject;
	
	private Subject subject;
	
	public Student() {  //기본 생성자
		this.name = "";
		this.age = 0;
		this.subject = null;
	}
	
	public Student(String name, int age, Subject subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	public Student(String name, int age, int kor, int eng, int math) {
		this.name = name;
		this.age = age;
		this.subject = new Subject(kor, eng, math);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	public void setKor(int kor) {
		this.subject.setKor(kor);
	}
	
	public void setEng(int eng) {
		this.subject.setEng(eng);
	}
	
	public void setMath(int math) {
		this.subject.setMath(math);
	}
	
	public int getKor() {
		return this.subject.getKor();
	}
	
	public int getEng() {
		return this.subject.getEng();
	}
	
	public int getMath() {
		return this.subject.getMath();
	}

	@Override
	public String toString() {
		return String.format("Student [name = %s, age = %d, kor = %d, eng = %d, math = %d]", 
				this.name,
				this.age,
				this.subject.getKor(),
				this.subject.getEng(),
				this.subject.getMath());
	}
	
	
	
}//Student

class Subject{
	
	private int kor;
	private int eng;
	private int math;
	
	public Subject() {  //기본 생성자
//		this.kor = 0;
//		this.eng = 0;
//		this.math = 0;
		this(0, 0, 0);
		
	}
	
	public Subject(int kor, int eng, int math) {  
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Subject [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

}//Subject



package com.test.java;

public class Ex05_DataType {
	
	public static void main(String[] args) {
		
		//1. 9개 자료형
		//2. 주변의 데이터 선택
		//3. 자료형 선택 + 변수 생성 + 데이터 대입 + 화면 출력
		//4. 각 자료형 X 10개
		
		//byte
		System.out.println("byte--------------------");
		byte age = 25;
		System.out.println("나이는: " +age +" 살입니다.");
		
		byte familyNum = 5;
		System.out.println("가족 구성원은: " +familyNum + "명 입니다.");
		
		byte alphabet = 52;
		System.out.println("알파벳은 총: " +alphabet + "갯수다.");
		
		byte consonant = 14;
		byte vowel = 10;
		System.out.printf("한글 자음은 %d개, 모음은 %d개이다" ,consonant, vowel);
		
		byte HarryPotter = 8;
		System.out.println("해리포터는 총: " +HarryPotter + "시리즈로 구성되어있다.");
		
		byte currentMonth = 3;
		System.out.println("오늘은 " +currentMonth+ "월 입니다.");
		
		byte currentDay = 31;
		System.out.println("오늘은 " +currentDay+"일입니다.");
	
		byte aptFloor = 30;
		System.out.println("아파트는 " +aptFloor + "층까지 있습니다.");
		
		byte subject = 12;
		System.out.println("전공과목은: " +subject +" 개입니다.");
		
		byte completeGrade = 60;
		System.out.println("이수학점 " +completeGrade +" 학점입니다.");
		
		//short 32767
		System.out.println("\nshort--------------------");		
		short year = 1997;
		System.out.println("태어난 년도는" +year + "년입니다.");
		
		short currentYear = 2021;
		System.out.println("현재는 " +currentYear + "년입니다.");
		
		short footsize = 240;
		System.out.println("발 사이즈는: " + footsize + "mm입니다.");
		
		short toeic = 800;
		System.out.println("토익 점수는: " + toeic + "점입니다.");
		
		short toeic1 = 990;
		System.out.println("토익 만점은 " + toeic1+ "점입니다.");
		
		short studentNum = 250;
		System.out.println("우리 과 학생 수: " +studentNum + "명입니다.");
		
		short graduate = 3000;
		System.out.println("올해 졸업생은: " +graduate + "명입니다.");
		
		short book = 979;
		System.out.println("Java책은 총: " + book + "장으로 되어있습니다.");
		
		short mountain1 = 8848;
		System.out.printf("에베레스트산의 높이는 약%dm이다.", mountain1);
		
		short mountain2 = 1950;
		System.out.printf("한라산의 높이는 약%dm이다.", mountain2);
	
		//int
		System.out.println("\nint--------------------");
		int kor = 88, math = 93, eng = 76 ;
		int sum =  kor + math + eng;
		System.out.printf("국어, 수학, 영어 점수의 총합: %d\n", sum);
		
		int suneung = 545966;
		System.out.printf("수능 응시자 수: %d명입니다.\n", suneung );
		
		int audience = 10310000;
		System.out.printf("기생충 관객수: %d명입니다.\n", audience);
		
		int width = 8;
		int length = 10;
		int height1 = 14;
		int volume = width * length * height1;
		System.out.printf("가로:%d, 세로:%d, 높이:%d인 직육면체의 부피는 : %d이다\n", width, length, height1, volume);
		
		int hour = 24;
		int minute = hour * 60;
		int second = minute * 60;
		
		System.out.printf("하루는 %d시간이다.\n", hour);
		System.out.printf("%d시간은 %d분이다.\n",hour, minute);
		System.out.printf("%d분은 %d초이다.\n", minute, second);
		
		//long
		System.out.println("\nlong--------------------");
		long koreaPopulation = 51821669;
		System.out.println("우리나라 인구수는 :" +koreaPopulation + "명입니다.");
		
		long USPopulation = 332915974;
		System.out.println("미국 인구수는 :" +USPopulation + "명입니다.");
		
		long ChinaPopulation = 1444216102;
		System.out.println("중국인구수는 :" +ChinaPopulation + "명입니다.");		

		long indeaPopulation = 1393406102;
		System.out.println("인도 인구수는 :" +indeaPopulation + "명입니다.");
		
		long brazilPopulation = 213993441;
		System.out.println("브라질 인구수는 :" +brazilPopulation + "명입니다.");
		
		long output = 542232610000L;
		System.out.println("한국의 수출양은 " +output + "달러이다.");
		
		long input = 503342947000L;
		System.out.println("한국의 수입은 " +input + "달러이다.");
		
		long worldPopulation = 7874695732L;
		System.out.println("전 세계 인구수는 :" +worldPopulation + "명입니다.");
		
		long covid_19 = 103088;
		System.out.println("우리나라 코로나 확진자수는 : " +covid_19+ "명입니다.");
		
		long sale = 300000000;
		System.out.printf("가게의 연매출은: %,d원이다\n",sale);
		
		//float
		System.out.println("\nfloat--------------------");
		float degree = 3.3F;
		System.out.println("학점은 :" +degree + "입니다.");
		
		float height = 161.8F;
		System.out.println("키는 :" +height+ " cm입니다.");

		float weight = 50.2F;
		System.out.println("몸무게는 :" +weight + "kg입니다.");
				
		float weather1 = 20.0F;
		System.out.println("현재 기온은 :" +weather1 + "도입니다.");
		
		float weather2 = -70.0F;
		System.out.println("북극의 기온은 :" +weather2 + "도입니다.");
		
		float rVisualAcuity = 1.0F;
		System.out.println("오른쪽 시력은 :" +rVisualAcuity + "입니다.");
		
		float lVisualAcuity = 0.8F;
		System.out.println("왼쪽 시력은 :" +lVisualAcuity + "입니다.");
		
		float ratings = 29.2F;
		System.out.println("펜트하우스의 최고시청률은 :" +ratings + "입니다.");
		
		float movieRating1 = 9.07F;
		System.out.println("기생충 평점 :" +movieRating1 + "입니다.");
		
		float movieRating2 = 8.33F;
		System.out.println("미나리 평점 :" +movieRating2 + "입니다.");
		
		//double
		System.out.println("\ndouble--------------------");
		double pi = 3.141592643589793238462643383279D;
		System.out.println("원주율 : " +pi+"입니다.");
		
		int radius = 10;
		double circleArea = pi * radius * radius;
		System.out.printf("반지름 %d의 원의 넓이는: %f\n", radius, circleArea);
		
		double avg;
		avg = sum/3;
		System.out.println("국어, 영어, 수학의 평균 점수: " +avg);
		
		double celsius = 1; //섭씨
		double fahrenheit = 33.8; //화씨 
		System.out.println("섭씨온도 " +celsius+ "도는 -> 화씨온도 " +fahrenheit+"도이다");
				
		int gram = 1; 
		double ton = 0.000001; 
		System.out.printf("%dg은 %fton이다.\n", gram, ton);
		
		int meter = 1;
		double ha= 0.0001;
		System.out.printf("%d(m^2)는 %f(ha)입니다.", meter, ha);
		
		double koreaArea = 10036371.5;
		System.out.println("우리나라 면적은 :" +koreaArea + "(ha)입니다.");
		
		double USArea = 983151000;
		System.out.println("미국 면적은 :" +USArea + "(ha)입니다.");
		
		double chinaArea = 900061080;
		System.out.println("중국 면적은 :" +chinaArea + "(ha)입니다.");
		
		//char
		System.out.println("\nchar--------------------");
		char gender = '여';
		System.out.println("성별은: '" +gender+ "'입니다.");
		
		char grade1 = 'A';
		char grade2 = 'B';
		char grade3 = 'C';
		char grade4 = 'D';
		char grade5 = 'F';
		System.out.printf("학점은 %c,%c,%c,%c,%c등급으로 나뉜다.\n" ,grade1,grade2,grade3,grade4,grade5);
	
		char familyname = '신';
		System.out.printf("나의 성은: %c이다\n", familyname);
		
		char familyname1 = '김';
		char familyname2 = '이';
		char familyname3 = '박';
		
		System.out.printf("성씨 중에는 %c, %c, %c이 제일 많다.\n", familyname1,familyname2,familyname3);
	
		//boolean
		System.out.println("\nboolean--------------------");
		boolean num1 = true;
		boolean num2 = false;
		System.out.println("10 < 3 : " +num2);
		System.out.println("10 > 3: " +num1);
		System.out.println("'A' > 'B': " +num2);
		System.out.println("'C' > 'A': " +num1);
		System.out.println("6 == 3: " +num2);
		System.out.println("7 >= 6 " +num1);
		System.out.println("19 <= 6: " +num2);
		
		boolean a = '가'<'다';
		boolean b = '사'> '하';
		boolean c = 'A'>'F'; 
		System.out.println(a);			
		System.out.println(b);			
		System.out.println(c);			
		
		//String
		System.out.println("\nString--------------------");
		String name = "신시내";		
		String birthDay = "970509";		
		String address = "경기도 용인시";		
		System.out.printf("이름: %s\n생년월일: %s\n주소: %s\n", name, birthDay, address);
		
		String phoneNumber = "010-9063-3976";
		System.out.println("전화번호는:"  +phoneNumber);
		
		String email = "sioi35@naver.com";
		System.out.println("email: " +email);
		
		String university = "순천향대학교";
		System.out.println("대학교: " +university);
		
		String studentNumber = "20165185";
		System.out.println("학번은:" +studentNumber);
		
		String blood = "AB";
		System.out.println("혈액형은: " +blood+"형");
		
		String size = "m";
		System.out.println("옷 사이즈는: " +size);
		
		String season ="봄";
		System.out.printf("현재 계절: %s\n" ,season);
		
	}
}

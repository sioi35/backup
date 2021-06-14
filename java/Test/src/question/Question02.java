package question;

public class Question02 {
	
	public static void main(String[] args) {
		
		
		String name1 = "홍길동";
		String name2 = "아무개";
		String name3 = "하하하";
	
		int kor1 = 80;
		int kor2 = 76;
		int kor3 = 89;
		
		int eng1 = 90;
		int eng2 = 86;
		int eng3 = 92;
		
		int math1 = 95;
		int math2 = 79;
		int math3 = 85;
		
		double avg1 = (kor1 + eng1 + math1) / 3;
		double avg2 = (kor2 + eng2 + math2) / 3;
		double avg3 = (kor3 + eng3 + math3) / 3;
		
		
		System.out.println("[학생]\t[국어]\t[영어]\t[수학]\t[평균]");
		System.out.println("--------------------------------------");
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5.0f\n", name1, kor1, eng1, math1, avg1 );
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5.0f\n", name2, kor2, eng2, math2, avg2 );
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5.0f\n", name3, kor3, eng3, math3, avg3 );
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}

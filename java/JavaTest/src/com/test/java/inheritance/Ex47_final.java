package com.test.java.inheritance;

public class Ex47_final {

	public static void main(String[] args) {
		
		// final 키워드
		// - 수정할 수 없다.
		// 1. 변수에 적용 가능
		// 	a. 지역 변수에 적용 가능
		// 	b. 멤버 변수에 적용 가능
		// 2. 메소드에 적용가능
		// 3. 클래스에 적용가능
		
		
		//1. a
		// - 값을 초기화한 뒤에는 수정할 수 없다.
		// - 고칠 수 없는 변수, 수정할 수 없는 변수
		// - 상수명(final 변수명)은 항상 모두 대문자로 만든다.(관습)
		
		// - 10 //상수 -> 리터럴 -> 이름없는 상수
		// - int a //변수
		// - final int a // final 변수(=상수) -> 이름있는 상수(*****)
		
		int a = 10; //일반 변수
		final int b = 20; // final 변수
		
		System.out.println(a);
		System.out.println(b);
		
		a = 30;
		//b = 40; //The final local variable b cannot be assigned.
		
		// 상수값 -> 3.14
		// double pi = 3.14
		//pi = 1.11;
		//System.out.println(pi);
		//final double pi = 3.14; //변경하면 안되는 값 -> final 변수로
		
		final double PI = 3.14;
		//PI = 1.11;
		System.out.println(PI);
		
		FinalItem f1 = new FinalItem();
		//f1.C = 100; -> final값은 못 바꿈.
		System.out.println(f1.C); // 개인정보 -> 다른 객체와 다른 값을 가질 수 있다.
		System.out.println(f1.D); //공용정보 -> 다른 객체와 다른 값을 가질 수 없다. -> 모두 같은 값
		
		FinalItem f2 = new FinalItem();
		//f2.C = 200;
		System.out.println(f2.C); //개인정보 -> 다른 객체와 다른 값을 가질 수 있다.
		System.out.println(f2.D); //공용정보 -> 다른 객체와 다른 값을 가질 수 없다. -> 모두 같은 값
		
		
	}//main
	
}//Ex47_final


class FinalItem{
	
	private int a = 10; //일반 객체 멤버 변수 (private? 변수에 잘못된 값을 넣을까봐 -> Getter, Setter 이용해 접근)
	private final int B = 20; // 객체 멤버 상수
	public final int C = 30; // 멤버 상수는 접근 지정자를 public으로 하는 경우가 많다. ? (public으로 해도 잘못된 값이 들어갈 일이 없음.)
	
	public final static int D = 40; // 정적 상수 -> 가장 많이 사용
	
}

// 홍길동 제작
// -> 길동이는 FinalParent 클래스가 부모가 되길 바라지 않음. 상속에 사용되지 않았으면 좋겠다.
// -> 더이상 자식을 가질 수 없는 클래스 > 최종 클래스(Leaf Class)
final class FinalParent{
	
	// 홍길동이 test()를 만든 의도
	// -> 이 메소드는 나중에 자식이 고치면 절대 안돼!!
	// - 코드 안정성 향상 !
	public final void test() {
		System.out.println("부모 행동");
	}	
}


// 아무개 제작
//class FinalChild extends FinalParent{ //The type FinalChild cannot subclass the final class FinalParent
	
	// 고치지 말라는 메소드를 고침!! -> 예기치 못한 문제 발생 가능성 !!!
//	@Override
//	public void test() { //Cannot override the final method from FinalParent
//		System.out.println("자식 행동");
//	}
	
//}

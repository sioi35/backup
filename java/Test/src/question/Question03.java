package question;

public class Question03 {
	
	public static void main(String[] args) {
	
		String date1 = "2020-01-01";
		String date2 = "2020-01-02";
		String date3 = "2020-01-03";
		String date4 = "2020-01-04";
		String date5 = "2020-01-05";
		
		String content1 = "카페라떼";
		String content2 = "돼지불백";
		String content3 = "마트 장본것들";
		String content4 = "교통 카드 충전";
		String content5 = "편의점";
		
		int price1 = 4800;
		int price2 = 8500;
		int price3 = 125840;
		int price4 = 45000;
		int price5 = 16200;
	
		System.out.println("[날짜]\t\t[내역]\t\t\t[금액]");
		System.out.println("-------------------------------------------------");
		System.out.printf("%s\t%s\t\t\t%,7d\n", date1, content1, price1);
		System.out.printf("%s\t%s\t\t\t%,7d\n", date2, content2, price2);
		System.out.printf("%s\t%s\t\t%,7d\n", date3, content3, price3);
		System.out.printf("%s\t%s\t\t%,7d\n", date4, content4, price4);
		System.out.printf("%s\t%s\t\t\t%,7d\n", date5, content5, price5);
		
	}
}

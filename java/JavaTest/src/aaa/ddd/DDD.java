package aaa.ddd;

public class DDD {

public static void main(String[] args) {
		
		//서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
		
		int total = 0;
		int year = 2021;
		int month = 4;
		int date = 9;
		
		for (int i=1; i<year; i++) {
			if (isLeaf(i)) {
				total += 366;
			} else {
				total += 365;
			}
		}
		
		for (int i=1; i<month; i++) {
			switch (i) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					total += 31;
					break;
				case 4: case 6: case 9: case 11:
					total += 30;
					break;
				case 2:
					if (isLeaf(year)) {
						total += 29;
					} else {
						total += 28;
					}
					break;
			}
		}
		
		total += date;
		
		
		
		String day = "";
		
		if (total % 7 == 1) {
			day = "월요일";
		} else if (total % 7 == 2) {
			day = "화요일";
		} else if (total % 7 == 3) {
			day = "수요일";
		} else if (total % 7 == 4) {
			day = "목요일";
		} else if (total % 7 == 5) {
			day = "금요일";
		} else if (total % 7 == 6) {
			day = "토요일";
		} else if (total % 7 == 0) {
			day = "일요일";
		}
		
		
		System.out.printf("%d년 %d월 %d일 %s은 %,d일째 되는 날입니다.\n", year, month, date, day,  total);
		
		
		
		
		
		
		
	}

	private static boolean isLeaf(int year) {
		
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}

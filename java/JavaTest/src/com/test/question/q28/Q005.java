package com.test.question.q28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q005 {

	private static Scanner scan;
	private final static String DATA1;
	private final static String DATA2;

	static {
		scan = new Scanner(System.in);
		DATA1 = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\검색_회원.dat";
		DATA2 = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\검색_주문.dat";
	}

	public static void main(String[] args) {

		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(DATA1));

			String line1 = "";

			System.out.print("이름: ");
			String member = scan.nextLine();
			
			while ((line1 = reader1.readLine()) != null) {

				String[] temp1 = line1.split(",");

				String memNumber = temp1[0];
				String name = temp1[1];
				String address = temp1[2];

				if (name.equals(member)) {
					BufferedReader reader2 = new BufferedReader(new FileReader(DATA2));
					String line2 = "";
					while ((line2 = reader2.readLine()) != null) {
						String[] temp2 = line2.split(",");
						String product = temp2[1];
						String amount = temp2[2];
						String number = temp2[3];
						
						if(memNumber.equals(number)) {
							System.out.println("=============구매 내역=============");
							System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
							System.out.printf("%s\t%s\t%s\t%s\t%s\n",memNumber, name, product, amount, address);
						} 
						
					}

				}

			}
			System.out.println("검색완료");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
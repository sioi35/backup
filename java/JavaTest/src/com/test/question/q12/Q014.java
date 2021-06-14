package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q014 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int oddSum = 0;
		int evenSum = 0;
		
		System.out.print("9자리이하 숫자 입력: ");
		int num = Integer.parseInt(reader.readLine());
		
		int a = 0, b = 0;
		if(num<1000000000) {
			for(int i = 0; ; i++) {
				
				a = (int)(num*Math.pow(10, -i)) ; // num=12345; num*Math.pow(10,-1)-> 1234.5-> int로 소수점 제거 1234
				b= (int)(num*Math.pow(10, -i -1)); //123.45->123
				
				if(b<=0) { //b가 0.1-> 0이 되면 %연산을 할 수 없으므로 
					b= (int)(num*Math.pow(10, -i -1)*10); //b에 x10해줘 0.1-> 1로 만듬
					b*=10; //-> 마지막 자리수를 올바르게 뽑기 위해 10을 곱해줌 -> 만약 1이라면 모든 숫자에 나눠도 나머지는 0이 되버리니까
					System.out.printf("%d %% %d = %d\n", a,b,a%b);
					if((a % b) % 2 ==0) {  //a의 마지막 자리수가 짝수인지 홀수인지 판별.
						evenSum += a % b;
					}else {
						oddSum += a % b;
					}
					break;
				}else {
					b*=10; 
					System.out.printf("%d %% %d = %d\n", a,b,a%b);
					if((a % b) % 2 ==0) {
						evenSum += a % b;
					}else {
						oddSum += a % b;
					}
				}
				
					
			}// for문		
			System.out.printf("짝수의 합 : %d\n", evenSum);
			System.out.printf("홀수의 합 : %d\n", oddSum);
		}else {
			System.out.println("시스템 종료!");
		}
		
	}//main
	
}//Q014

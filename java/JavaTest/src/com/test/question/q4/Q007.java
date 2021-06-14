package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수:");
		int stationNum = Integer.parseInt(reader.readLine());
		
		System.out.print("환승역의 개수:");
		int transferNum = Integer.parseInt(reader.readLine());
		
		System.out.print("시간대(보통(0), 출근(1), 퇴근(2) 중 택 1):");
		int splitTime = Integer.parseInt(reader.readLine());//split-time : 시간대별
		 
	
		System.out.printf("총 소요시간은 : %d분 입니다\n", getTime(stationNum, transferNum, splitTime));
	}//main
	
	public static int getTime(int stationNum, int transferNum, int splitTime) {
		int stationTime = 2;  // 역간 소요시간
		int transferTime = 3;     // 환승 시간
		
		transferTime = (splitTime == 0)? transferTime : transferTime;      // 보통 시간대는 그대로
		
		transferTime = (splitTime == 1) ? transferTime + 1: transferTime;  // 출근시간대에 환승시간 1분 더 소요
		
		transferTime = (splitTime == 2) ? transferTime + 2 : transferTime; // 출근시간대에 환승시간 2분 더 소요
		
		int time = stationNum * stationTime + transferNum * transferTime;
		
		return time;
	}

	
}//Q007

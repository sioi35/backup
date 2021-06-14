package com.test.question.q28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q002 {

	public static void main(String[] args) {

		String path = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\숫자.dat";
		File dir = new File(path);

		String path2 = "C:\\Users\\sioi3\\Desktop\\Downloads\\파일_입출력_문제\\숫자_변환.dat";
		File dir2 = new File(path2);

		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			BufferedWriter writer = new BufferedWriter(new FileWriter(path2));
			String line = "";
			String result = "";

			while ((line = reader.readLine()) != null) {
				line = line.replace("0", "영");
				line = line.replace("1", "일");
				line = line.replace("2", "이");
				line = line.replace("3", "삼");
				line = line.replace("4", "사");
				line = line.replace("5", "오");
				line = line.replace("6", "육");
				line = line.replace("7", "칠");
				line = line.replace("8", "팔");
				line = line.replace("9", "구");

				result += line + "\r\n";

			} // while

			writer.write(result);

			writer.close();
			reader.close();

			System.out.println(dir.renameTo(dir2));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main

}// Q002

package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	private static Scanner scan;
	private final static String DATA1;
	private final static String DATA2;
	private final static String DATA3;
	private static ArrayList<Employee> list;
	private static ArrayList<String> sameName;

	static String id;
	static String pw;

	static {
		scan = new Scanner(System.in);
		DATA1 = "C:\\Project\\직원더미.txt";
		DATA2 = "C:\\Project\\직원연차더미.txt";
		DATA3 = "C:\\Project\\직원출퇴근더미.txt";
		list = new ArrayList<Employee>();
		sameName = new ArrayList<String>();

	}

	public static void main(String[] args) {

		time();

		//System.out.println(sameName);
		no();

	}// main

	private static void no() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA3));

			String line = "";

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("■");

				String date = temp[0];
				String name = temp[1];

				for (int i = 0; i < sameName.size(); i++) {

					if (sameName.get(i).equals(date + "■" + name)) {
						break;
					}else {
						if(i==sameName.size()-1) {
							//System.out.println(sameName.get(i));
						}
						
					}

				}

			} // while

			reader.close();

		} catch (Exception e) {
			System.out.println("load: " + e);
		}

	}

	private static void time() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA2));

			String line = "";

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("■");

				String name = temp[0];
				// System.out.println(name);

				while (!(line = reader.readLine()).equals("=============")) {

					String[] temp123 = line.split(",");// 연차 날짜

					int num = temp123.length;// 5

					// System.out.println(num);

					for (int i = 0; i < num; i++) {

						BufferedReader reader123 = new BufferedReader(new FileReader(DATA3));
						String line123 = "";

						while ((line123 = reader123.readLine()) != null) {
							String[] temp12345 = line123.split("■");

							String date = temp12345[0];
							String dateName = temp12345[1];

							if (temp123[i].equals(date) && dateName.equals(name)) {
								//System.out.println(date+"■"+name);
								//break;
								sameName.add(date + "■" + name);
							}

						}

					}

				}

			} // while

			reader.close();

		} catch (Exception e) {
			System.out.println("load: " + e);
		}

	}

}

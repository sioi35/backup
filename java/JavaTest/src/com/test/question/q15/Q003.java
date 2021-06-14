package com.test.question.q15;

public class Q003 {

	public static void main(String[] args) {
		
		int[] list = new int[4];
		
		for(int i=0; i<list.length; i++) {
			list[i]= (i+1)*10;
		}
		String result = dump(list);
		System.out.printf("nums = %s\n",result);
	}//main
	
	private static String dump(int[] list) {
		String nums = "";
		
		for(int i =0 ; i<list.length; i++) {
			if(i==list.length-1) {
				nums += list[i];
			}else {
				nums += list[i] +", ";				
			}
		}

		return "[" + nums + "]";
	}

	
}//Q003

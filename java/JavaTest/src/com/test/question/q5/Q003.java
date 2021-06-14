package com.test.question.q5;

public class Q003 {
	
	public static void main(String[] args) {
	      
	      System.out.printf("양수 : %d개\n", positive(10));
	      System.out.printf("양수 : %d개\n", positive(10, 20));
	      System.out.printf("양수 : %d개\n", positive(10, 20, -30));
	      System.out.printf("양수 : %d개\n", positive(10, 20, -30, 40));
	      System.out.printf("양수 : %d개\n", positive(10, 20, -30, 40, 50));
	      
	      
	   }//main
	   
	   public static int positive(int a) {
	      
	      int num = 0;
	      num = (a > 0) ? num + 1 : num;
	      
	      return num;
	   }
	   
	   public static int positive(int a, int b) {
	      
	      int num = 0;
	      num = (a > 0) ? num + 1 : num;
	      
	      num = (b > 0) ? num + 1 : num;
	            
	      return num;
	   }
	   
	   public static int positive(int a, int b, int c) {
	      
	      int num = 0;
	      num = (a > 0) ? num + 1 : num;
	      
	      num = (b > 0) ? num + 1 : num;
	      
	      num = (c > 0) ? num + 1 : num;
	            
	   
	      return num;
	   }
	   
	   public static int positive(int a, int b, int c, int d) {
	      
	      int num = 0;
	      num = (a > 0) ? num + 1 : num;
	      
	      num = (b > 0) ? num + 1 : num;
	      
	      num = (c > 0) ? num + 1 : num;
	      
	      num = (d > 0) ? num + 1 : num;
	               
	      return num;
	   }
	   
	   public static int positive(int a, int b, int c, int d, int e) {
	      
	      int num = 0;
	      num = (a > 0) ? num + 1 : num;
	      
	      num = (b > 0) ? num + 1 : num;
	      
	      num = (c > 0) ? num + 1 : num;
	      
	      num = (d > 0) ? num + 1 : num;
	      
	      num = (e > 0) ? num + 1 : num;
	            
	      return num;
	   }

	
	
}//Q003



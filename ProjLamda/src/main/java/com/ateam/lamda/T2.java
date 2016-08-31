package com.ateam.lamda;

public class T2 {

	public static void main(String[] args) {
 
		eval((a,b) -> a * b);
	}
	
	static void eval(FI fi)
	{
		System.out.println(fi.something(1,2));
	}

	
	@FunctionalInterface
	interface FI
	{
		public int something(int a, int b);
	}
	
}

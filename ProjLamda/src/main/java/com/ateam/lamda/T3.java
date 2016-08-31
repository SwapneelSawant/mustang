package com.ateam.lamda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T3 {

	private static List<Integer> l = new ArrayList<Integer>();
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			l.add(i);
		}
		timeEval(() -> Collections.sort(l, (i, j) -> i.compareTo(j) *-1));
		timeEval();
	}

	public static void timeEval(FI fi)
	{
		long t = System.currentTimeMillis();
		
		fi.eval();
		
		System.out.println("Time elapse "+ (System.currentTimeMillis() - t));
	}
	
	public static void timeEval()
	{
		long t = System.currentTimeMillis();
		
		Collections.sort(l, (i, j) -> i.compareTo(j) *-1);
		
		System.out.println("Time elapse "+ (System.currentTimeMillis() - t));
	}
	
	
	interface FI
	{
		public void eval();
	}
}

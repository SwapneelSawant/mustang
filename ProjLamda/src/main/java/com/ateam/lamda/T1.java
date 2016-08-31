package com.ateam.lamda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
sort();
	}
	
	public static void sort()
	{
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			l.add(i);
		}
			Collections.sort(l, (i, j) -> i.compareTo(j) *-1);
			System.out.println(l);
			//l.stream().parallel().forEach(i -> System.out.print(i));
	}
	
	public static void methodPassing()
	{
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			l.add(i);
		}
		Collections.sort(l, (i,j) -> doSomething() );
		Collections.sort(l, (i,j) ->  new T1().doSomething(i) );
	}
	
	 static int doSomething()
	{
		System.out.println("Something");
		return 0;
	}
	
	int doSomething(int i)
	{
		System.out.println("Something "+i);
		return i;
	}

}

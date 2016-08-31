package com.ateam.lamda;

import java.util.function.Predicate;

public class T5 {

	T5()
	{
		
	}
	
	public static void main(String[] args) {

		object(s -> s.equals("a"));
		String s = "a";
		object(s::equals );
		
	}

	static void object(Predicate<String> s)
	{
		System.out.println(s.test("a"));
	}
}

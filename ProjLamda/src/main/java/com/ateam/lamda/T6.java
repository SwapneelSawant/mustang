package com.ateam.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class T6 {

	T6()
	{
		
	}
	
	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		object(s -> s.equals("a"), c -> l.add(c));
		String s = "a";
		System.out.println(l);
		object(s::equals, l::add);
		System.out.println(l);
		
	}

	static void object(Predicate<String> p, Consumer<String> c)
	{
		System.out.println(p.test("a"));
		c.accept("a");
	}
}

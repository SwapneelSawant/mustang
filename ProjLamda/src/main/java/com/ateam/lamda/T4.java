package com.ateam.lamda;

import java.util.function.Function;

public class T4 {

	public static void main(String[] args) {
		staticMethodPassing((t) -> Math.abs(t));
		
		staticMethodPassing(Math::abs);
	}

	
	public static void staticMethodPassing(Function<Double, Double> func)
	{
		double d = 10;
		func.apply(d);
	}
	
	
}

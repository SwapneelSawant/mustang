package com.ateam.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.ateam.lamda.T7.Person.Sex;

public class T7 {

	T7()
	{
		
	}
	
	public static void main(String[] args) {

		
		List<Person> l = new ArrayList<Person>();
		Iterable<Person> roster = l;
		
		
		processElements(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25,
			    p -> p.getEmailAddress(),
			    email -> System.out.println(email)
			);
	}

	public static <X, Y> void processElements(
		    Iterable<X> source,
		    Predicate<X> tester,
		    Function <X, Y> mapper,
		    Consumer<Y> block) {
		    for (X p : source) {
		        if (tester.test(p)) {
		            Y data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}
	
	static public class Person {

	    public enum Sex {
	        MALE, FEMALE
	    }

	    String name;
	    Sex gender;
	    
	    int  age;
	    
	    String emailAddress;

	    public int getAge() {
	        return age;
	    }

	    public Object getEmailAddress() {
			return emailAddress;
		}

		public Sex getGender() {
			return gender;
		}

		public void printPerson() {
	        System.out.println(name +" "+age);
	    }
	}
}

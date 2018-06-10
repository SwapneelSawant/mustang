package com.mustang.rnd.guava;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderingExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer> ();

        numbers.add ( new Integer ( 5 ) );
        numbers.add ( new Integer ( 2 ) );
        numbers.add ( new Integer ( 15 ) );
        numbers.add ( new Integer ( 51 ) );
        numbers.add ( new Integer ( 53 ) );
        numbers.add ( new Integer ( 35 ) );
        numbers.add ( new Integer ( 45 ) );
        numbers.add ( new Integer ( 32 ) );
        numbers.add ( new Integer ( 43 ) );
        numbers.add ( new Integer ( 16 ) );
        numbers.add ( null );

        /*
            Call compare to method
         */
        Ordering.natural ();
        /*
        chaining comparator
         Ordering.compound ()
         */


        /*
            throws Assertion Exception in rare scenario.
         */

        Ordering ordering = Ordering.arbitrary ();
        System.out.println ( "Input List: " );
        System.out.println ( numbers );
        Collections.sort ( numbers, ordering );
        System.out.println ( "Sorted List: " );
        System.out.println ( numbers );
        Collections.sort ( numbers, ordering.nullsFirst () );
        System.out.println ( "Sorted List: " );
        System.out.println ( numbers );

    }
}

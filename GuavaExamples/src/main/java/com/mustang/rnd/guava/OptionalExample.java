package com.mustang.rnd.guava;

import com.google.common.base.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Integer i1 = null;
        Integer i2 = 10;
        /*
         * mix of java 8
         */
        java.util.Optional<Integer> integerOptional1 = java.util.Optional.ofNullable ( i1 );
        Optional<Integer> integerOptional2 = Optional.fromNullable ( i2 );
        System.out.println ( sum ( integerOptional1, integerOptional2 ) );
    }

    private static int sum(java.util.Optional<Integer> integerOptional1, Optional<Integer> integerOptional2) {
        int i1 = integerOptional1.orElse ( 0 );
        int i2 = integerOptional2.get ();
        return i1 + i2;
    }

}

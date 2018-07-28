package com.mustang.rnd.guava;

import com.google.common.base.Throwables;

import java.io.IOException;

public class ThrowableExamples {

    public static void main(String args[]) {

        ThrowableExamples tester = new ThrowableExamples ();

        try {
            tester.showcaseThrowable ();

        } catch (InvalidInputException e) {
            //get the root cause
            System.out.println( Throwables.getRootCause(e));

        } catch (Exception e) {
            //get the stack trace in string format
            System.out.println(Throwables.getStackTraceAsString(e));
        }

        try {
            tester.showcaseThrowable1 ();

        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }
    }

    public void showcaseThrowable() throws InvalidInputException {
        try {
            sqrt(-3.0);
        } catch (Throwable e) {
            //check the type of exception and throw it
            Throwables.propagateIfInstanceOf(e, InvalidInputException.class);
            Throwables.propagate(e);
        }
    }

    public void showcaseThrowable1() {
        try {
            int[] data = {1,2,3};
            getValue(data, 4);
        } catch (Throwable e) {
            Throwables.propagateIfInstanceOf(e, IndexOutOfBoundsException.class);
            Throwables.propagate(e);
        }
    }

    public double sqrt(double input) throws InvalidInputException {
        if(input < 0) throw new InvalidInputException();
        return Math.sqrt(input);
    }

    public double getValue(int[] list, int index) throws IndexOutOfBoundsException {
        return list[index];
    }

    public void dummyIO() throws IOException {
        throw new IOException();
    }
}

class InvalidInputException extends Exception {
}
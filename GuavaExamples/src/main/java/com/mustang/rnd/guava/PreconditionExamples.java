package com.mustang.rnd.guava;

import com.google.common.base.Preconditions;

public class PreconditionExamples {

    public static void main(String[] args) {
        PreconditionExamples preconditionExamples = new PreconditionExamples ();
        Preconditions.checkArgument ( 10 == 11, "is %s too", "not equal" );
        Preconditions.checkElementIndex ( 10, 3 );
        Preconditions.checkNotNull ( preconditionExamples );
        Preconditions.checkState ( true );
    }
}

package com.apiUnitTest.apiUnitTest.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVariableUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String m){
        super(m);
    }


}

package com.cauegarcia.system.services.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String forbiddenException){
        super(forbiddenException);
    }
}

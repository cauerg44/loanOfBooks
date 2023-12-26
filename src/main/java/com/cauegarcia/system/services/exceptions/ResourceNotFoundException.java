package com.cauegarcia.system.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String exception){
        super(exception);
    }
}

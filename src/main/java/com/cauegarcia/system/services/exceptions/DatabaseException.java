package com.cauegarcia.system.services.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String databaseException){
        super(databaseException);
    }
}

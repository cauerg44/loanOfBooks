package com.cauegarcia.system.controllers.handlers;

import com.cauegarcia.system.entities.dto.CustomizedError;
import com.cauegarcia.system.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.module.ResolutionException;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomizedError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomizedError err = new CustomizedError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(404).body(err);
    }
}

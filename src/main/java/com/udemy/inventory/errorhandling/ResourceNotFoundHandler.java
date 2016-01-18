package com.udemy.inventory.errorhandling;

import com.udemy.inventory.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rene on 18/01/16.
 */
@ControllerAdvice
public class ResourceNotFoundHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException
                                                                     exception, HttpServletRequest request) {

        ErrorInformation errorInformation = new ErrorInformation.Builder().withDescription(exception.getMessage()).
                withStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(errorInformation, null, HttpStatus.NOT_FOUND);
    }


}

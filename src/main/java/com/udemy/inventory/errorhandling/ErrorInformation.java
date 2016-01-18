package com.udemy.inventory.errorhandling;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by rene on 18/01/16.
 */
public class ErrorInformation {

    public ErrorInformation(){
        super();
    }

    private HttpStatus status;
    private long timeStamp;
    private String description;

    public static class Builder{
        private ErrorInformation errorInformation;

        public Builder(){
            errorInformation = new ErrorInformation();
            errorInformation.timeStamp = new Date().getTime();
        }

        public Builder withStatus(HttpStatus httpStatus){
            errorInformation.status = httpStatus;
            return this;
        }

        public Builder withDescription(String description){
            errorInformation.description = description;
            return this;
        }

        public Builder withTimeStamp(long timeStamp){
            errorInformation.timeStamp = timeStamp;
            return this;
        }

        public ErrorInformation build(){
            return  errorInformation;
        }
    }
}

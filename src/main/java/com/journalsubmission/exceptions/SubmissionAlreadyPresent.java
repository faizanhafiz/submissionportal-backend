package com.journalsubmission.exceptions;

public class SubmissionAlreadyPresent extends  RuntimeException{
    public SubmissionAlreadyPresent(String message){
        super(message);
    }
    public SubmissionAlreadyPresent(String message, Exception ex){
        super(message,ex);
    }
}

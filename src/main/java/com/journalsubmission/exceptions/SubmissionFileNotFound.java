package com.journalsubmission.exceptions;

public class SubmissionFileNotFound extends  RuntimeException{
    public  SubmissionFileNotFound(String message){
        super(message);
    }
}

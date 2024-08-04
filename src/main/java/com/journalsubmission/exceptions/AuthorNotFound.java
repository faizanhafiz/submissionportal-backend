package com.journalsubmission.exceptions;

public class AuthorNotFound  extends  RuntimeException{
    public  AuthorNotFound(String message){
        super(message);
    }
}

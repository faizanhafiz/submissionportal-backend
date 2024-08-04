package com.journalsubmission.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({SubmissionAlreadyPresent.class})
    public ResponseEntity<Object> handleSubmissionAlreadyPresent(SubmissionAlreadyPresent exception){
        return ResponseEntity
                .status(HttpStatus.valueOf(403))
                .body(exception.getMessage());
    }

    @ExceptionHandler({SubmissionNotFound.class})
    public ResponseEntity<Object>  handleSubmissionNotFound(SubmissionNotFound exception){
        return  ResponseEntity.
                status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(SubmissionFileNotFound.class)
    public  ResponseEntity<Object> submissionFileNotPresent(SubmissionFileNotFound exception)
    {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(DataMissing.class)
    public ResponseEntity<Object> DataIsMissing(DataMissing exception){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> DataIsMissing(GeneralException exception){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(AuthorNotFound.class)
    public ResponseEntity<Object> DataIsMissing(AuthorNotFound exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }




}

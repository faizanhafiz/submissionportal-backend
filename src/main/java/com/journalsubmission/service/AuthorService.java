package com.journalsubmission.service;

import com.journalsubmission.exceptions.DataMissing;
import com.journalsubmission.exceptions.GeneralException;
import com.journalsubmission.pojo.Author;
import com.journalsubmission.repository.AuthorRepo;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRep) {
        this.authorRepo = authorRep;
    }

    public ResponseEntity<String> signUp(Author author) {
        Logger logger = LoggerFactory.getLogger(AuthorService.class);
        if (author.getEmail() == null) throw new DataMissing("Email is required");
        try {
            Author author1 = authorRepo.save(author);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Account has been created");

        } catch (MongoException ex) {
            logger.error("Error occurred while signing ");
            throw new GeneralException("Error occurred while signing ");
        }
    }

    public ResponseEntity<String> signIn(){

    }

}

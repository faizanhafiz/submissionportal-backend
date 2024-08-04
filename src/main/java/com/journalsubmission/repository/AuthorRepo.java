package com.journalsubmission.repository;

import com.journalsubmission.pojo.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author,String> {
}

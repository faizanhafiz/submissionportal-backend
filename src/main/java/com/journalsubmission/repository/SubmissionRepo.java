package com.journalsubmission.repository;

import com.journalsubmission.pojo.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepo extends MongoRepository<Submission,String> {

    @Query(value = "{ 'id' : { $in: ?0 } }")
    List<Submission> allSubmissionById(List<String> ids);

}

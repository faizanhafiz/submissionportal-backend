package com.journalsubmission.service;

import com.amazonaws.AmazonServiceException;
import com.journalsubmission.exceptions.*;
import com.journalsubmission.pojo.Author;
import com.journalsubmission.pojo.Submission;
import com.journalsubmission.repository.AuthorRepo;
import com.journalsubmission.repository.SubmissionRepo;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    private final SubmissionRepo submissionRepo;
    private final S3Service s3Service;
    private final AuthorRepo authorRepo;

    Logger logger = LoggerFactory.getLogger(SubmissionService.class);

    public SubmissionService(SubmissionRepo submissionRepo, S3Service s3Service, AuthorRepo authorRepo) {
        this.submissionRepo = submissionRepo;
        this.s3Service = s3Service;
        this.authorRepo = authorRepo;
    }

    public ResponseEntity<String> createSubmission(Submission submission) throws IOException {
        verify(submission);
        Submission response = submissionRepo.save(submission);
        try {
            s3Service.uploadFile(response.getId(), submission.getPaperFile());
            return ResponseEntity.status(HttpStatus.OK).body(".\"Submission created\"");
        } catch (AmazonServiceException ex) {
            logger.error("Error while uploading file to S3 ");
            throw new GeneralException("Error while uploading file to S3");
        }
    }

    private void verify(Submission submission) {
        if (submission.getPaperFile() == null) throw new SubmissionFileNotFound("Paper file is not found");

        if (submission.getAuthor() == null) throw new DataMissing("Author is not present");

        if (submission.getAuthorEmail().isEmpty()) throw new DataMissing("Author email is empty");
    }

    public ResponseEntity<String> deleteSubmission(String submissionId) {

        try {
            Optional<Submission> submission = submissionRepo.findById(submissionId);
            if (submission.isEmpty())
                throw new SubmissionNotFound(String.format("Submission :%s not present", submissionId));
            submissionRepo.deleteById(submissionId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Submission :%S has been deleted", submissionId));
        } catch (MongoException ex) {
            logger.error("Error happened while deleting submission {}", submissionId, ex);
            throw new GeneralException(String.format("Error happened while deleting submission :%s ", submissionId));
        }

    }

    public ResponseEntity<String> updateSubmission(String submissionId, Submission submission) {

        try {
            Optional<Submission> submissionPresent = submissionRepo.findById(submissionId);
            if (submissionPresent.isEmpty())
                throw new SubmissionNotFound(String.format("Submission :%s not present", submissionId));
            submissionRepo.save(submission);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Submission: %s has been updated ", submissionId));
        } catch (MongoException ex) {
            logger.error("Error occurred while updating submission");
            throw new SubmissionNotFound("Error occurred while updating submission");
        }

    }

    public ResponseEntity<List<Submission>> getAllSubmission() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(submissionRepo.findAll());
        } catch (MongoException ex) {
            logger.error("Error while fetching AllSubmission", ex);
            throw new GeneralException("Error while fetching AllSubmission");
        }
    }

    public ResponseEntity<List<Submission>> submissionByUser(String authorId) {
        try {
            Optional<Author> author = authorRepo.findById(authorId);
            if (author.isEmpty()) throw new AuthorNotFound(String.format("Author not found with id: %s", authorId));
            List<String> allSubmissionId = author.get().getAllSubmission();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(submissionRepo.allSubmissionById(allSubmissionId));

        } catch (MongoException ex) {
            logger.error("Error occured while fetching all submision for author");
            throw new GeneralException("Error occured while fetching all submision for author");
        }

    }
}

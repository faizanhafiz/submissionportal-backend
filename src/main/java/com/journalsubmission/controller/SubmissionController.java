package com.journalsubmission.controller;

import com.journalsubmission.pojo.Submission;
import com.journalsubmission.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController("submission")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/create")
    public ResponseEntity<String> createSubmission(@RequestBody Submission submission) throws IOException {

        return submissionService.createSubmission(submission);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSubmission(@RequestParam String submissionId) {
        return submissionService.deleteSubmission(submissionId);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSubmission(@RequestParam(required = true) String submissionId, @RequestBody Submission submission) {
        return submissionService.updateSubmission(submissionId, submission);
    }

    @GetMapping("/allSubmission")
    public ResponseEntity<List<Submission>> getAllSubmission() {
        return submissionService.getAllSubmission();
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Submission>> submissionByUser(@PathVariable("authorId") String authorId) {
        return submissionService.submissionByUser(authorId);
    }

}
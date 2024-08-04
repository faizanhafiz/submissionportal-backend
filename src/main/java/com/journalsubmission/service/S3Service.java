package com.journalsubmission.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class S3Service {
    private AmazonS3 s3client;
    Logger log = LoggerFactory.getLogger(S3Service.class);
    @Value("${aws.s3.bucket}")
    private String bucketName;

    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        var putObjectResult = s3client.putObject(bucketName, keyName, file.getInputStream(), null);
        log.info("upload file metadaat {}",putObjectResult.getMetadata());
    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }
}

package com.journalsubmission.pojo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;

@Data
@Document("submission")
public class Submission {

    @Id
    private String id;

    private String manuscriptTitle;

    private String manuscriptAbstract;

    private boolean copyrightConfirm;

    private Date submissionDate;

    private Author author;

    private String authorEmail;

    @Transient
    private MultipartFile paperFile;

    private String submissionType;

    private String status; // submitted , accepted , rejected , revised

}

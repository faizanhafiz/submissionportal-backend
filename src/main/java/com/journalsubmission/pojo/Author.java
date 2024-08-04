package com.journalsubmission.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    private String email;
    private String firstName;
    private String lastName;
    private String publishedName;
    private String department;
    private Address address;
    private String organization;
    private List<String> allSubmission;
}

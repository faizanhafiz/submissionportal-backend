package com.journalsubmission.controller;

import com.journalsubmission.pojo.Author;
import com.journalsubmission.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AuthorController {
    private  final AuthorService authorService;
    public  AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Author author){
      return   authorService.signUp(author);
    }
    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(){
        return authorService.signIn();
    }


}

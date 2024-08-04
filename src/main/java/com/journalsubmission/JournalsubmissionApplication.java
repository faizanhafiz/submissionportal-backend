package com.journalsubmission;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.journalsubmission.pojo.Address;
import com.journalsubmission.pojo.Author;
import com.journalsubmission.pojo.Submission;
import com.journalsubmission.repository.SubmissionRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;

@SpringBootApplication
@EnableMongoRepositories
public class JournalsubmissionApplication {
//
//	@Autowired
//	SubmissionRepo submissionRepo;
	public static void main(String[] args) {
		SpringApplication.run(JournalsubmissionApplication.class, args);
	}


//	@PostConstruct
//	public void storeData(){
//		System.out.println("==============");
//		Submission submission = new Submission();
//		submission.setAuthorEmail("faizanhafiz928@gmail.com");
//		submission.setStatus("Submitted");
//		submission.setSubmissionDate(new Date());
//		submission.setCopyrightConfirm(true);
//		submission.setManuscriptTitle("Artificial Intelligence");
//		submission.setManuscriptAbstract("Artificial Intelligence (AI) has transformed various industries by enhancing decision-making processes, optimizing operations, and fostering innovation. This paper explores AI's evolution, focusing on machine learning and neural networks, which enable systems to learn from data and improve over time. We examine applications in healthcare, finance, and transportation, highlighting their impact on efficiency and accuracy. Additionally, ethical considerations, such as bias and privacy, are addressed. The future of AI promises further advancements, including autonomous systems and human-AI collaboration, poised to revolutionize our world and redefine the boundaries of technology.");
//		submission.setAuthor(Author.builder()
//						.email("faizanhafiz928@gmail.com")
//						.firstName("Faizan")
//						.lastName("Ahmad")
//						.publishedName("Faizan Ahmad")
//						.department("Computer Science")
//						.address(Address.builder()
//								.city("Hazaribagh")
//								.state("Jharkhand")
//								.country("India")
//								.postCode(825302)
//								.street("Hashmiya colony")
//								.build())
//				.build());
//	Submission result =submissionRepo.save(submission);
//	if(result!=null){
//		System.out.println("success");
//	}else {
//		System.out.println("failed");
//	}
//
//	}

}

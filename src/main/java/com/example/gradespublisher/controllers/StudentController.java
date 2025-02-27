package com.example.gradespublisher.controllers;

import com.example.gradespublisher.dtos.Student;
import com.example.gradespublisher.publishers.StudentPublisher;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  private final StudentPublisher studentPublisher;

  public StudentController(StudentPublisher studentPublisher) {
    this.studentPublisher = studentPublisher;
  }

  @PostMapping
  public Student publishStudent(@Valid @RequestBody Student student) {
    return studentPublisher.publishStudent(student);
  }
}

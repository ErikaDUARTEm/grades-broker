package com.example.gradesconsumer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {
  @Id
  private String id;
  private String name;
  private String email;
  private Integer level;
  private List<Subject> subjects;
  private Double average;
  private String state;
}

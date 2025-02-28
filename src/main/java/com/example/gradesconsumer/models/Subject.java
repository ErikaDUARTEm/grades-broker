package com.example.gradesconsumer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
  @Id
  private String id;
  private String name;
  private List<Double> grades;
  private Double average;
  private String state;
}
package com.example.gradespublisher.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
  private String name;
  private List<Double> grades;
  private Double average;
  private String state;
}

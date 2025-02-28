package com.example.gradespublisher.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String name;
  private String email;
  @Min(value = 1, message = "EL grado mínima es 1")
  @Max(value = 11, message = "El grado máximo es 11")
  private Integer grade;
  private List<Subject> subjects;
  private Double average;
  private String state;
}

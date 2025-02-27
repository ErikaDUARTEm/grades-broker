package com.example.gradespublisher.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
  private String name;
  @Valid
  @NotEmpty(message = "La lista de notas no puede estar vacía")
  private List<Grade> grades;
  private Double average;
  private String state;
}

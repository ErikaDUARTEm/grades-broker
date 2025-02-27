package com.example.gradesconsumer.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
  @Min(value = 1, message = "La nota mínima es 1")
  @Max(value = 5, message = "La nota máxima es 5")
  private Double value;
}

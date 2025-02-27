package com.example.gradesconsumer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeId implements Serializable {
    private Subject subject;
    private Student student;
}

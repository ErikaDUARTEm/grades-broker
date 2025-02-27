package com.example.gradesconsumer.dtos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(GradeId.class)
@Table(name = "grades")
public class Grade {

  private Double value;

  @EmbeddedId
  @ManyToOne
  @JoinColumn(name = "subject_id", nullable = false)
  private Subject subject;

  @EmbeddedId
  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;
}

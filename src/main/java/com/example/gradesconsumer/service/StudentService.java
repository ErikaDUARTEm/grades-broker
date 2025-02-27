package com.example.gradesconsumer.service;

import com.example.gradesconsumer.dtos.Grade;
import com.example.gradesconsumer.dtos.Student;
import com.example.gradesconsumer.dtos.Subject;
import com.example.gradesconsumer.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Transactional
  public void saveStudent(Student student) {
    if (student != null && student.getSubjects() != null) {
      setStudentSubjects(student);
      System.out.println("Guardando estudiante: " + student);
      studentRepository.save(student);
      System.out.println("Se ha guardado el estudiante con id: " + student.getId());
    }
  }

  private void setStudentSubjects(Student student) {
    for (Subject subject : student.getSubjects()) {
      subject.setStudent(student);
      setSubjectGrades(subject);
      subject.setId(null);
    }
  }

  private void setSubjectGrades(Subject subject) {
    if (subject.getGrades() != null) {
      for (Grade grade : subject.getGrades()) {
        grade.setSubject(subject);

      }
    }
  }
}

package com.example.gradesconsumer.service;

import com.example.gradesconsumer.models.Student;
import com.example.gradesconsumer.repositories.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
  private final IStudentRepository studentRepository;

  public StudentService(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Transactional
  public void saveStudent(Student student) {
    if (student.getSubjects() != null) {
      student.getSubjects().forEach(subject -> subject.setId(null));
    }

    System.out.println("Guardando estudiante con nombre: " + student.getName());
    studentRepository.save(student);
    System.out.println("Se ha guardado el estudiante con id: " + student.getId());
  }
}
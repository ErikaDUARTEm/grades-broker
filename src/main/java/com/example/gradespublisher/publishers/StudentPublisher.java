package com.example.gradespublisher.publishers;

import com.example.gradespublisher.dtos.Student;
import com.example.gradespublisher.dtos.Subject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class StudentPublisher {
  private final RabbitTemplate rabbitTemplate;
  
  @Value("${rabbitmq.queue}")
  private String queue;
  
  public StudentPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }
  
  public Student publishStudent(Student student) {
    student.getSubjects().forEach(subject -> subject.getGrades().forEach(grade -> {
      if(grade < 1.0 || grade > 5.0) {
        throw new IllegalArgumentException("La nota no puede ser menor a 1 o mayor a 5");
      }
    }));
    calculateGradePointAverage(student);

    calculateSubjectPointAverage(student);

    rabbitTemplate.convertAndSend(queue, student);
    return student;
  }

  private void calculateGradePointAverage(Student student) {
    student.getSubjects().forEach(subject -> {
      double average = subject.getGrades().stream().mapToDouble(Double::doubleValue).sum() / subject.getGrades().size();
      subject.setAverage(Math.round(average * 100.0) / 100.0);
      if(subject.getAverage() >= 3.0) {
        subject.setState("Materia aprobada");
      } else {
        subject.setState("Materia reprobada");
      }
    });
  }

  private void calculateSubjectPointAverage(Student student) {
    double average = student.getSubjects().stream().mapToDouble(Subject::getAverage).sum() / student.getSubjects().size();
    student.setAverage(Math.round(average * 100.0) / 100.0);
    boolean areAllSubjectsApproved = student.getSubjects().stream().allMatch(subject -> subject.getState().equals("Materia aprobada"));

    if(areAllSubjectsApproved) {
      student.setState("Año aprobado");
    } else {
      student.setState("Año reprobado");
    }
  }
}

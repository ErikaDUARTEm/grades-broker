package com.example.gradesconsumer.consumer;

import com.example.gradesconsumer.models.Student;
import com.example.gradesconsumer.service.StudentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class GradeConsumer {
  private final StudentService studentService;

  public GradeConsumer(StudentService studentService) {
    this.studentService = studentService;
  }

  @RabbitListener(queues = "grades_queue")
  public void receiveMessage(Student student){
    System.out.println("Estudiante recibido " + student);
    studentService.saveStudent(student);
  }
}

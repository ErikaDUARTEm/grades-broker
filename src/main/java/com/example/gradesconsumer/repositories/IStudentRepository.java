package com.example.gradesconsumer.repositories;

import com.example.gradesconsumer.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends MongoRepository<Student, String> {
}

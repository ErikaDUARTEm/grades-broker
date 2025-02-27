package com.example.gradesconsumer.repositories;

import com.example.gradesconsumer.dtos.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

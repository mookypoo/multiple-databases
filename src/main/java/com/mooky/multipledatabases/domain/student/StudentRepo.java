package com.mooky.multipledatabases.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooky.multipledatabases.domain.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
  
}

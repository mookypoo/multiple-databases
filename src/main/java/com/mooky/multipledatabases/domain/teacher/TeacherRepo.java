package com.mooky.multipledatabases.domain.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooky.multipledatabases.domain.teacher.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long>{
  
}

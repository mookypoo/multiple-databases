package com.mooky.multipledatabases.domain.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooky.multipledatabases.domain.student.entity.Student;
import com.mooky.multipledatabases.domain.student.vo.StudentRes;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
  
  private @Autowired StudentRepo studentRepo;

  public List<StudentRes> getAllStudents() {
    List<Student> students = this.studentRepo.findAll();
    return students.stream().map(s -> new StudentRes(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail()))
        .toList();
  }
  
  @Transactional
  public String changeEmail(long id, String newEmail) {
    final Student student = this.studentRepo.findById(id).orElseThrow();
    student.changeEmail(newEmail);
    return newEmail;
  }
}

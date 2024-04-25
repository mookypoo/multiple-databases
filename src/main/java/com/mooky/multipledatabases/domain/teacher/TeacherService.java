package com.mooky.multipledatabases.domain.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooky.multipledatabases.domain.teacher.entity.Teacher;
import com.mooky.multipledatabases.domain.teacher.vo.TeacherRes;

@Service
public class TeacherService {
  
  private @Autowired TeacherRepo teacherRepo;

  public List<TeacherRes> getAllTeachers() {
    List<Teacher> teachers = this.teacherRepo.findAll();
    return teachers.stream().map(s -> new TeacherRes(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail()))
        .toList();
  }

}

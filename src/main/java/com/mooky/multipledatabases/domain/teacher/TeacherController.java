package com.mooky.multipledatabases.domain.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooky.multipledatabases.domain.teacher.vo.TeacherRes;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
  
  private @Autowired TeacherService teacherService;

  @GetMapping("/all")
  public List<TeacherRes> getTeachers() {
    return this.teacherService.getAllTeachers();
  }

}

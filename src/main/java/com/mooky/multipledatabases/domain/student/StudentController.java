package com.mooky.multipledatabases.domain.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooky.multipledatabases.domain.student.vo.StudentRes;

@RestController
@RequestMapping("/student")
public class StudentController {

  private @Autowired StudentService studentService;
  
  @GetMapping("/all")
  public List<StudentRes> getStudents() {
    return this.studentService.getAllStudents();
  }

  @PostMapping("/{studentId}/change/email")
  public Map<String, String> changeEmail(@PathVariable("studentId") Long id, @RequestBody Map<String, String> body) {
    return Map.of("new email", this.studentService.changeEmail(id, body.get("email")));
  }
}
